# Assignment 6 Environments (DTAP)
We starten deze opdracht met de configuratie van de 2 servers.

## Configuratie
Voor deze opdracht maak je gebruik van 2 virtuele machines:
*   **Testserver:** De VM met jenkins uit de vorige lessen
*   **Productieserver:** Een nieuwe Ubuntu Server VM (zonder jenkins) 

### Configuratie Testserver
We starten met de configuratie van de testserver. Dit is de server waarop Jenkins geinstalleerd staat (en die je tijdens de vorige lessen gebruikt hebt). Installeer de nodige tools via onderstaande commando's:
```
sudo apt-get install curl
curl -fsSL https://deb.nodesource.com/setup_14.x | sudo -E bash -
sudo apt-get install -y nodejs
```
We gebruiken native nodejs om bij de deployment stappen de applicatie te hosten op deze server. Installeer hierna globaal de package `pm2` via onderstaand commando:
```
sudo npm install -g pm2
```
Dit is een process manager voor NodeJS applicaties die we later gebruiken om de applicatie op te starten & te stoppen.
Meer uitleg en documentatie op https://pm2.keymetrics.io/

Om pm2 probleemloos te gebruiken vanuit de pipeline, moet je eenmalig een pm2 commando runnen om de deamon te initialiseren. Doe dit a.d.v.h. volgende commando's:
```
sudo su jenkins
cd ~
rm -rf .pm2
pm2 start
```

### Configuratie productieserver
De productieserver is een nieuwe kale Ubuntu server die we gebruiken voor de deployment van de applicatie in de productieomgeving. We installeren via onderstaand commando de nodige software:
```
sudo apt-get install -y openssh-server git curl zip
curl -fsSL https://deb.nodesource.com/setup_14.x | sudo -E bash -
sudo apt-get install -y nodejs
```

Ook hier installeren we globaal de package `pm2` via onderstaand commando en zorgen we voor de initialisatie:
```
sudo npm install -g pm2
rm -rf .pm2
pm2 start
```


Het is belangrijk dat beide servers met elkaar kunnen communiceren. Het kan makkelijker zijn als je de productieserver een statisch IP adres geeft. Na deze configuraties zijn we klaar om te starten met de opdracht.

## Opgave
In de repository kan je 2 jenkinsfiles vinden. Je gebruikt beide jenkinsfiles om ze te linken aan elk hun eigen pipeline in je jenkins omgeving. Je voorziet in deze opdracht dus 2 pipelines op de `Testserver`. 

De `test.jenkinsfile` zorgt voor een artifact en deployed deze artifact naar de `Testserver`.

De `production.jenkinsfile` neemt de artifact van de `test.jenkinsfile` en deployed deze a.d.h.v. `ssh` op de `Productionserver`.

Details van bovenstaande implementaties kan je hieronder terugvinden.


_Tip: Het is niet toegelaten om het `sudo` commando te gebruiken. Heb je geen rechten in bepaalde folders? Dan zorg je ervoor dat de gebruiker `jenkins` de juiste rechten krijgt. Dit is iets wat je handmatig, buiten de pipeline, kan instellen. (Zie ook Systems essentials: `chmod` / `chgrp`)_

# test.jenkinsfile
Je krijgt reeds een bestaande pipeline met enkele stages in. Voorzie volgende extra stages in deze pipeline:
*   Stage `cleanup`: Deze stap maakt de working directory van de pipeline leeg.
*   Stage `Install dependencies`: Gebruik de global tool configuratie van nodejs met als naam "testenvnode". Deze configuratie gebruik je in deze stage om het `npm install` commando uit te voeren.
*   Stage `Create artifact`: In deze stage wordt er een artifact (zip) gemaakt van de bestaande code van onze NodeJS applicatie. Deze artifact wordt later overgekopieerd naar onze servers voor deployment. Zorg er dus voor dat alle nodige zaken aanwezig zijn in de artifact om de applicatie te kunnen starten. _Let op: zorg er ook voor dat er niet **TEVEEL** in zit!_
*   Stage `deployment`: In deze stage zorg je ervoor dat je de bestanden van je artifact uitpakt in de `/opt` folder van je VM.

    &emsp;&emsp;&emsp; _Tip 1: Denk eraan dat de `/opt` folder leeggemaakt moet worden in de cleanup stap voordat je de bestanden overkopieert._

    &emsp;&emsp;&emsp; _Tip 2: Denk aan de nodige rechten voor de jenkins user in de `/opt` folder, stel dit op voorhand in!_
*   Stage `run deploy`: In deze stage gebruik je `pm2` om de NodeJS applicatie in de `/opt` folder op te starten, dit kan je doen met het commando ```pm2 start server.js``` (vanuit de map waar dit bestand staat)

    &emsp;&emsp;&emsp; _Tip 1: Denk eraan dat er misschien nog een vorige versie van de applicatie actief is. Je kan via het commando ```pm2 stop all || true``` alle huidige processen stoppen._
    * Als je vervolgens naar [http://localhost:3000](http://localhost:3000) surft in de vm, zal je de calculator app kunnen gebruiken.
*   Denk aan de cleanup stappen! De pipeline moet meerdere keren na elkaar kunnen draaien.

![alt_text](https://i.imgur.com/9leib3p.png "image_tooltip") _Heb je aanpassingen gedaan om jenkins rechten te geven tot bepaalde mappen, dan documenteer je dit in oplossing.md onder punt (a)._

# production.jenkinsfile

Je krijg een lege pipeline. Ook deze pipeline integreer je op de jenkins server die op de `Testserver` staat. Geef deze Pipeline dus ook een duidelijke naam, zodat je weet welke de test deploy en welke de productie deploy uitvoert.

Het doel van deze pipeline is het voorzien van volgende stages:

*   Stage `deploy prod`: Zoek een manier waarop je artifact uit de test.jenkinsfile pipeline kan gebruiken om te deployen naar je 2de Virtuele machine (dus via een remote connectie). Ook hier moeten de bestanden opnieuw in de folder `/opt` komen te staan zonder het gebruik van sudo.
*   Stage `start prod`: Deze stage gebruikt de `pm2` package om de applicatie te starten op de productieserver zodat deze bereikbaar is.
    * Als je verfvolgens naar het ip adres van de productieserver surft op poort 3000, zou je de applicatie moeten kunnen gebruiken.
    <br/><br/>

    &emsp;&emsp;&emsp; _Tip 1: Het gebruiken van een artifact uit een andere pipeline kan op 2 manieren: Je kan kijken waar & op welke manier Jenkins artifacts opslaat op het bestandssysteem of je kan gebruik maken van de plugin `copyartifact`_

     &emsp;&emsp;&emsp;_Tip 2: Maak verder gebruik van de jenkings plugin `sshagent` die werkt met SSH keys als authenticatie. Denk hierbij ook aan de opdracht uit security essentials vorig jaar: Hoe kon je ssh keys gebruiken om je te authenticeren op een linux machine?_
     
    &emsp;&emsp;&emsp;_Tip 3: Denk hierbij aan de commando’s gezien bij onder andere systems advanced. Het kopiëren van bestanden van één server naar een andere kan met het `scp` commando. Het uitvoeren van commando's op een andere server kan via `ssh`. Doe hierbij het nodige opzoekingswerk._

    &emsp;&emsp;&emsp;_Tip 4: Denk ook in deze pipeline aan de nodige cleanup stappen op de remote server._

*   Stage `test prod`: Doe een check om te kijken of de applicatie werkt. Voorlopig kan je dit testen met het `curl` commando om te controleren of je een statuscode 200 krijgt als je het IP adres van de `productieserver` bezoekt.
*   Denk aan de cleanup stappen! De pipeline moet meerdere keren na elkaar kunnen draaien.

# Configuration management

Voorlopig is er geen onderscheid tussen test en productie. Beide omgevingen gebruiken dezelfde artifact met dezelfde configuratie. Vanuit het concept “build once, deploy anywhere” is het ook belangrijk dat we die zelfde artifact gebruiken voor beide omgevingen. Voor de oefening voorzien we de verschillen in configuratie aan de hand van 2 CSS files:

*   `Test.style.css`: de body heeft een rode achtergrond
*   `Prod.style.css`: de body heeft een blauwe achtergrond

Je maakt deze 2 css files zelf aan. Maak een nieuwe, persoonlijke, **publieke** repository met als naam `groepsnaam-configuratie-dtap` waarin je deze configuraties in opslaat. Belangrijk is dat je voor de opdracht de test en productie pipeline uitbreid met een extra stage `Config env` die de juiste css file naar de juiste locatie kopieert. Als je daarna de test- of productieomgeving bezoekt, zien we de verschillende achtergrondkleuren.

&emsp;&emsp;&emsp;_:information_source: In de praktijk staat configuraties uiteraard niet publiek, maar voor de evaluatie van de opdracht gebruiken we hier een publieke repository._

![alt_text](https://i.imgur.com/9leib3p.png "image_tooltip") _Geef een korte omschrijving van de aanpak in oplossing.md onder punt (b)._

![alt_text](https://i.imgur.com/9leib3p.png "image_tooltip") _Zorg ervoor dat alle **werkende** stappen aanwezig zijn in de Jenkinsfiles van je repository. Indien deze hier niet in staan, krijg je voor deze opdracht ook geen punten._

## Bonusopdracht (niet verplicht)
_Het uitvoeren van deze opdracht levert je bonuspunten op, je krijgt als groep geen punten af als dit gedeelte niet gemaakt is._

Binnen nodeJS kan je gebruik maken van de package [dotenv](https://www.npmjs.com/package/dotenv) om variabele per omgeving te maken die dan in de code opgeroepen worden. De calucaltor app is gebouwd om gebruik te kunnen maken van deze package zodat je via een `.env` file kan bepalen op welke poort de applicatie moet opstarten. Als uitbreiding zorg je ervoor dat de applicatie van de `testserver` op poort 4000 draait en de `productieserver` op poort 80. Om dit te realiseren gebruik je `.env` files die je ook in de configuratie repository opslaat.

# Deliverable
Deze repository met:
- Een opgevulde test.jenkinsfile met bovenstaande beschreven stages
    - Geen gevulde Jenkinsfile = 0 op deze deelopdracht
    - Een niet werkende (=syntax errors in het pipeline script) Jenkinsfile = -30% op het eindresultaat
- Een opgevulde production.jenkinsfile
    - Geen gevulde Jenkinsfile = 0 op deze deelopdracht
    - Een niet werkende (=syntax errors in het pipeline script) Jenkinsfile = -30% op het eindresultaat
- Een uitbreiding in beide jenkinsfiles met daarin de nodige stappen voor de configuratiemanagement.
- Een opgevulde `oplossing.md` file met antwoorden op bovenstaande vragen inclusief screenshots indien nodig.
- Optioneel: De uitwerking van de bonusopdracht die geïntegreerd is in de pipeline scripts.
