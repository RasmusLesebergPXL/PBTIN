### Mission 5: bestanden en collections API

### Taak 1: de klasse Point

Maak de klasse Point. Deze klasse heeft 2 eigenschappen: een x- en y-coördinaat (int).
* Een Point-object kan vergeleken worden met een ander Point-object.
Gebruik de y-coördinaat voor de vergelijking (een lagere y-coördinaat komt voor een hogere waarde).
Als de y-coördinaten gelijk zijn dan gebruik je de x-coördinaat.
* Zorg ook dat de equals-methode correct wordt geïmplementeerd. 
Twee Point-objecten zijn gelijk als hun x- en y-waarden gelijk zijn.
* Voorzie getters en setters.
* Voorzie de toString()-methode: formaat (x,y).

Test alle methoden behalve getters en setters!

### Taak 2: inlezen van bestand color.txt

Lees het bestand color.txt. Gebruik een **Map** om de waarde van R (rood), G (groen) en B (blauw) te bepalen.
Je start met de waarde 0 voor iedere kleur. Als je het bestand inleest, voer je de bewerkingen uit. 
Dus bij instructie "G +10" tel je 10 op bij de huidige waarde van kleur G.

Toon nu in de terminal een blokje in de gevonden kleur. Je vindt voorbeeldcode in het de klasse MessageApp.


### Taak 3: geheime boodschap

Iedere lijn in het bestand points.txt stelt een Point-object voor.
Lees het bestand in. Maak gebruik van een verzameling waarin **geen dubbele elementen** kunnen
voorkomen. 
* Hoeveel unieke Point-objecten zijn er?
* Bepaal de kleinste en grootste x-waarde.
* Bepaal de kleinste en grootste y-waarde.

Genereer nu een grid (of matrix) met alle punten vanaf (x-min, y-min) tot (x-max, y-max). Indien het gegenereerde punt voorkomt in het bestand
dat kleur je het punt in de gevonden kleur van taak 2. 
Indien het punt niet voorkomt druk je een wit blokje af ("   ").

Welke boodschap verschijnt op het scherm?

### Taak 4: priority queue

Maak voor deze opdracht gebruik van een PriorityQueue.
Lees het bestand priority.txt. Hierin staat 2 types van acties: ENTER (voeg een student toe aan de priority queue) of
SERVE. 
Iedere ENTER-actie bevat de volgende informatie van een student: name score token.
Maak een klasse om deze informatie op te slaan. In de priority queue worden de studenten geholpen volgens de volgende
criteria. 
* Studenten met de hoogste score worden eerste geholpen
* Bij gelijke score worden studenten geholpen op basis van hun naam (in alfabetische volgorde A-Z daarna a-z)
* Bij gelijke score en gelijke naam bepaalt het token de volgorde. Het laagste token wordt eerst geholpen.

Verwerk nu het bestand. Druk af welke student er geholpen worden bij de SERVE-actie.
* Hoeveel studenten staan er nog op de priority queue na het verwerken van het bestand?
* In welke volgorde gaan deze studenten geholpen worden. Print hun namen in de juiste volgorde.

Schrijf je PriorityQueue in een aparte klasse zodat je de verschillende criteria voor de volgorde van het helpen van de
studenten kan testen. 