# Space invaders

Space invaders on Tomohiro Nishikadon suunnittelema 1978 julkaistu kolikkopeli, jota voi pitää yhtenä nykyisten videopelien uranuurtajista.

Pelissä on pelaajan ohjaama raketti, joka liikkuu kentän alareunassa sivusuunnassa. Tavoitteena on ennen ajan loppumista tuhota kaikki viholliset. Aika loppuu kun viholliset ehtivät maahan, eli pelaajan rakentin luo. Puolustuskeinonaan pelaaja voi ampua vihollisia. SpaceInvaders on hyvin perinteinen peli, josta on erilaisia versioita. Pohjimmiltaan idea on kuitenkin aina sama - tuhoa tunkeilijat. 

Tavoitteenani on JavaFX:ää käyttäen toteuttaa pelistä hyvin yksinkertainen versio, joka sisältää kattavan dokumentaation ja testauksen. Sovellus toimii harjoitustyönäni Helsingin yliopiston Tietojenkäsittelytieteen kurssille Ohjelmistotekniikka, syksyn 2020 toteutukseen.

## Dokumentaatio

 [Vaatimusmäärittely](https://github.com/kivik-beep/ot-harjoitustyo/blob/main/dokumentaatio/vaatimusmaarittely.md)
 
 [Työaikakirjanpito](https://github.com/kivik-beep/ot-harjoitustyo/blob/main/dokumentaatio/tuntikirjanpito.md)
 
 [Arkkitehtuurikuvaus](https://github.com/kivik-beep/ot-harjoitustyo/blob/main/dokumentaatio/arkkitehtuuri.md)
 
 [Käyttöohje](https://github.com/kivik-beep/ot-harjoitustyo/blob/main/dokumentaatio/kayttoohje.md)

 [Testausdokumentti](https://github.com/kivik-beep/ot-harjoitustyo/blob/main/dokumentaatio/testaus.md)

## Releaset

[Viikko 5](https://github.com/kivik-beep/ot-harjoitustyo/releases/tag/viikko5)

[Viikko 6](https://github.com/kivik-beep/ot-harjoitustyo/releases/tag/Viikko6)

[Loppupalautus](https://github.com/kivik-beep/ot-harjoitustyo/releases/tag/loppupalautus)

## Komentorivitoiminnot
### Testaus
Testaus suoritetaan komennolla 
```
mvn test
```
Ja raportti testikattavuudesta komennolla 
```
mvn jacoco:report
```
Testikattavuusraportti tulee kansioon *target/site/jacoco* nimellä **index.html**

### Suoritettavan jar ja sen käyttö
```
mvn package
```
luo hakemistoon *target* suoritettavan **jar-tiedoston SpaceInvaders-1.0-SNAPSHOT.jar**

Hakemistossa target on jo valmiiksi suoritettava tiedosto *SpaceInvaders.jar*, joka on suoritettavissa komennolla
```
java -jar SpaceInvaders.jar
```

### JavaDoc
Luodaan komennolla
```
mvn javadoc:javadoc
```
Javadoc tulee kansioon *target/site/apidocs* nimellä **index.html**

### Checkstyle
Suorittamalla komennon
```
mvn jxr:jxr checkstyle:checkstyle
```
tulee kansioon *target/site* **checkstyle.html** josta voi tarkistaa esiintyykö tekstin muotoilussa checkstyle.xml:ssä määriteltyjä virheitä.
