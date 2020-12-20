# Testausdokumentti
Ohjelma on testattu käyttöliittymän osalta manuaalisesti käyttäjänä, sekä sovellislogiikan ja Dao:n osalta JUnit integraatio ja yksikkö-testenä.

## Sovelluslogiikka
### spaceinvaiders.domainin testaus: CharacterTest ja GameTest 
Nämä luokat on testattu lähinnä automatisoiduilla testeillä. Testit on suoritettu kahdessa luokassa, 
**CharacterTest** vastaa hahmojen toimintojen oikeallisuudesta. Tämä on ohjelman testiluokista suurin ja kenties tärkein. Luokka vastaa liikkeistä ja hahmojen tilasta.

Toinen testiluokka tässä kansiossa on **GameTest**. Game luokan tärkein tehtävä on kommunikoida käyttöjärjestelmän kanssa. Testauksissa on keskitytty siihen, että hahmojen luonti onnistuu toivotulla tavalla.
Tämän luokan testeistä iso osa on gettereitä ja settereitä, mutta niitäkin on pyritty mahdollisimman hyvin testaamaan - kattavasti mutta niin että myös testistä olisi jotain hyötyä.
<img src="https://github.com/kivik-beep/ot-harjoitustyo/blob/main/dokumentaatio/kuvat/testaus.png" width="800">
## DAO
### spaceinvaders.daon testaus: PlayerTest ja RecordsTest
**PlayerTest** on testattu kuten sovelluslogiikka - mahdollisimman kattavasti eri metodeita käyttäen. RecordsTest on suoritettu luomalla parametrilline metodi Record(tietokanta),
jolla tietokanta *highscores.csv* on saatu vaihdettua tietokantaan *testscores.csv*. Testauksen jälkeen testitietokanta kirjoitetaan uudelleen takaisin alkuperäiseen muotoonsa.

### Testauskattavuus 
Testauksen rivikattavuus ohjelmassa edellämainittujen luokkien osalta on 91% ja haarautumakattavuus 86%. 
Testaamatta jääneet metodien osat koskivat tilanteita, joissa tiedostoa ei ole olemassa (try-catch:ia käyttävien metodien catch). Testaamattomia metodeita tuli tupla määrä jotta päästiin eroon tilanteesta jossa vaadittua dokumenttia löydy(molemmat kattavuudet laskivat tämän vuoksi 5%). Ongelma on korjattu luomalla uusi dokumentti catchiin, mutta tästä tuli yksi try-catch lisää joka pykälään. 
Lisäksi DAO:n parametriton luonti jäi testaamatta, sillä highscores.csv haluttiin jättää rauhaan ja CharacterTestissä sekä RecordsTestissä yksi rivi jäi testaamatta vaikean saavutettavuuden takia.

## Järjestelmätestaus
Sovelluksen järjestelmää on testattu manuaalisesti antamalla ohjelmalle erilaisia ja virheellisiä syötteitä. Ohjelma on kuitenkin varautunut näihin ongelmiin suhteellisen hyvin.
Sovellus on asennettu uudelleen ja sitä on testattu käyttöohjeen mukaisesti Linux-ympäristössä. Kaikki toiminnallisuudet on käyty läpi tavoilla joihin ohjelma antaa mahdollisuude.

##Sovellukseen jääneet ongelmat 
Dao:n Records luokan konstruktori olisi pitänyt saada sekä normaalilla että testiarvolla testattua luotettavasti. Try - catch -ongelma ja sen laskeva vaikutus testikattavuuksiin on ikävä, tämä olisi ollut hyvä vielä ratkaista.
