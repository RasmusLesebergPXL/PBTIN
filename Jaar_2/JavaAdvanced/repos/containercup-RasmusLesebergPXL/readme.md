## Mission 3: Containercup
In mei 2020 namen 30 atleten en 8 BV’s het tegen elkaar op in een unieke zevenkamp. Wij
gaan de gegevens van deze containercup inlezen en analyseren.

![containercup](containercup.png)

### Taak 1: DeelnemerReader
De klasse DeelnemerReader staat in voor het inlezen van de gegevens uit het bestand
containercup.csv. Het bestand wordt als argument meegegeven aan de statische methode
readFile. Implementeer de methode readFile en maak gebruik van BufferedReader en trywith-resources in je oplossing. De eerste lijn van het in te lezen bestand moet overgeslagen
worden, vanaf dan bevat elke lijn de gegevens van een andere deelnemer. Elke lijn moet
integraal doorgegeven worden aan de bestaande methode mapLineToDeelnemer, die een
Deelnemer-object zal teruggeven. De aangemaakte deelnemers moeten worden opgeslagen en
als resultaat moet de readFile-methode een verzameling van Deelnemer-object geven.

### Taak 2: DurationCalculator
De eindtijd voor deze zevenkamp wordt als volgt berekend:
- De tijd optellen van de volgende disciplines:
  - 1.500 meter lopen
  - 1.000 meter roeien
  - 3.000 meter fietsen.
- Per monkey bar trekken we een seconde af van de totaaltijd.
- Het aantal meter op de golfdiscipline delen door drie en omzetten in seconden. Dit
aantal aftrekken van de totaaltijd.
- Per geraakt target op de schietdiscipline trekken we 10 seconden af van de totaaltijd.
- Het aantal kilo's van de benchpress delen door twee en omzetten in seconden. Dit
aantal aftrekken van de totaaltijd.

De implementatie van bovenstaand algoritme vind je reeds terug in de methode getEindtijd()
in de klasse Deelnemer. Opdat de code compileert moet je nu een generieke methode minus
in de klasse DurationCaluculator implementeren. Je zal dus naast de bestaande methode
minus een tweede methode met dezelfde naam maar verschillende parameters aanmaken
(method overloading). Maak gebruik van de javadoc van de klasse java.time.Duration en de
unit testen in de klasse DurationCalcutorTest. De generieke methode minus heeft 2
parameters: een parameter van het generieke datatype en een function om deze eerste
parameter om te zetten naar een Duration. Deze berekende Duration-waarde wordt
vervolgens afgetrokken van de tot dan toe bekomen waarde van de DurationCalculator.

### Taak 3: Streams
In het hoofdprogramma containercup ga je nu nog enkele gegevens tonen door gebruik te
maken van de Streaming API.
- Toon het aantal deelnemers in het klassement BV
- Geef de top 5 van deelnemers in het klassement sportman (M). Dit zijn de deelnemers
met de beste eindtijd. Toon hun naam en eindtijd.
- Wat is het hoogste aantal monkey bars dat een deelnemer heeft uitgevoerd?
- Verzin eventueel zelf nog enkele interessante gegevens om te tonen.

#### Gewenste output:
```
Aantal deelnemers in klassement BV
8
Klassement sportman (top 5)
08:50.02 Mathieu van der Poel
09:20.30 Greg Van Avermaet
09:48.21 Oliver Naesen
09:48.93 Tim Brys
09:51.80 Dennis Praet
Maximum monkey bars
105
```
