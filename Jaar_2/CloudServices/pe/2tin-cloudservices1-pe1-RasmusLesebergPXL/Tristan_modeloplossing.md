# PE 1 - AWS CLI & Troubleshooting

## Allowed documentation
- This file.
- https://docs.aws.amazon.com/index.html
- https://docs.aws.amazon.com/cli/latest/index.html
- https://docs.aws.amazon.com/cli/index.html

## 1 - Compute

### Create and Store Key Pairs

```bash
# View all key pairs
$ aws ec2 describe-key-pairs

# View information specific key pair
$ aws ec2 describe-key-pairs \
--key-name <key_name>

# Creates a key pair and stores it in a file
$ aws ec2 create-key-pair \
--key-name <key_name> \
--query 'KeyMaterial' \
--output text > key_name.pem

# Delete a key pair
$ aws ec2 delete-key-pair \
--key-name <key_name>
```

### Create Security Groups

```bash
# Create a security group associated with VPC
$ aws ec2 create-security-group \
--group-name my-sg \
--description "My security group" \
--vpc-id vpc-1a2b3c4d

# Create a security group without specifying VPC (course)
$ aws ec2 create-security-group \
--group-name ssh-access-cli \
--description "sec group for ssh access from anywhere"

# List all security groups
$ aws ec2 describe-security-groups

# View more information for a security group
$ aws ec2 describe-security-groups \
--group-ids sg-903004f8

# Add rules to a security group
$ aws ec2 authorize-security-group-ingress \
--group-name ssh-access-cli \
--protocol tcp \
--port 22 \
--cidr 0.0.0.0/0

# Delete a security group
$ aws ec2 delete-security-group \
--group-id sg-90aws
```

### Create, search and filter AMI images

```bash
# Create an AMI of an EC2 instance
$ aws ec2 create-image \
--instance-id <instance-id> \
--name "base docker compose image" \
--query ImageId \
--output text

# Search the 5 latest ubuntu 22. AMIs based on name
$ aws ec2 describe-images \
--owners amazon \
--region us-east-1 \
--filters 'Name=name,Values=*ubuntu*22.*' 'Name=virtualization-type,Values=hvm'\
--query 'reverse(sort_by(Images,&CreationDate))[:5].{id:ImageId,date:CreationDate,name:Name}' \
--output text

# Search the 5 latest Amazon Linux AMIs based on description
$ aws ec2 describe-images \
--owners amazon \
--region us-east-1 \
--filters 'Name=description,Values=*Amazon Linux AMI*' 'Name=virtualization-type,Values=hvm' \
--query 'reverse(sort_by(Images,&CreationDate))[:5].{id:ImageId,date:CreationDate,name:Name}' \
--output text
```

### Create EC2 Instances

```bash
# Launch an ec2 instance
$ aws ec2 run-instances 
--image-id ami-005f9685cb30f234b \
--instance-type t2.micro \
--key-name vockey \
--security-group-ids <security-group-id> \
--tag-specifications 'ResourceType=instance, Tags=[{Key=Name, Value=my-first-cli-ec2}]' \
--count 1 \
--subnet-id subnet-6e7f829e

# List ec2 instances
$ aws ec2 describe-instances

# List a specific ec2 instance
$ aws ec2 describe-instances \
--instance-ids <instance-id>

# List name, id, subnet and security group of an ec2 instance
$ aws ec2 describe-instances | grep ‘Value|InstanceId|Subnet|GroupId’

# Get the public ip address of an ec2 instace
$ aws ec2 describe-instances \
--filters "Name=instance-id,Values=<instance-id>" \
--query 'Reservations[*].Instances[*].PublicIpAddress' \
--output text

# Get the private ip address of an ec2 instance
$ aws ec2 describe-instances \
--filters "Name=instance-id,Values=<frontend-instance-id>" \
--query 'Reservations[*].Instances[*].PrivateIpAddress' \
--output text

# Create tag and link to ec2 instance
$ aws ec2 create-tags \
--resources i-5203422c \
--tags Key=Name,Value=MyInstance

# List ec2 instances using a filter on t2.micro and output only the instance-id
$ aws ec2 describe-instances \
--filters "Name=instance-type,Values=t2.micro" \
--query "Reservations[].Instances[].InstanceId"

# Terminate an ec2 instance
$ aws ec2 terminate-instances \
--instance-ids i-5203422c
```

## 2 - Storage
```bash
# Create a new S3 Bucket (unique name)
$ aws s3 mb s3://<bucket_name>

# Create a directory inside a S3 bucket
$ aws s3api put-object \
--bucket <bucket_name>
--key <directory>/

# View the content of a S3 bucket
$ aws s3 ls s3://<bucket_name>

# Copy file from client to s3 bucket
$ aws s3 cp /var/log/cloud-init.log s3://pxl-cli-bucket-1/logs/cloud.log --recursive

# Sync folder on s3 bucket
$ aws s3 sync /awsgen s3://pxl-cli-bucket-1/backend-data/
```
## 3 - Networking

```bash
# Create a new VPC (virtual private cloud)
$ aws ec2 create-vpc \
--cidr-block 10.0.0.0/16 \
--region us-east-1 \
--tag-specifications 'ResourceType=vpc,Tags=[{Key=Name,Value=wordpress}]' \
--query Vpc.VpcId \
--output text

# Enable DNS hostnames for the VPC
$ aws ec2 modify-vpc-attribute \
--vpc-id <wordpress-vpc-id> \
--enable-dns-hostnames "{\"Value\":true}"

# Get info about a VPC
$ aws ec2 describe-vpcs \
--vpc-ids <wordpress-vpc-id>

# Create a route table for a VPC
$ aws ec2 create-route-table \
--vpc-id <wordpress-vpc-id> \
--tag-specifications 'ResourceType=route-table,Tags=[{Key=Name,Value=wordpress}]' \
--query RouteTable.RouteTableId \
--output text

# Create a public subnet
$ aws ec2 create-subnet --vpc-id <wordpress-vpc-id> \
--cidr-block 10.0.0.0/24 \
--availability-zone us-east-1a \
--tag-specifications 'ResourceType=subnet,Tags=[{Key=Name,Value=wordpress-public}]' \
--query Subnet.SubnetId \
--output text

# Create a private subnet
$ aws ec2 create-subnet --vpc-id <wordpress-vpc-id> \
--cidr-block 10.0.0.0/24 \
--availability-zone us-east-1a \
--tag-specifications 'ResourceType=subnet,Tags=[{Key=Name,Value=wordpress-private}]' \
--query Subnet.SubnetId \
--output text

# Associate subnet with the route table
$ aws ec2 associate-route-table \
--route-table-id <wordpress-rt-id> \
--subnet-id <public-subnet-id>

# Enable auto-assign public IPv4 address for the public subnet
$ aws ec2 modify-subnet-attribute \
--subnet-id <public-subnet-id> \
--map-public-ip-on-launch

# Create an internet gateway
$ aws ec2 create-internet-gateway \
--tag-specifications 'ResourceType=internet-gateway,Tags=[{Key=Name,Value=wordpress}]' \
--query InternetGateway.InternetGatewayId \
--output text

# Attach the internet gateway to the VPC
$ aws ec2 attach-internet-gateway \
--internet-gateway-id <wordpress-igw-id> \
--vpc-id <wordpress-vpc-id>

# Create a route for the internet gateway
aws ec2 create-route \
--route-table-id <wordpress-rt-id> \
--destination-cidr-block 0.0.0.0/0 \
--gateway-id <wordpress-igw-id>

# Create a security group for the VPC
$ aws ec2 create-security-group \
--group-name "wordpress" \
--description "sec group for wordpress" \
--vpc-id <wordpress-vpc-id> \
--query GroupId \
--output text

# Allow HTTP and HTTPS traffic to the security group
$ aws ec2 authorize-security-group-ingress \
--group-id <wordpress-sg-id> \
--protocol tcp \
--port 80 \
--cidr 0.0.0.0/0 \
--region us-east-1

$ aws ec2 authorize-security-group-ingress \
--group-id <wordpress-sg-id> \
--protocol tcp \
--port 443 \
--cidr 0.0.0.0/0 \
--region us-east-1

# Link the labinstanceprofile role
$ aws ec2 associate-iam-instance-profile \
--instance-id <backend-instance-id> \
--iam-instance-profile Name=LabInstanceProfile

# Create elastic IP
$ aws ec2 allocate-address --domain vpc \
--query AllocationId \
--output text

# Associate the elastic IP to an instance
$ aws ec2 associate-address \
--instance-id <backend-instance-id> \
--allocation-id <allocation-id> \
--query PublicIp \
--output text

# Get the default VPC
$ aws ec2 describe-vpcs \
--filters Name=isDefault,Values=true \
--query "Vpcs[0].VpcId" \
--output text

# Get the subnets of default vpc
$ aws ec2 describe-subnets \
--filters Name=vpc-id,Values=<default-vpc-id> Name=default-for-az,Values=true \
--query "Subnets[0].SubnetId" \
--output text

# Create a target group for the frontend
$ aws elbv2 create-target-group \
--name awsgen-frontend-tg \
--protocol HTTP \
--port 80 \
--vpc-id <default-vpc-id> \
--query 'TargetGroups[0].TargetGroupArn' \
--output text

# Add instances to the target group
$ aws elbv2 register-targets \
--target-group-arn <target-group-arn> \
--targets Id=<frontend-instance-id> Id=<frontend-instance-id>

# Get the subnet of the frontend instance
$ aws ec2 describe-instances \
--instance-ids <frontend-instance-id> \
--query "Reservations[0].Instances[0].SubnetId" \
--output text

# Create a load balancer
$ aws elbv2 create-load-balancer \
--name awsgen-frontend-lb \
--scheme internet-facing \
--type application \
--ip-address-type ipv4 \
--subnets <default-public-subnet-id-1> <default-public-subnet-id-1>_1 \
--security-groups <sg-id> \
--query 'LoadBalancers[0].LoadBalancerArn' \
--output text

# Create a listener for the load balancer
$ aws elbv2 create-listener \
--load-balancer-arn <load-balancer-arn> \
--protocol HTTP \
--port 80 \
--default-actions Type=forward,TargetGroupArn=<target-group-arn>

# Create a launch template for the frontend
$ aws ec2 create-launch-template \
--launch-template-name awsgen-frontend-launch-template \
--launch-template-data ImageId=<frontend-ami-id>,InstanceType=t2.micro,KeyName=vockey,SecurityGroupIds=<sg-id> \
--query LaunchTemplate.LaunchTemplateId \
--output text

# Create an auto scaling group for the frontend
$ aws autoscaling create-auto-scaling-group \
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

# Show load balancer DNS name
$ aws elbv2 describe-load-balancers \
--load-balancer-arns <load-balancer-arn> \
--query 'LoadBalancers[0].DNSName' \
--output text
```

## SSH/AWS CLI Connection
```bash
# Linking AWS CLI to AWS Environment
$ aws configure

# Alternative:
$ code ~/.aws/credentials
```

```bash
# Key can be downloaded from learner lab >> aws details

# Change permissons
$ chmod 400 labuser.pem

# Use key in SSH-command
$ ssh ec2-user@<host-ip> -i labuser.pem

# ec2-user == default user
```