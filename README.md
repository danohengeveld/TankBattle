# OOPD Processing Game Engine (OOPG) [![Build Status](https://travis-ci.org/HANICA/oopg.svg?branch=master)](https://travis-ci.org/HANICA/oopg) [![Coverage Status](https://coveralls.io/repos/github/HANICA/oopg/badge.svg?branch=master)](https://coveralls.io/github/HANICA/oopg?branch=master)
In deze repository staat de game-engine die studenten moeten gebruiken voor het beroepsproduct van OOPD (de game). De engine werd in 2014-2015 ontwikkeld door een aantal OOSE-studenten en wordt momenteel doorontwikkeld door docenten en studenten van ICA.

## API
De volledige API van is online beschikbaar: [API OOPG](http://hanica.github.io/oopg/)
## Oorspronkelijke ontwikkelaars
De engine werd gebaseerd op de oude [Android-engine](https://github.com/ddoa/game-api-android) die ontwikkeld werd onder begeleiding van (en door) Paul Bergervoet.

De eerste versie van huidige engine werd gebouwd door de volgende OOSE-studenten (opdrachtgever was Ralph Niels en de groep werd begeleid door Rody Middelkoop):

* Bram Heijmink
* Jeffrey Haen
* Joost Elshof
* Kenny Ligthart
* Mark Vaesen
* Nico Smolders

## Hoe ga je lokaal aan de slag in Eclipse
### 1. Clone deze repo naar een (logische) lokale folder.
Handigst is om hier direct de naam te kiezen i.v.m. toekomstige upload in iSAS (kies dus een naam voor je spel; e.g. NIET `nieuw-spel`!)

>git clone https://github.com/HANICA/oopg.git oopg-nieuw-spel
NB Hiervoor moet je [git](https://git-scm.com/book/en/v2/Getting-Started-Installing-Git) gedowload en -installeerd hebben. Je kunt ook soortgelijk doen via een grafische git UI als GitHub for Windows of TreeSource. Of je kunt de zip zelf downloaden uit Github en uitpakken. Graag wel de root foldernaam aanpassen.
<img width="500" alt="Clone repo of download zip" src="https://user-images.githubusercontent.com/3029472/40170033-c4ce6218-59c7-11e8-95a9-1d125786ea92.png">


### 2. Importeer folder in (nieuw) Eclipse project
Als je de code lokaal hebt staan moet je deze nog importeren in Eclipse zodat je er hier mee kunt werken.
Je kunt dit ook in IntelliJ doen als je dit een fijnere IDE vindt. Dit gaat soortgelijk, we beschrijven hier alleen Eclipse.

Kies menu `File` -> `Import...` en dan `Projects from folder or archive...`
<img width="500" alt="Importeer game in Eclipse" src="https://user-images.githubusercontent.com/3029472/40170032-c4b53f40-59c7-11e8-853e-382ea1d9549d.png">

In de `Import project...` dialoog blader naar de folder aangemaakt bij stap 1
<img width="500" alt="Project import dialoog" src="https://user-images.githubusercontent.com/3029472/40170031-c49d996c-59c7-11e8-922c-4e4c0ccf9815.png">

### 3. Run de voorbeeld game
Run nu de game om te checken of alles werkt.
Blader in het in stap 2 geimporteerde project in Eclipse naar WaterWorld.java, rechtsklik en 

Maak nu een nieuwe folder voor je eigen game naast de folder voor Waterworld, met ook een klasse met een public static main en gebruik WaterWorld als voorbeeld. Ga niet blind copy-pasten, maar neem alleen over wat je nodig hebt, of bouw dit zelf stapsgewijs uit. Dit staat verder beschreven in de tutorials.

<img width="500" alt="Voorbeeld game -> Run as Java Application" src="https://user-images.githubusercontent.com/3029472/40170030-c48446f6-59c7-11e8-9e74-d9e1a737bb3d.png">

### Werkt het niet?
Check of je al bovenstaande stappen goed hebt doorlopen. Pas aan of begin evt. opnieuw. RTM! Vraag anders een collega student of de docent.
