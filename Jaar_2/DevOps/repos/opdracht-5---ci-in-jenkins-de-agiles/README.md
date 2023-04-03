# Assignment 5 CI in Jenkins

Voor deze opdracht maken we gebruik van Github en de Jenkins server uit de vorige lessen.

Je krijgt bij het clonen van deze repository een Github repository met daarin een Jenkinsfile die je moet gebruiken voor het opbouwen van je pipeline.

1. Maak een nieuw pipeline project die gebruik maakt van de Jenkinsfile uit deze repository als pipeline script. Alle stages, stappen, aanpassingen aan de pipeline gebeuren vanaf nu in de Jenkinsfile in de repository van deze opdracht. De naam van het project in jenkins mag je zelf kiezen.
  
2. Hierna maak je een fork van onderstaande repository op je eigen github (username) space:
```https://github.com/PXL-2TIN-DevOps-Resources/calculator-app-finished```. Forken kan je met de knop `Fork` rechts bovenaan op de Github pagina. BV. Is je username JohnDoe54 zou je een repository moeten krijgen met als url `https://github.com/JohnDoe54/calculator-app-finished`. Deze url (van de geforkte repository) gebruik je in de volgende stap.
<br/><br/>
:information_source: _Er zijn in deze repository verschillende functionaliteiten, unittesten, ... voor de calculator applicatie voorzien. De codebase is wel aangepast: De package `jest-junit` werd toegevoegd aan de `package.json` file en er werd een jest config voorzien. Dit werd gedaan zodat, wanneer we de unittesten runnen, er een junit rapport gegenereerd wordt in de root directory van de repository._

3. Voorzie een stage "checkout code" die ervoor zorgt dat de code van de calculator app binnengehaald wordt van je persoonlijke calculator repository uit de vorige stap.

![alt_text](https://i.imgur.com/9leib3p.png "image_tooltip")
_Toon aan met screenshots & uitleg onder **punt (a)** in oplossing.md hoe je dit bovenstaande gedaan hebt. Leg de focus hier op het gebruik van de credential manager._

4. Voorzie een `nodejs` configuratie in de global tool configuration van jenkins met als naam "nodetin" die je gebruikt doorheen de pipeline. Tip: NodeJS plugin


![alt_text](https://i.imgur.com/9leib3p.png "image_tooltip")
_Toon aan met screenshots & uitleg onder **punt (b)** in oplossing.md hoe je de global tool configuration ingesteld & gebruikt hebt._

5. Vervolgens maak je een stage “install dependencies” die ervoor zal zorgen dat alle `npm` dependencies van de applicatie geïnstalleerd zullen worden. Denk hierbij terug wat er nodig was in de 1ste les. 

6. Hierna krijgen we een stage “unittest” die de unit testen van de applicatie zal uitvoeren. Daarnaast moet in deze stap ook een junit rapport gemaakt worden en gelinkt worden aan de huidige build. Hoe we de Unittesten van de applicatie kunnen uitvoeren, hebben we in de vorige les gezien. Je zal zelf moeten uitzoeken waar je het test rapport kan terugvinden en hoe je dit koppelt aan de build poging.

7. Voorzie een stage “create bundle” waarbij je alle benodigde files voor de werkende applicatie (de .git folder, .gitignore, readme.md,Jenkinsfile, test folder, ... zijn dus niet nodig!) in een map bundle steekt. Vervolgens wordt er een zip file gemaakt waarin de map "bundle" gestoken wordt.

8. Bij het falen van de volledige pipeline wordt er de melding “pipeline poging faalt op &lt;datum + tijd>” weggeschreven naar een file jenkinserrorlog in de homefolder van de jenkins user op je systeem. Deze file bestaat default niet. Bij het succesvol doorlopen van de pipeline wordt de zip file uit stap 7 gearchiveerd als artifact.

![alt_text](https://i.imgur.com/9leib3p.png "image_tooltip") _De gehele pipeline moet zo opgebouwd zijn dat we hem meerdere malen na elkaar succesvol kunnen uitvoeren. Indien je voor vraag 2 tem. 7 stages/stappen  moet toevoegen, doe je dit ook en documenteer je dit in je oplossing.md file onder **punt (c)**._

![alt_text](https://i.imgur.com/9leib3p.png "image_tooltip") _Zoek een manier waarop je ervoor kan zorgen dat de pipeline automatisch elke vrijdag om 14u zal draaien. Documenteer je werkwijze & oplossing onder **punt (d)** in de oplossing.md file._

![alt_text](https://i.imgur.com/9leib3p.png "image_tooltip")
_Zorg ervoor dat alle **werkende** stappen aanwezig zijn in de Jenkinsfile van je repository. Indien deze hier niet in staan, krijg je voor deze opdracht ook geen punten._

# Deliverable
Een repository met:
- Een opgevulde Jenkinsfile
    - Geen gevulde Jenkinsfile = 0 op deze opdracht
    - Een niet werkende (=syntax errors in het pipeline script) Jenkinsfile = -30% op het eindresultaat
- Een opgevulde oplossing.md file met antwoorden op bovenstaande vragen inclusief screenshots
