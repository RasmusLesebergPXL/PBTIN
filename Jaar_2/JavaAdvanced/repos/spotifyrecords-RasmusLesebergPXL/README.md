## 2019 spotify top 50

### Introductie
Gegeven is een dataset die als muziek in de oren zal klinken, de top 50 van Spotify 2019
(top50spotify2019.csv). In deze mission ga je leren om de data in te lezen. Vervolgens ga
je bewerkingen maken met streams en lambda expressies.
### Leerdoelen:

- File I/O
- ArrayList
- Streams en lambda expressies
- Unit testen schrijven
- Maven gebruiken voor dependencies

### Probleemstelling

Het csv bestand bestaat uit een 50-tal lijnen met telkens dezelfde opbouw, de eerste
regel van het bestand zijn de kolomnamen:

     id;track.name;artist.name;genre;bpm;energy;danceability;loudness;liveness;valence;length;acousticness;speechiness;popularity

| Veld         | Omschrijving                            | 
|--------------|-----------------------------------------|
| id           | Unieke id                               |
| track.name   | Naam van de muziek track                |
| artist.name  | Naam van de artiest                     |
| genre        | Genre van het nummer                    |
| bpm          | Beats per minute                        |
| energy       | Energielevel van het nummer             |
| danceability | Dansbaarheid van het nummer             |
| loudness     | Sterkte van het geluid in decibels      |
| liveness     | Aanwezigheid van publiek in het nummer  |
| valence      | De muzikale positiviteit van het nummer |
| length       | De lengte van het nummer in seconden    |
| acousticness | Klank gehalte van het nummer            |
| speechiness  | Gesproken woorden in het nummer         |
| popularity   | Populariteit van het nummer             |
 
 ### Gegeven
  De klasse SpotifyRecord.
  
### Taak 1

Maak een helper klasse SpotifyRecordMapper met een static methode
mapDataToSpotifyRecord om de data van één spotify record uit het bestand om te
vormen naar een SpotifyRecord-object.
Schrijf een unit test om te controleren of je methode correct werkt.
  
### Taak 2

Vervolledig de klasse SpotifyReader. Implementeer de methode loadSpotifyRecords. Hou hierbij rekening met de volgende richtlijnen:
- Gebruik de static methode mapDataToSpotifyRecord in de klasse
  SpotifyRecordMapper om de data van een spotify record uit het bestand om te
  vormen naar een SpotifyRecord-object.
- Alle SpotifyRecord-objecten worden in een List opgeslagen die wordt
  teruggegeven als resultaat.
- De inlees-methode van de SpotifyReader klasse heeft als argumenten het Path
  naar de te lezen file.
- Als bij het aanroepen van de SpotifyRecordMapper een exception wordt opgegooid
  omdat een lijn niet ingelezen kan worden door ontbrekende data, dan zorg je dat
  de SpotifyReader de foutboodschap met System.err.println() afdrukt en je
  garandeert dat de SpotifyReader verder gaat met het inlezen van overige
  SpotifyRecords.

### Taak 3
  Vul nu in de klasse SpotifyApp de onderstaande methoden aan. In elke methode (behave
  getNumberOfSpotifyRecords) moet minstens één stream gebruikt worden om de
  oplossing te bekomen.
  Enkel oplossingen die door middel van een stream slagen in de unit testen worden
  goedgekeurd. Met behulp van de klasse SpotifyAppTest kan je je implementatie testen.
  Je mag geen wijzigingen aanbrengen in het bestand top50spotify2019.csv en de
  testklasse SpotifyAppTest.
  In de constructor van de klasse SpotifyApp gebruik je eerst de SpotifyReader om het
  bestand top50spotify2019.csv in te lezen. De ingelezen SpotifyRecords worden
  toegekend aan een instantievariabele van de klasse SpotifyApp.
1. **int getNumberOfSpotifyRecords()**

   Geef het aantal spotify records in de lijst. Hiervoor gebruik je geen stream!
2. **List<String> getTop5ArtistsWithHighestPopularity()**

   Geef een lijst terug met de namen van de artiesten van de 5 populairste spotify
   records. (Je mag ervan uitgaan dat het 5 verschillende namen zijn.)
3. **int getNumberOfUniqueArtists()**
   
    Hoeveel unieke namen van artiesten zijn er in de lijst?
4. **List<SpotifyRecord> getSpotifyRecordsByArtist(String artistName)**

    Geen voor de gegeven artiest alle SpotifyRecords uit de lijst.
5. **SpotifyRecord getMostDanceableSpotifyRecord()**
   
    Welke SpotifyRecord heeft de hoogste waarde voor danceability?
6. **String getDanceableGenres()**
   
    Geef de verschillende genres terug met een danceability groter of gelijk aan 80 in
   een String. De namen van de genres moeten gescheiden zijn door een komma en
   mogen geen dubbels bevatten.
7. **int getMaxLength()**

   Wat is de lengte van het langste SpotifyRecord?
8. **Genre getMostPopularGenre()**
   Geef het genre dat het meeste voorkomt. Met andere woorden, van welk genre zijn
      er het meeste SpotifyRecords?

Je kan de verschillende implementaties testen met de testklasse SpotifyAppTest.

### Taak 4

Tenslotte implementeer je een methode saveToFile in de klasse SpotifyApp. De methode
saveToFile heeft 1 parameter: een lijst van SpotifyRecords.

In de klasse SpotifyAppRunner gebruik je de methode saveToFile om de SpotifyRecords
van Billie Eilish (zie variabele records) weg te schrijven naar het bestand billie.txt in de
resources-folder.
   
### Taak 5

Het hoofdprogramma is gegeven, maar het wegschrijven van de titels van de records van
Billie Eilish ontbreekt nog in de code. Voeg deze functionaliteit nog toe.

### Output
Wanneer je het hoofdprogramma in de klasse SpotifyAppRunner uitvoert zou je de onderstaande output moeten krijgen.

```
   ** Number of spotify records: 50
   ** Number of unique artists: 38
   ** Songs by Billie Eilish saved to file.
   ** Top 5 artists:
   Billie Eilish
   Post Malone
   Bad Bunny
   Anuel AA
   Drake
   ** Most popular genre: DANCE_POP
   ** Danceable genres: AUSTRALIAN_POP, BOY_BAND, CANADIAN_HIP_HOP,
   COUNTRY_RAP, DANCE_POP, POP, REGGAETON_FLOW, RNB_EN_ESPANOL
   ** Max length: 309
   ** Most danceable:
   SpotifyRecord{ID=44, trackName='Talk', artistName='Khalid',
   popularity=84}
 ```