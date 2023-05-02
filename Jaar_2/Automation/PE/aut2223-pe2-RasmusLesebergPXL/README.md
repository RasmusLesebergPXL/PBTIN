# Automation PE2
## Basis opdracht (50%)
Installeer een AWS VM als bastion host en zorg dat je die ssh accessible is via het Internet als my_user met public key-based authentication.
### AWS VM
- Maak een AWS VM aan, gebaseerd op RHEL, in je AWS Academy Automation I module.
- Vergeet in AWS de juiste poort niet te openen voor ssh access.
### Ansible deployment
- Gebruik een Ansible playbook `playbook.yaml` en bijbehorende Ansible inventory `aws_hosts.ini` om de AWS VM te configureren:
  - overal waar je een paswoord nodig hebt (vault, user password) gebruik je het paswoord 'pxl'.
  - het paswoord van het private-public keypair voor my_user is leeg.
  - je gebruikt ansible vault om de hashed sha-512 versie van het paswoord ('pxl') van de nieuwe user `my_user` te bewaren in `secrets.yaml`.
  - je installeert sshd en firewalld op de server, ga er niet van uit dat die daar al opstaan.
  - je maakt een nieuwe user op de bastion host aan `my_user` met de hashed version van het paswoord uit je vault file.
  - je zorgt ervoor dat je met ssh public key kan inloggen als `my_user` (dus zonder paswoord).
  - je configureert firewalld om de ssh poort open te zetten.
  - je maakt de file `/home/my_user/info.txt` aan op de bastion host, met als inhoud "Bastion host configured."
- Na het uitvoeren van het playbook is de VM accessible vanop je machine via het Internet via ssh als my_user met passwordless public key-based authentication.
### Oplevering
- Maak de nodige aanpassingen in de juiste files en commit deze files.
- Check voor deze ene keer beide keyfiles van de user my_user in.
- Als je extra files gebruikt voeg die dan toe aan de repo en commit.
- screenshot:
  - installeer `curl` op je laptop (bv met `sudo apt install curl`)
  - voer uit in je shell, maar gebruik je echte AWS VM IP ipv EC2_IP_AWS, en vervang KEYFILE door de locatie van de private key van my_user
    ```
    export aws_vm=EC2_IP_AWS
    export my_user_key=KEYFILE
    ```
  - run je ansible playbook nog eens
  - voer uit in je shell (maar gebruik je echte AWS VM IP ipv EC2_IP_AWS):
    ```
    ssh -i ./$my_user_key my_user@$aws_vm 'cat /home/my_user/info.txt'
    curl $aws_vm
    ```
  - neem een screenshot van de console zodanig dat je de de output van de laatste task ziet, samen met de output van de 2 commando's hierboven, als `screenshot.png` en check deze in in de repo.
### Pas op
- Manuele aanpassingen aan de VM zijn niet toegestaan, tenzij om manueel iets te testen. Vergeet deze manuele acties niet ongedaan te maken.
- Het gebruik van de command en shell modules is niet toegestaan.
- Het gebruik van scripts is niet toegestaan.
- Enkel files die gecommit zijn voor de deadline worden beoordeeld.
## Extra's (50%)
De extra's worden *enkel* beoordeeld als de Basis Opdracht succesvol is volbracht.
### Extra 1 - Ansible: $PATH (10%)
  - je toont de `$PATH` environment variable van de bastion host tijdens het uitvoeren van je playbook, *als laatste actie.*
### Extra 2 - Ansible: apache (40%)
- installeer apache.
- zorg dat die accessible is via het internet, op poort 80.
- apache toont files uit `/var/www/html/`
- je gebruikt de file in de repo `./files/index.html` als website
- je gebruikt een *host variable* `apache_index_src` die de file system *locatie* van deze index file bevat.
- Het gebruik van de command en shell modules is niet toegestaan.
## Informatie
### Interessante commando's
mkpasswd --help

mkpasswd -m help
### Ansible multi-line string variables
Use a pipe symbol `|` and don't forget the YAML indentation.
```
my_var: |
  With his own sword,
  Which he did wave against my throat, I have ta’en
  His head from him.
```
### Ansible Jinja2 `lookup()` function
Lookup plugins retrieve data from outside sources such as files, databases, key/value stores, APIs, and other services. Like all templating, lookups execute and are evaluated on the Ansible control machine. Ansible makes the data returned by a lookup plugin available using the standard templating system. 
You can use lookup plugins anywhere you can use templating in Ansible: in a play, in variables file, or in a Jinja2 template.
```
vars:
  file_contents: "{{ lookup('file', 'path/to/file.txt') }}"
```
### Packages on RHEL
- Apache: `httpd`
- ssh server: `openssh-server`
- firewalld: `firewalld`
