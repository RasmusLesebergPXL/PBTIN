# Opdracht 1: Groepsindeling & Opzetten omgeving

_Aan de hand van deze opdracht zorg je voor de nodige infrastructuur die nodig is voor het vak DevOps. Het doel is voornamelijk om straks tijd uit te sparen voor andere opdrachten. Deze opdracht telt **niet **mee voor het PE gedeelte van het vak DevOps. Gebruik deze opdracht ook als oefening voor het insturen van opdrachten._

## Aanmaken virtuele machine

Zorg ervoor dat **elk teamlid** op zijn toestel een Virtuele machine met als besturingssysteem Ubuntu desktop heeft voorzien.  Je mag zelf kiezen op welke manier je deze virtuele machine gebruikt (vmware, virtualbox, hyperv, cloud, ...).Uiteraard kan één persoon deze virtuele machine klaarmaken en dan delen met de rest via een USB stick / WeTransfer. Als gebruikersnaam neem je “student” en als wachtwoord “pxl” bij de installatie. 

Voer onderstaand commando uit om alvast git in je VM te installeren:

```
sudo apt-get update && sudo apt-get install git
```

Doe een update van alle pakketten via het softwarecenter. Nadat alle software geüpdatet is, neem je een snapshot van je virtuele machine. Op deze manier heb je altijd een backup van de clean install.

_Tip: Maak doorheen de komende weken regelmatig snapshots van je VM._
## Handmatig opzetten applicatie in de virtuele machine
Zorg ervoor dat de applicatie draait in de VM die je net hebt aangemaakt. De code kan je vinden op onderstaande link:
https://github.com/PXL-2TIN-DevOps-Resources/Calculator-app

Het is best dat elk teamlid deze kennis beheerst. Je kan hier voor onderstaande installatiegids gebruiken:
https://github.com/PXL-2TIN-DevOps-Resources/installatiegids_calculatorApp


## Deliverable
### deliverable A
Pas onderstaande lijst aan met de namen van de verschillende studenten in dit team en de klas waarin ze zitten. Bv. John Doe - 2TINA:

1) Stijn Kits van Heijningen - 2TING

2) Vincent Vandebosch - 2TINI 

3) Zidane Boutayniout 2TINI

4) Rasmus Leseberg - 2TINR

### deliverable B
Maak een nieuw bestand aan met de naam `samenwerking.md`. Hierin voorzie je een beschrijving van hoe je als team samenwerkt:
- Hoe bepaal je de opsplitsing van de taken?
- Op welke manier werk je samen & communiceer je als team binnen & buiten de lesuren?
- Hoe zorg je ervoor dat alle teamleden op de hoogte blijven van alle taken?
- Hoe doe je aan kennisoverdracht binnen je groep?
- Wie is verantwoordelijk voor de eindoplevering? Hoe pak je dit als team aan? 
- ...

### deliverable C
Maak met de kennis die je nu hebt een duidelijk stappenplan van de flow van het deploymentproces van de applicatie. Dit kan je in de latere opdrachten helpen om het proces te automatiseren. Plaats de flow onder deze deliverable

Deploymentproces exampleApplication(node.js application):
  1. Installation Ubuntu Desktop / Server
  2. Open Terminal and do the following commands
    1. sudo apt-get update
    2. sudo apt install git
    3. git clone exampleApplication
    4. Login with git account
    5. cd exampleApplication
    6. sudo apt install curl
    7. curl -o- https://raw.githubusercontent.com/nvm-sh/nvm/v0.39.1/install.sh | bash
  3. Restart the Terminal
    1. nvm install 14
    2. cd ~
    3. cd exampleApplication
    4. npm install express
    5. npm test
  4. Fix code untill tests are green
  5. Check if the application starts on the default port
  6. Start Terminal
    1. cd exampleApplication
    2. node server.js

Deploymentproces abstract:
  1. Installation Operation System
  2. Add the project
  3. Install the right version of the runtime environment
  4. Install dependencies
  5. Run all tests
  6. Notify developers about the tests
  7. Run the main file of the project


Conclusie:
  Er zijn heel wat stappen nodig voor het deployen van een applicatie.
  Ook heeft elk project ook andere requirements waardoor het deployen ervan bij elk project anders gaat zijn.