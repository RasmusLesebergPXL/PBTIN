# Compose Oefening
## Project structuur
### Database
Een MySQL database die bestaat uit 1 tabel met films (zie database/database.sql).

Beschikbare docker image van de database: `pxlsystemsadvanced/compose-oef-1-database`

### Webapp
De webapp haalt de films op uit de database en toont ze in een HTML-pagina. Deze webapp is gebouwd met Flask (een Python Microframework).

Beschikbare docker image van de webapp: `pxlsystemsadvanced/compose-oef-1-webapp`

## Oefening
- Maak een `compose.yml` bestand om de webapp en de database te deployen met Compose.
- Check de source code om uit te vissen welke hostnames, poorten en eventuele paswoorden nodig zijn om de database op te zetten.
