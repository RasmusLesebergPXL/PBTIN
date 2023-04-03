# Automation PE1
## Basis opdracht (50%)
Deploy de python web applicatie `app.py` op een AWS VM en zorg dat je die accessible is via het Internet.
### AWS VM
- Maak een AWS VM aan, gebaseerd op RHEL, in je AWS Academy Automation I module.
- Vergeet in AWS de juiste poort niet te openen voor de python applicatie.
### Ansible deployment
- Gebruik een Ansible playbook `playbook.yaml` en bijbehorende Ansible inventory `aws_hosts.ini` om de AWS VM te configureren. Zorg ervoor dat:
  - de python app `app.py` gedeployed wordt op de AWS VM die beschreven staat in je `aws_hosts.ini` inventory file.
  - de python app `app.py` op de VM zich bevindt in de directory `/opt/pyramid_app`.
  - de python app op de VM op de achtergrond runt na het succesvol toepassen van het playbook. Dit hoeft niet idempotent te zijn.
- Na het uitvoeren van het playbook is de python app http accessible vanop je machine via het internet met een browser via de resource [URI]/hostname
- Maak dan een screenshot van je browser window, plaats deze in de opdracht directory en vergeet niet te committen.
- De hele deployment moet werken op een pristine RHEL machine. Dus als iemand anders het playbook runt, mits de inventory file aan te passen, op een andere, pas gedeployde AWS RHEL VM, wordt alles op de VM juist geconfigureerd zonder manuele interventie op de VM.
### Oplevering
- Maak de nodige aanpassingen in de files `aws_hosts.ini` en `playbook.yaml` en commit deze files.
- Na het uitvoeren van het playbook is de python app http accessible vanop je machine via het internet met een browser via de resource [URI]/hostname. Maak dan een screenshot van de werkende oplossing in je browser window, plaats deze in de opdracht directory, voeg deze file toe aan de repo en commit deze.
- Manuele aanpassingen aan de VM zijn niet toegestaan, tenzij om manueel iets te testen. Vergeet deze manuele acties niet ongedaan te maken.
- Het gebruik van de command en shell modules is niet toegestaan, met 1 uitzondering: het starten van de python web applicatie.
- Het gebruik van scripts is niet toegestaan.
- Enkel files die gecommit zijn voor de deadline worden beoordeeld.
## Extra's (50%)
De extra's worden *enkel* beoordeeld als de Basis Opdracht succesvol is volbracht.
### Extra 1 - Ansible: iptables firewall (20%)
- Zorg ervoor dat de iptables service expliciet geinstalleerd wordt en runt, ook na rebooten.
- Zorg ervoor dat de juiste poort voor de web applicatie geopend wordt in iptables. Het is toegestaan dat deze Ansible task niet idempotent is.
- Het gebruik van de command en shell modules is niet toegestaan.
### Extra 2 - Ansible: app runt ook na rebooten (15%)
- Zorg ervoor dat de applicatie automatisch opstart en werkt na het rebooten van de VM, zonder Ansible tussenkomst.
- Het gebruik van de command en shell modules is niet toegestaan.
### Extra 3 - Ansible: new user `app_user` (15%)
- Zorg ervoor dat er een nieuwe user wordt aangemaakt `app_user`.
- Zorg ervoor dat deze user owner is van de files(s) en directory voor de python app deployment.
- Het gebruik van de command en shell modules is niet toegestaan.
## Informatie
### Interessante parameters
De ansible commando's hebben de optionele parameter `[--private-key PRIVATE_KEY_FILE]`.

### Pyramid en Python
De python web applicatie is geschreven mbv het python3 framework pyramid en gebruikt de volgende python (pip) modules: `pyramid`, `waitress`.

Verder wordt er in de applicatie ook gebruikt gemaakt van de python modules `psutil` en `distro`.

De web applicatie kan worden opgestart met het commando `/usr/bin/python3 app.py`.

### RHEL packages
Eventueel nuttige RHEL packages zijn `python3`, `python3-pip` voor python.
Het RHEL package voor iptables heet `iptables-services`, dat de service `iptables` installeert.

### custom systemd services
Die zijn makkelijk aan te maken met een custom service file, bv `/etc/systemd/system/example.service`:

    [Unit]
    Description=Example service
    
    [Service]
    User=tomc
    WorkingDirectory=/home/tomc
    ExecStart=/usr/sbin/my-simple-daemon -d
    Restart=always
    
    [Install]
    WantedBy=multi-user.target`

### CLI
Een handig commando om processen in de achtergrond op te starten is `nohup`.
bv `nohup ping google.com &` start een ping achtergrondprocess op dat blijft lopen, ook na het sluiten van de shell (no hangup).
