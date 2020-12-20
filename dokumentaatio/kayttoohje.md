# Käyttöohje
Lataa tiedosto SpaceInvaders.jar

## Ohjelman käynnistäminen
Ohjelma käynnistetään komennolla

```
java -jar SpaceInvaders.jar
```
## Aloitus
Sovellus käynnistyy aloitusnäkymään.
Aloitusnäkymässä voi määrittää oman nimensä ja määrittää miltä tasolta haluaa pelin aloittaa (1-5).  Tason valinta vaikuttaa vihollisten määrään ja mikäli tason jättää valitsematta, aloitetaan tasolta 3. 
Pelin alkaa saadessaan käskyn, eli kun pelaaja klikkaa nappulaa *start*.

<img src="https://github.com/kivik-beep/ot-harjoitustyo/blob/main/dokumentaatio/kuvat/alku.png" width="400">

## Pelaaminen
Pelaaja liikuttaa alustaan vasemmalle ja oikealle nuolinäppäimillä. Välilyönnistä alus ampuu, tavoitteena on tuhota mahdollisimman monta vihollista ennen kuin viholliset ehtivät maahan. Peli voi päättyä kahdella eri tavalla: joko **pelaaja lopettaa pelin painamalla 'q'** tai viholliset ennättävät laskeutua alas **jolloin peli loppuu itsestään**. Uusia vihollisiaa tulee aina kun pelaaja on saanut kaikki edelliset tuhottua.  

<img src="https://github.com/kivik-beep/ot-harjoitustyo/blob/main/dokumentaatio/kuvat/peli.png" width="400">

## Pelin loppu
Vihollisten päästessä maahan tai pelaajan painaessa 'q' peli loppuu. Loppunäkymässä voi nähdä yhteenvedon omasta pelistään: montako pistettä sai (10p/vihollinen), mille top10 sijalle tulos yltää ja montako vihollista onnistui tuhoamaan. 
Mikäli pelaamista haluaa jatkaa, onnistuu se kahdella tavalla. Joko suoraan, painamalla nappulaa "play again" tai kulkemalla aloitusikkunan kautta painamalla nappulaa "to start". Suoraan aloittamalla pelaajan nimi säilyy ennallaan ja aloitustasona toimii 3.

<img src="https://github.com/kivik-beep/ot-harjoitustyo/blob/main/dokumentaatio/kuvat/loppu.png" width="400">
