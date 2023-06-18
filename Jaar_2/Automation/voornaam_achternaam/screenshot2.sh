#!/bin/bash
ansible-playbook -i hosts.ini playbook.yml --vault-password-file ./vault_password_file
echo "Neem screenshot2.png"
