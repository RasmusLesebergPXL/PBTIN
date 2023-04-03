# Assignment 3: CI & CD concepts

Voor deze opdracht maken we gebruik van de Linux VM die we geïnstalleerd hebben in les 1.

Installeer java-jdk op deze machine met volgend commando:

```
sudo apt install openjdk-11-jdk ca-certificates
```

Installeer Jenkins op deze virtuele machine. Voor deze opdracht installeer je Jenkins native op de VM zelf. In latere fases kan je Jenkins ook als docker container installeren. Volg de installatiegids op [deze link](https://www.jenkins.io/doc/book/installing/#debianubuntu). Na de installatie surf je naar `localhost:8080` in je virtuele machine en doorloop je de installatie van jenkins zelf.

In het eerste scherm moet je een wachtwoord ingeven. Dit wachtwoord kan je terugvinden onder` /var/lib/jenkins/secrets/initialAdminPassword`. Let op, enkel de root gebruiker kan dit bestand lezen!

Onder “customize jenkins” kies je voor “install suggested plugins”. Bij het volgende scherm maak je een gebruiker aan. Bij “instance configuration” klik je op “save and finish”. Vervolgens is de installatie afgerond en kom je op onderstaand scherm uit:

![alt_text](https://i.imgur.com/iaophR2.png "image_tooltip")


Maak alvast een nieuwe snapshot van je VM. Je merkt dat jenkins momenteel in het Nederlands staat. Zoek online een manier hoe je jenkins om kan zetten in het Engels. 

![alt_text](https://i.imgur.com/7sj85dD.png "image_tooltip")
_Documenteer de oplossing hoe je Jenkins in het Engels. Indien je Jenkins al in het Engels staat, kijk je hoe je de taal kan aanpassen. Documenteer kort in het bestand oplossing.md hoe je dit gedaan hebt onder punt (a). _


![alt_text](https://i.imgur.com/7sj85dD.png "image_tooltip")
_Hoeveel plugins zijn er momenteel op je jenkins machine geïnstalleerd? Het antwoord geef je in het bestand oplossing.md onder punt (b)._

Je hebt nu ook al kennis gemaakt met het plugin beheer van Jenkins. Jenkins heeft plugins voor zowel de interne werking als voor functionaliteiten in je Pipeline. Hier gaan we in latere hoofdstukken nog verder op in. 


![alt_text](https://i.imgur.com/7sj85dD.png "image_tooltip")
_De installatie heeft achterliggend ook een user aangemaakt op het systeem. Wat is de naam en homefolder van deze user? Documenteer dit in het bestand oplossing.md onder punt (c)._

De aparte gebruiker & homefolder zijn belangrijk om achterliggend te begrijpen hoe Jenkins werkt in de volgende lessen. 

Zorg ervoor dat het bestand oplossing.md aangevuld is met bovenstaande antwoorden en push de wijzigingen naar de github repo. We verwachten ook dat ieder teamlid een werkende Jenkins machine heeft.
