# Arkkitehtuurikuvaus

## Rakenne
Koodin pakkausrakenne on seuraava:

![](https://github.com/kivik-beep/ot-harjoitustyo/blob/main/dokumentaatio/kuvat/pakkausrakenne.png)

Pakkaus spaceinvaders.ui sisältää JavaFX:llä toteutetun käyttöliittymän, 
spaceinvaders.domain sovelluslogiikan 
ja spaceinvaders.dao tietojen pysyväistalletuksen *(dao toistaiseksi luomatta)*

## Käyttöliittymä

Käyttöliittymä sisältää kolme erilaista näkymää
- aloitusnäkymä
- pelinäkymä
- lopetusnäkymä

Kukin näistä on oma Scene-olionsa. Näkymät tulevat yksi kerrallaan näkyville sovelluksen stageen.
Käyttöliittymä on eriytetty mahdollisimman erilleen sovelluslogiikasta. 

Aloitusnäkymästä siirrytään pelinäkymään pelaajan painaessa aloitusnappulaa. Kun pelaajan hahmo on tuhoutunut, siirtyy näkymäksi lopetusnäkymä.

## Sovelluslogiikka
Sovelluksessa on kolmea eri hahmotyyppiä; alus, invader ja ammus. 
Hahmot luodaan niiden omissa luokissa, jotka ovat yleisen Character-luokan aliluokkia. Character määrittää liikkeet, joita kukin hahmo käyttää tarvitsemallaan tavalla. 

Pelaamisen pohjustamiseen tehty Game-luokka alustaa pelin, eli luo tarvittavan vihollisarmeijan ja muut hahmot. Game-luokkaa käytetään keskusteluun käyttöliittymän kanssa. *Tulevaa: Kun pelaaja on läpäissyt tason, asettaa luokka Game uuden tason pelattavaksi. Game sisältää siis myös pelaajan tiedot ennätyksen kirjaamiseksi, ja välittää tämän tiedon dao:on. Dao:n toiminta vielä tarkemmin suunnittelematta.*

Hahmotelma luokka/pakkauskaaviosta:

<img src="https://github.com/kivik-beep/ot-harjoitustyo/blob/main/dokumentaatio/kuvat/luokkakaavio.png" width="400">

## Tietojen pysyväistalletus
Lopetusnäkymään on tavoitteena saada myöhemmin ennätysnäkymä, johon myös uuden ennätyksen saanut pelaaja voi syöttää nimimerkkinsä.
Ennätykset tullaan siis tallentamaan jonkinlaiseen tiedostoon, josta niitä voi kutsua. Kuten yllä todettu, pysyväistalletus vielä toteuttamatta.

## Päätoiminnallisuudet
Ohjelman sekvenssikaavio viikolta 5 ei enää vastaa todellisuutta, mutta antaa silti hyvää osviittaa miten sovelluslogiikka ohjelmassa toimii:

<img src="https://github.com/kivik-beep/ot-harjoitustyo/blob/main/dokumentaatio/kuvat/sekvenssikaavio.png" width="500">

Tulen päivittämään ohjelman päätoiminnallisuuksia myöhemmin. 

## Ohjelman rakenteen heikkoudet
### sovelluslogiikka
Sovelluslogiikassa olevat hahmot ovat luotu JavaFX:n Polygoneina omissa luokissaan, näiden Polygonin luonnit olisi ilmeisesti ollut hyvä saada käyttöliittymän puolelle. Tämä tuli esiin itselle viikolla 6, ja ongelman korjaaminen tässä vaiheessa saattaisi aiheuttaa suuria ongelmia muussa toiminnallisuudessa ja häiritä sovelluksen muiden, tärkeämpien osien etenemistä loppupalautusta varten toivomalleni tasolle. Muutoin käyttöliittymän osia ei ole sovelluslogiikan puolella.
