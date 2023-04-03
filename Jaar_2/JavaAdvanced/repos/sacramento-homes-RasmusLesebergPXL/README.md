### Sacramento Homes
Voor deze oefening hebben we een input file voorzien met de gegevens van een groot aantal
verkochte huizen. De opdracht bestaat er uit om deze file in te lezen en de data op te
slaan in objecten van het type Property, een klasse die je zelf zal implementeren.

Naast het inlezen en opslaan van de objecten in een collection, moet de applicatie ook in
staat zijn om de objecten te kunnen filteren op een aantal manieren. De bedoeling is dat je
dit met behulp van streams zal doen. Voorzie minstens volgende
methodes, die telkens de resulterende lijst van Properties terug geven:
- **propertiesAbovePrice(int price)**: Geeft alle Properties waarvan de prijs boven de
meegegeven waarde liggen.
- **propertiesForZIPCode(String zip)**: Geeft alle Properties met als ZIP code de meegegeven
waarde
- **propertiesSoldAfter(LocalDate date)**: Geeft alle Properties die na de meegegeven datum
verkocht zijn.
- **lastPropertiesSold(int amount)**: Geeft de laatst verkochte Properties terug, het precieze
aantal wordt meegegeven als parameter.

Maak ook een methode **findCheapest()** om het goedkoopste huis te vinden dat:
- minstens 3 slaapkamers heeft
- minstens een oppervlakte van 1000 square feet heeft
- in de stad Sacramento ligt

Deze methode geeft één Property object als resultaat terug.


Tenslotte moet je het ook mogelijk maken om een lijst van Properties weg te schrijven naar
een file. Belangrijk detail hierbij is dat meerdere lijsten parallel (dus tegelijkertijd) moeten kunnen worden
weggeschreven. Je zal dus gebruik moeten maken van multithreading om dit deel van de
opdracht te volbrengen. Het formaat van de Properties in de output file moet hetzelfde zijn
als dat van de originele data file. Hierbij zal je vooral moeten opletten met de volgorde van
de gegevens (velden) en het formaat van de verkoopdatums.
