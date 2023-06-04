# Opdracht: Webserver configureren met Ansible
Je hebt 1 virtuele machine gekregen: 'webserver1'. Het is jouw taak om een Ansible playbook te schrijven dat nginx installeert en configureert.

## Minimum (10/20)
- Maak een nieuwe directory gedefinieerd door een variabele `doc_root`, als die nog niet bestaat. Geef de waarde '/var/www/mypage' aan `doc_root`.
- Gebruik `landing-page.html.j2` om `index.html` aan te maken in de directory gedefinieerd door `doc_root`.
- Maak en gebruik een template `nginx.conf.j2` om een serverconfiguratiebestand op te zetten in `/etc/nginx/conf.d/mypage.conf`. Maak het parameteriseerbaar en zorg er onder meer voor dat '/var/www/' uiteindelijk ook wordt vervangen door '/var/www/mypage'.
- Zorg ervoor dat Nginx herstart wordt wanneer de serverconfiguratie wordt gewijzigd.
- Gebruik de parameteriseerbare poort 8080 voor alle services in deze oefening, dmv van een variabele `web_port`.
## Extra 1 (1 punt)
- alle variabelen worden toegekend dmv een externe file.
## Extra 2 (3 punten)
- Als het bestand `index.html` niet bestaat, gebruik dan `landing-page.html.j2` om het aan te maken in de directory gedefinieerd door `doc_root`. Sla deze taak over als `index.html` wel bestaat op de remote host.
## Extra 3 (3 punten)
- Sta traffic toe op de tcp-poort gedefineerd door een variabele `web_port`, zorg ervoor dat deze rule permanent wordt toegepast.
- Gebruik de parameteriseerbare poort 8080 voor alle services in deze oefening.
- Zorg ervoor dat als er wijzigingen worden aangebracht in de firewalld instellingen, deze service wordt herstart.
## Extra 4 (3 punten)
- Stop alles in een role en start deze role mbv de file `role_playbook.yml` die je aanmaakt.

## Oplevering - deel 1 - voor de deadline
- Zorg dat alle bestanden ingecheckt zijn voor de deadline. Bestanden zelfs 1 minuut na de deadline worden genegeerd. Commits na de deadline betekent -2.
## Oplevering - deel 2 - na de deadline
- Maak je text terminal full screen, run volgend commando vanop je laptop, maak 3 screenshots, en check de screenshots in:
```
./test.sh
```
- Check de 3 screenshots in. Dit zijn de enige files die iets na de deadline mogen gecommit worden.

## Extra Info
- RHEL9 package name voor nginx is 'nginx'.
- RHEL9 package name voor firewalld is 'firewalld'
- https://docs.ansible.com/ansible/latest/collections/ansible/builtin/package_module.html
- https://docs.ansible.com/ansible/latest/collections/ansible/builtin/file_module.html
- Je mag commands gebruiken, maar enkel voor "read-only" operaties: https://docs.ansible.com/ansible/latest/collections/ansible/builtin/command_module.html
- https://docs.ansible.com/ansible/latest/collections/ansible/builtin/stat_module.html#ansible-collections-ansible-builtin-stat-module
- https://docs.ansible.com/ansible/latest/collections/ansible/builtin/template_module.html
- https://docs.ansible.com/ansible/latest/collections/ansible/posix/firewalld_module.html
- https://docs.ansible.com/ansible/latest/collections/ansible/builtin/service_module.html
- https://docs.ansible.com/ansible/latest/playbook_guide/playbooks_handlers.html
- https://docs.ansible.com/ansible/latest/playbook_guide/playbooks_conditionals.html
- https://docs.ansible.com/ansible/latest/playbook_guide/playbooks_variables.html 
