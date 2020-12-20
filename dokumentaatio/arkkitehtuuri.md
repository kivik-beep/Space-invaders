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
Sovelluksen keskeisimmät toiminnot saadaan kattavasti esitettyä kolmella kaaviolla, jotka kuvaavat kukin oman näkymänsä toimintoja. 

### Aloitusnäkymä

<img src="https://github.com/kivik-beep/ot-harjoitustyo/blob/main/dokumentaatio/kuvat/Start.png" width="600">

Aloitusnäkymässä käyttäjällä on mahdollisuus valita itselleen nimi ja aloitustaso (vaikuttaa vihollisrivien määrään).
Kun pelaaja aloittaa pelin painamalla start-nappulaa, luodaan uusi peli, uudet viholliset ja alus pelaajan ohjattavaksi. 

### Pelinäkymä

<img src="https://github.com/kivik-beep/ot-harjoitustyo/blob/main/dokumentaatio/kuvat/Animate.png" width="600">

Tässä näkymässä on itse peli. Pelaaja pystyy liikuttamaan alustaan vasemmalle ja oikealle. Välilyönnistä peli luo uuden ammuksen, joka liikkuu suoraan ylöspäin. Ammuksia on rajoitettu määrä. Mikäli ammus osuu viholliseen, tuhoutuu sekä ammus että vihollinen ja pelaaja saa 10 pistettä lisää. Jos ammus ei osu mihinkään, tuhoutuu se poistuessaan pelikentältä. 

**Peli voi päättyä kahdella eri tavalla:**
1. pelaaja painaa näppäintä "q" ja peli päättyy
2. viholliset pääsevät maahan ja peli päättyy.

### Loppunäkymä

<img src="https://github.com/kivik-beep/ot-harjoitustyo/blob/main/dokumentaatio/kuvat/GameOver.png" width="600">

Tässä näkymässä tapahtuu tiedon tallennus ja luku tiedostosta. Loppuessaan peli välittää tiedon pelaajan tiedot( eli nimen ja pisteet) loppunäkymään. Loppunäkymässä luodaan näiden perusteella uusi pelaaja-hahmo. Pelaaja-hahmo lisätään ennätyslistalle ja mikäli pelissä on suoriuduttu tarpeeksi hyvin, pääsee pelaaja top10 listalle! Top10 lista on tiedosto, josta löytyy ennestään 10 hahmon tiedot. Uuden hahmon lisäämisen jälkeen haetaan tieto ennätyksistä, pelaajat lisätään ArrayListiin ja järjestetään pisteiden mukaan. Mikäli (kun) hahmoja on yli 10, poistetaan ylimääräiset hahmot listalta. 

## Ohjelman rakenteen heikkoudet
### sovelluslogiikka
Sovelluslogiikassa olevat hahmot ovat luotu JavaFX:n Polygoneina omissa luokissaan, näiden Polygonin luonnit olisi ilmeisesti ollut hyvä saada käyttöliittymän puolelle. Tämä tuli esiin itselle viikolla 6, ja ongelman korjaaminen tässä vaiheessa saattaisi aiheuttaa suuria ongelmia muussa toiminnallisuudessa ja häiritä sovelluksen muiden, tärkeämpien osien etenemistä loppupalautusta varten toivomalleni tasolle. Muutoin käyttöliittymän osia ei ole sovelluslogiikan puolella.
