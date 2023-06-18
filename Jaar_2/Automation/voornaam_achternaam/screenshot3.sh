#!/bin/bash
vagrant ssh webserver1 -c 'curl 127.0.0.1:8080;ls -la /home;sudo ls -la /home/musa/www'
vagrant ssh webserver1 -c 'echo "admin123" | su -c "whoami" musa'
vagrant ssh webserver1 -c 'echo "admin123" | su -c "whoami" ahmed'
vagrant ssh webserver1 -c "systemctl list-unit-files --type=service | awk '{print $1}' " > after_services.txt
new_service=$(diff before_services.txt after_services.txt | grep '>'| awk '{print $2}' | head -n 1)
echo -e "$new_service: "
vagrant ssh webserver1 -c "systemctl is-active $new_service"
echo "Neem screenshot3.png"
