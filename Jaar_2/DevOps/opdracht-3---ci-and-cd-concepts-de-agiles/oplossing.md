Vul onderstaande aan met de antwoorden op de vragen uit de readme.md file. Wil je de oplossingen file van opmaak voorzien? Gebruik dan [deze link](https://github.com/adam-p/markdown-here/wiki/Markdown-Cheatsheet) om informatie te krijgen over
opmaak met Markdown.

# Opdrachten

### a) Documenteer de oplossing van hoe je Jenkins in het Engels zet:

	Go to:
		Dashboard -> Beheer Jenkins -> Beheer Plugins -> Beschikbaar tab -> filter voor "locale"
		Check the locale box
		Install with restart

		Go to:
			Dashboard -> Beheer Jenkins -> configure system 
				Scroll naar locale 
				Set default language naar "ENGLISH"
				Check de checkbox eronder
				Click save


### b) Hoeveel plugins zijn er momenteel op je jenkins machine geïnstalleerd?

	We kunnen zien hoeveel plugins er zijn door naar de home folder te gaan van jenkins.

	Dit kan je doen door: 'cd /var/lib/jenkins'

	Hier vinden we een directory genoemd 'plugins'

	Navigeer naar deze map met: 'cd plugins'

	Vervolgens kunnen we deze tellen met het volgende linux commando:
		'ls | grep .jpi | wc -l' 

	We zien dan dat er '89' plugins aanwezig zijn.


### c) Wat is de naam en homefolder van de achterliggende user op het systeem?

	Om te kijken welke users er aanwezig zijn op het systeem moeten we 
	gaan kijken in '/etc/passwd', m.b.v: 'cat /etc/passwd'

	Als we hier in kijken vinden we dat er een user is aangemaakt met de naam 'jenkins' 
	waarvan de homefolder te vinden is in '/var/lib/jenkins'.

