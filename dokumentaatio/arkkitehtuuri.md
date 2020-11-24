# Arkkitehtuurikuvaus

## Rakenne
Koodin pakkausrakenne on seuraava:

spaceinvaders.ui ---> spaceinvaders.domain ---> spaceinvaders.dao

Pakkaus spaceinvaders.ui sisältää käyttöliittymän, 
spaceinvaders.domain sovelluslogiikan 
ja spaceinvaders.dao tietojen pysyväistalletuksen *(sitten kun se on ajankohtaista)*

## Käyttöliittymä

Käyttöliittymä sisältää kolme erilaista näkymää
- aloitusnäkymä
- pelinäkymä
- lopetusnäkymä

Pyrin luomaan pelinäkymän mahdollisimman valmiiksi ennen toisten näkymien luontia. 

Käyttöliittymä on koitettu saada mahdollisimman erilleen sovelluslogiikasta. 

## Sovelluslogiikka
Sovelluslogiikan merkittävin osa on hahmo, eli luokka Character. Kaikki liikkeet on ohjelmoitu tähän luokkaan. 
Hahmon alaluokkat Invader, Shot ja Ship rakentavat pelin liikkuvat osat. Alaluokat määrittelevät kunkin hahmon muodon, lisäksi 
hahmot joiden pitää osata liikkua itsenäisesti (eli shot ja Invader) määritetään niiden omat liikeradat.

Hahmoilla on myös boolean-arvo joka kertoo ovatko ne hengissä vai ei. Tämän toiminnallisuus mietitään myöhemmin pidemmälle.


## Tietojen pysyväistalletus
Lopetusnäkymään on tavoitteena saada myöhemmin ennätysnäkymä, johon myös uuden ennätyksen saanut pelaaja voi syöttää nimimerkkinsä.
Ennätykset tullaan siis tallentamaan jonkinlaiseen tiedostoon, josta niitä voi kutsua.

## Ojelman rakenteen heikkoudet
se ei vielä toimi
