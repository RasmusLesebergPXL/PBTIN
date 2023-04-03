# Labs

## 1. Introduction

AWS Academy -> Learner Lab -> AWS Details
- Add AWS CLI credentials to ~/.aws/credentials
- Download SSH key

## 2. Compute

Create a security group for the bastion instance
```shell
aws ec2 create-security-group \
--group-name "ssh-access-cli"  \
--description "sec group for ssh access from anywhere" \
--query GroupId \
--output text
```

Authorize SSH acccess from anywhere to the bastion instance
```shell
aws ec2 authorize-security-group-ingress \
--group-name ssh-access-cli \
--protocol tcp \
--port 22 \
--cidr 0.0.0.0/0
```

Search for the latest Amazon Linux 2 AMI
```shell
aws ec2 describe-images \
--owners amazon \
--filters 'Name=description,Values=Amazon Linux AMI*' \
--query 'sort_by(Images, &CreationDate)[0].ImageId' \
--output text
```

Create the bastion instance
```shell
aws ec2 run-instances --image-id <ami-id> \
--instance-type t2.micro \
--key-name vockey \
--security-group-ids <sg-id> \
--tag-specifications 'ResourceType=instance, Tags=[{Key=Name, Value=my-first-ec2}]' \
--count 1 \
--block-device-mappings '[{"DeviceName":"/dev/xvda","Ebs":{"VolumeSize":8,"VolumeType":"gp2"}}]' \
--query 'Instances[0].InstanceId' \
--output text
```

Get instance details
```shell
aws ec2 describe-instances --instance-ids <instance-id>
```

Get instance ip
```shell
aws ec2 describe-instances --filters "Name=instance-id,Values=<instance-id>" \
--query 'Reservations[*].Instances[*].PublicIpAddress' \
--output text
```

SSH into the bastion instance and do all the Docker stuff
```shell
ssh -i vockey.pem ec2-user@<instance-ip>
```

Create an AMI
```shell
aws ec2 create-image --instance-id <instance-id> \
--name "base docker compose image" \
--query ImageId \
--output text
```

View AMI details
```shell
aws ec2 describe-images --image-ids <docker-compose-ami-id>
```

Create a security group for the frontend and backend instances
```shell
aws ec2 create-security-group \
--group-name "awsgen app sg" \
--description "sec group for awsgen app" \
--query GroupId \
--output text
```

View security group details
```shell
aws ec2 describe-security-groups --group-ids <sg-id>
```

Authorize SSH access for the bastion server to the frontend and backend 
```shell
aws ec2 authorize-security-group-ingress \
--group-id <sg-id> \
--protocol tcp \
--port 22 \
--source-group <bastion-sg-id>
```

Authorize HTTP access from anywhere to the frontend and backend
```shell
aws ec2 authorize-security-group-ingress \
--group-id <sg-id> \
--protocol tcp \
--port 80 \
--cidr 0.0.0.0/0
```

Create an EC2 instance for the frontend app
```shell
aws ec2 run-instances \
--image-id <docker-compose-ami-id> \
--instance-type t2.micro \
--key-name vockey \
--security-group-ids <sg-id> \
--tag-specifications 'ResourceType=instance, Tags=[{Key=Name, Value=frontend}]' \
--count 1 \
--query 'Instances[0].InstanceId' \
--output text
```

Get private frontend instance ip
```shell
aws ec2 describe-instances \
--filters "Name=instance-id,Values=<frontend-instance-id>" \
--query 'Reservations[*].Instances[*].PrivateIpAddress' \
--output text
```

Create an EC2 instance for the backend app
```shell
aws ec2 run-instances \
--image-id <docker-compose-ami-id> \
--instance-type t2.micro \
--key-name vockey \
--security-group-ids <sg-id> \
--tag-specifications 'ResourceType=instance, Tags=[{Key=Name, Value=backend}]' \
--count 1 \
--query 'Instances[0].InstanceId' \
--output text
```

View instances details
```shell
aws ec2 describe-instances --instance-ids <frontend-instance-id> <backend-instance-id>
```

Get private backend instance ip
```shell
aws ec2 describe-instances \
--filters "Name=instance-id,Values=<backend-instance-id>" \
--query 'Reservations[*].Instances[*].PrivateIpAddress' \
--output text
```

Copy `vockey.pem` to the bastion instance
```shell
scp -i vockey.pem vockey.pem ec2-user@<instance-ip>:~/
```

Now you can SSH into the frontend and backend instances from the bastion instance and do all the remaining Docker stuff. 

Get public frontend instance ip
```shell
aws ec2 describe-instances \
--filters "Name=instance-id,Values=<frontend-instance-id>" \
--query 'Reservations[*].Instances[*].PublicIpAddress' \
--output text
```

Visit the frontend instance in a browser.

Get backend instance public ip
```shell
aws ec2 describe-instances \
--filters "Name=instance-id,Values=<backend-instance-id>" \
--query 'Reservations[*].Instances[*].PublicIpAddress' \
--output text
```

Visit `http://backend-public-ip/api/health` in a browser.

## 3. Storage

Create a bucket (bucket names are unique so you need to change the name)
```shell
aws s3 mb s3://backend-bucket-awsgen
```

Create a logs directory in the bucket
```shell
aws s3api put-object --bucket backend-bucket-awsgen --key logs/
```

View the contents of the bucket
```shell
aws s3 ls s3://backend-bucket-awsgen
```

Upload a file from the server's /var/log directory to the logs directory on the bucket
```shell
aws s3 cp /var/log s3://backend-bucket-awsgen/logs/ --recursive
```

View the contents of the logs directory on the bucket
```shell
aws s3 ls s3://backend-bucket-awsgen/logs/
```

Create a new directory in the bucket called "backend-data" and sync this folder with the docker mounted volume for the backend container
```shell
aws s3api put-object --bucket backend-bucket-awsgen --key backend-data/
sudo aws s3 sync /var/lib/docker/volumes/<volume-id> s3://backend-bucket-awsgen/backend-data/
```

## 4. Networking

Create a VPC
```shell
aws ec2 create-vpc \
--cidr-block 10.0.0.0/16 \
--region us-east-1 \
--tag-specifications 'ResourceType=vpc,Tags=[{Key=Name,Value=wordpress}]' \
--query Vpc.VpcId \
--output text
```

Enable DNS hostnames for the VPC
```shell
aws ec2 modify-vpc-attribute \
--vpc-id <wordpress-vpc-id> \
--enable-dns-hostnames "{\"Value\":true}"
```

Check if the VPC is available
```shell
aws ec2 describe-vpcs --vpc-ids <wordpress-vpc-id>
```

Create a route table for the VPC
```shell
aws ec2 create-route-table \
--vpc-id <wordpress-vpc-id> \
--tag-specifications 'ResourceType=route-table,Tags=[{Key=Name,Value=wordpress}]' \
--query RouteTable.RouteTableId \
--output text
```

Create a public subnet
```shell
aws ec2 create-subnet --vpc-id <wordpress-vpc-id> \
--cidr-block 10.0.0.0/24 \
--availability-zone us-east-1a \
--tag-specifications 'ResourceType=subnet,Tags=[{Key=Name,Value=wordpress-public}]' \
--query Subnet.SubnetId \
--output text
```

Create a private subnet
```shell
aws ec2 create-subnet --vpc-id <wordpress-vpc-id> \
--cidr-block 10.0.1.0/24 \
--availability-zone us-east-1a \
--tag-specifications 'ResourceType=subnet,Tags=[{Key=Name,Value=wordpress-private}]' \
--query Subnet.SubnetId \
--output text
```

Associate the public subnet with the route table
```shell
aws ec2 associate-route-table \
--route-table-id <wordpress-rt-id> \
--subnet-id <public-subnet-id>
```

Associate the private subnet with the route table
```shell
aws ec2 associate-route-table \
--route-table-id <wordpress-rt-id> \
--subnet-id <private-subnet-id>
```

Enable auto-assign public IPv4 address for the public subnet
```shell
aws ec2 modify-subnet-attribute \
--subnet-id <public-subnet-id> \
--map-public-ip-on-launch
```

Create an internet gateway
```shell
aws ec2 create-internet-gateway \
--tag-specifications 'ResourceType=internet-gateway,Tags=[{Key=Name,Value=wordpress}]' \
--query InternetGateway.InternetGatewayId \
--output text
```

Attach the internet gateway to the VPC
```shell
aws ec2 attach-internet-gateway \
--internet-gateway-id <wordpress-igw-id> \
--vpc-id <wordpress-vpc-id>
```

Create a route for the internet gateway
```shell
aws ec2 create-route \
--route-table-id <wordpress-rt-id> \
--destination-cidr-block 0.0.0.0/0 \
--gateway-id <wordpress-igw-id>
```

Create a security group for the VPC
```shell
aws ec2 create-security-group \
--group-name "wordpress" \
--description "sec group for wordpress" \
--vpc-id <wordpress-vpc-id> \
--query GroupId \
--output text
```

Allow HTTP and HTTPS traffic to the security group
```shell
aws ec2 authorize-security-group-ingress \
--group-id <wordpress-sg-id> \
--protocol tcp \
--port 80 \
--cidr 0.0.0.0/0 \
--region us-east-1
```

```shell
aws ec2 authorize-security-group-ingress \
--group-id <wordpress-sg-id> \
--protocol tcp \
--port 443 \
--cidr 0.0.0.0/0 \
--region us-east-1
```

Create a new key pair
```shell
aws ec2 create-key-pair --key-name wordpress \
--query 'KeyMaterial' \
--output text > wordpress.pem
```

Link the `LabInstanceProfile` role to the backend instance
```shell
aws ec2 associate-iam-instance-profile \
--instance-id <backend-instance-id> \
--iam-instance-profile Name=LabInstanceProfile
```

Now you visit the frontend and create new Wordpress instances.

Create elastic IP for the backend
```shell
aws ec2 allocate-address --domain vpc \
--query AllocationId \
--output text
```

Associate the elastic IP with the backend
```shell
aws ec2 associate-address \
--instance-id <backend-instance-id> \
--allocation-id <allocation-id> \
--query PublicIp \
--output text
```

Add this IP to the frontend docker-compose file.

Create a AMI from the frontend instance
```shell
aws ec2 create-image \
--instance-id <frontend-instance-id> \
--name "awsgen-frontend" \
--query ImageId \
--output text
```

Get the default VPC
```shell
aws ec2 describe-vpcs \
--filters Name=isDefault,Values=true \
--query "Vpcs[0].VpcId" \
--output text
```

Get the subnets of the default VPC
```shell
aws ec2 describe-subnets \
--filters Name=vpc-id,Values=<default-vpc-id> Name=default-for-az,Values=true \
--query "Subnets[0].SubnetId" \
--output text
```

Create a new instance called frontend-2
```shell
aws ec2 run-instances \
--image-id <frontend-ami-id> \
--count 1 \
--instance-type t2.micro \
--key-name vockey \
--security-group-ids <sg-id> \
--subnet-id <default-public-subnet-id-1>_1 \
--associate-public-ip-address \
--query 'Instances[0].InstanceId' \
--output text
```

Create a target group for the frontend
```shell
aws elbv2 create-target-group \
--name awsgen-frontend-tg \
--protocol HTTP \
--port 80 \
--vpc-id <default-vpc-id> \
--query 'TargetGroups[0].TargetGroupArn' \
--output text
```

Add both frontend instances to the target group
```shell
aws elbv2 register-targets \
--target-group-arn <target-group-arn> \
--targets Id=<frontend-instance-id> Id=<frontend-instance-id>
```

Get the subnet of the frontend instance
```shell
aws ec2 describe-instances \
--instance-ids <frontend-instance-id> \
--query "Reservations[0].Instances[0].SubnetId" \
--output text
```

Create a load balancer
```shell
aws elbv2 create-load-balancer \
--name awsgen-frontend-lb \
--scheme internet-facing \
--type application \
--ip-address-type ipv4 \
--subnets <default-public-subnet-id-1> <default-public-subnet-id-1>_1 \
--security-groups <sg-id> \
--query 'LoadBalancers[0].LoadBalancerArn' \
--output text
```

Create a listener for the load balancer
```shell
aws elbv2 create-listener \
--load-balancer-arn <load-balancer-arn> \
--protocol HTTP \
--port 80 \
--default-actions Type=forward,TargetGroupArn=<target-group-arn>
```

Create launch template for the frontend
```shell
aws ec2 create-launch-template \
--launch-template-name awsgen-frontend-launch-template \
--launch-template-data ImageId=<frontend-ami-id>,InstanceType=t2.micro,KeyName=vockey,SecurityGroupIds=<sg-id> \
--query LaunchTemplate.LaunchTemplateId \
--output text
```

Create an auto scaling group for the frontend
```shell
aws autoscaling create-auto-scaling-group \
--auto-scaling-group-name awsgen-frontend-asg \
--launch-template LaunchTemplateId=<launch-template-id> \
--vpc-zone-identifier <default-public-subnet-id-1>,<default-public-subnet-id-2> \
--min-size 1 \
--max-size 5 \
--desired-capacity 1 \
--target-group-arns <target-group-arn> \
--tags Key=Name,Value="awsgen frontend" \
--query AutoScalingGroupARN \
--output text
```

Terminate both frontend instances
```shell
aws ec2 terminate-instances \
--instance-ids <frontend-instance-id> <frontend-instance-id>
```

Show load balancer DNS name
```shell
aws elbv2 describe-load-balancers \
--load-balancer-arns <load-balancer-arn> \
--query 'LoadBalancers[0].DNSName' \
--output text
```

Now you should be able to visit the load balancer DNS name and see the frontend application.
