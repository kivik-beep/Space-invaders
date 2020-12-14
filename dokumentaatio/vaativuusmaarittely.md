## Harjoitustyön vaativuusmäärittely
Tavoitteena on tehdä space invaders peli. 

### Pelissä on kolme osaa:
1. Pelikenttä
	- neliön mallinen pohja
2. pelaajan ohjaama alus (*yksinkertainen muoto esim kolmio*)
	- liikkuu yhdellä rivillä edestakaisin (*nuolinäppäimillä*)
	- ampuu (space) (*ammus kuutio*)
3. vihollisalukset (*yksinkertainen selvästi pelaajan aluksesta poikkeava muoto*)
	- vihollisen rivit jotka liikkuvat pelialuetta reunasta toiseen
	- kun saapuvat reunaan, lasketuvat yhden rivin alaspäin 

Pelin avatessa tulee aloitusnäkymä jonka kuittaamalla peli lähtee käyntiin
	-> omaa alusta voi liikuttaa ja vastustajat lähtevät liikkeelle

Toiminnallisuus: 
Pelin tavoitteena on ehtiä ampua kaikki viholliset ennen kuin aika loppuu, eli viholliset ehtivät alimmalle riville.
Pelaajan aloittaessa pelin peli alkaa.

Vihollisia on 5kpl rivissä, ja aina kun viholliset on ammuttu siirrytään seuraavalle tasolle.
Vihollisrivien määrä lisääntyy joka tasolla yhdellä. Peli alkaa kolmella rivillisellä eli ensimmäisellä tasolla kolme rivia, toisella neljä jne. 

Kun peli loppuu palataan loppunäkymään, jossa on mahdollista nähdä ennätyslista ja aloittaa uusi peli. 


### Viikolla 7
Tämän viikon uudet toiminnallisuudet näkyvät paksunnettuna alla. 

tehty | ohjelman osa
----| ----------
  x | pelikenttä
  x| alkunäkymä
  -| loppunäkymä
   | **hahmot**
 x | alus
 x | ammus
 x | vihollinen
   | **liikkeet**
 x | pelaaja vasen-oikea
  x| ammus - ylös 
  x| vihollinen sivut+alas
  x| liikkeet ei voi mennä yli kentän
   | **muut**
  x| osuma aiheuttaa kuoleman
  x| vihollinen maassa lopettaa pelin
  **x**| uusi taso kun edellinen on loppu
  -| ennätykset
  
  
  Hahmotelma liikeradoista: 
  
   ![hahmojen liikeradat](https://github.com/kivik-beep/ot-harjoitustyo/blob/main/dokumentaatio/kuvat/liikkeet.png)
   
### Jatkokehitys:
- Pelikenttää suurentamalla ja vihollisten määrää lisäämällä pelistä saa tehtyä vaikeamman
- Scoreboard tai pistetilanne joka näkyy esimerkiksi pelikentän yläreunassa
- Pelin graafisia ominaisuuksia on hyvin helppo parannella muotoilemalla osia
- Äänet?
- Perinteisessä pelihalliversiossa pelissä 
	- myös vastustajat ampuvat ammuksia 
	- pelaajan suojana on paikallaan pysyvät suojat (voi muokata ampumalla)
	- pelaajalla on 3 elämää
	- yläreunassa sekä tämänhetkinen tulos että huipputulos
	- mahdollisuus pelata kahdella pelaajalla (pelaajahahmoja on 2)
