# Assignment 4: Pipelines in Jenkins

Voor deze opdracht maak je opnieuw gebruik van de VM met daarin Jenkins uit de vorige les.

Log in op je jenkins server.

1. Maak een nieuw pipeline project aan zoals gezien in de les en begin met het hello world script zoals hieronder afgebeeld. De naam van dit project noem je pipeline-opdracht-2:

![alt_text](https://i.imgur.com/rnoMFXT.png "image_tooltip")

Voer de pipeline uit en zorg dat deze werkt.

2. Vul de pipeline aan met een script stage die “show folders” heet en die de volgende stappen heeft:
    1. Die een nieuwe file maakt in de actieve map met als naam `.halloween`
    2. Doe een listing van de huidige directory die bestanden (inclusief verborgen bestanden) in een lijstje toont en de bestandsgrootte weergeeft.
    3. gebruik een shell commando om het volledige pad van de workspace (=huidige map) weer te geven.

![alt_text](https://i.imgur.com/Hv9jkZE.png "image_tooltip")
Voer de pipeline succesvol uit en plaats in de file oplossing.md een screenshot onder punt (a) met het het bewijs van een werkende pipeline a.d.h.v. de console output

3. Vul de pipeline aan met een stage die “create zipfile” heet en die de volgende commando's uitvoert:
    1. Maak een nieuwe directory aan die de naam van jou groep draagt.
    2. Ga in bovenstaande directory en maak voor elk teamlid een lege file aan met als naam de naam van je groepslid.
    3. Ga terug in de workspace directory. Maak een zipfile met de naam 'groepinfo.zip' die de bestanden (= de namen van de teamleden) in een zipfile archiveert.
    4. doe een ls vanuit je workspace direcotry die de structuur van je mappen toont. Je zou onderstaande structuur moeten aanhouden:
```
. (working dir)
│   groepinfo.zip 
│
└───groepsnaam
│   │   lid1
│   │   lid2
│   │   lid3
```
 
 4. Voorzie vervolgens een stage  "schoonmaak". Deze stage zorg ervoor dat de files en de directory elke keer succesvol aangemaakt kunnen worden (zorg dat de lokale directory na elke build poging opgeruimd wordt).

![alt_text](https://i.imgur.com/Hv9jkZE.png "image_tooltip")
Voer de pipeline succesvol uit en plaats in de file oplossing.md een screenshot onder punt (b) met het het bewijs van een werkende pipeline a.d.h.v. de console output

5. Vul de pipeline aan met een script stage die  “checkout code” heet en die het volgende doet:
    1. de code uit deze git repo binnenhaalt: [https://github.com/PXL-2TIN-DevOps-Resources/Calculator-app](https://github.com/PXL-2TIN-DevOps-Resources/Calculator-app)

![alt_text](https://i.imgur.com/Hv9jkZE.png "image_tooltip")
Voer de pipeline succesvol uit en plaats in de file oplossing.md een screenshot onder punt (c) met het het bewijs van een werkende pipeline a.d.h.v. de console output

6. Zorg ervoor dat, als de pipeline succesvol is uitgevoerd je een echo doet van "pipeline succesvol!"

7. Neem de pipeline code die je gebouwd hebt en sla deze op in een file genaamd “Jenkinsfile” en voeg deze toe aan de map van je opdracht, naast de file readme.md en oplossing.md.

![alt_text](https://i.imgur.com/Hv9jkZE.png "image_tooltip")
Push deze jenkinsfile naar de github repo.

# Deliverable
- De verschillende screenshots in de `oplossing.md` file. Deze screenshots bevatten de console output van de relevante stappen alsook de pipeline steps indien niet duidelijk.
- De pipeline als script in de file `Jenkinsfile` in deze repository **(geen Jenkinsfile resulteert in een 0 op deze opdracht)**.

