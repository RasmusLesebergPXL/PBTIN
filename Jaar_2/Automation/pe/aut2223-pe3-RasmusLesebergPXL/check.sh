#!/bin/bash
vagrant destroy -f
vagrant up
ssh-keygen -R [127.0.0.1]:2222
ansible-playbook -i hosts.ini playbook.yml
read -n 1 -s -r -p "Take screenshot1.png and save it then press any key to continue"
ansible-playbook -i hosts.ini playbook.yml
read -n 1 -s -r -p "Take screenshot2.png and save it then press any key to continue"
vagrant ssh webserver1 -c 'curl 127.0.0.1:8080;sudo firewall-cmd --list-all'
read -n 1 -s -r -p "Take screenshot3.png and save it then press any key to continue"
echo -e "\nNow commit your 3 screenshots.\n"
