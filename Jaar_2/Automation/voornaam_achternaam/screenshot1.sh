#!/bin/bash
vagrant destroy -f
vagrant up
vagrant ssh webserver1 -c "systemctl list-unit-files --type=service | awk '{print $1}' " > before_services.txt
ansible-playbook -i hosts.ini playbook.yml --vault-password-file ./vault_password_file
echo "Neem screenshot1.png"
