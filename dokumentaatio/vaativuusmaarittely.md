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
Kun peli loppuu palataan alkunäkymään. 

Lähdetään hyvin yksinkertaisesta suunnitelmasta, mutta todennäköisesti osa jatkokehitysideoista otetaan käyttöön jo pelin aiemmassa versiossa.

tehty | ohjelman osa
----| ----------
  x | pelikenttä
  -| alkunäkymä
   | **hahmot**
 x | alus
 x | ammus
 x | vihollinen
   | **liikkeet**
 x | pelaaja vasen-oikea
  -| ammus - ylös 
  -| vihollinen sivut+alas
  x| liikkeet ei voi mennä yli kentän
   | **muut**
  -| osuma aiheuttaa kuoleman
  -| vihollinen maassa lopettaa pelin
  -| uusi taso kun edellinen on loppu?
  -| ennätykset?
  
  Hahmotelma liikeradoista: 
  
   ![hahmojen liikeradat](https://github.com/kivik-beep/ot-harjoitustyo/blob/main/dokumentaatio/liikkeet.png)
   
### Jatkokehitys:
- Pelikenttää suurentamalla ja vihollisten määrää lisäämällä pelistä saa tehtyä vaikeamman
- Tason loppuessa voi alkaa uusi taso joka on hiukan edellistä nopeampi
- Scoreboard tai pistetilanne joka näkyy esimerkiksi pelikentän yläreunassa
- Pelin graafisia ominaisuuksia on hyvin helppo parannella muotoilemalla osia
- Äänet?
- Perinteisessä pelihalliversiossa pelissä 
	- myös vastustajat ampuvat ammuksia 
	- pelaajan suojana on paikallaan pysyvät suojat (voi muokata ampumalla)
	- pelaajalla on 3 elämää
	- yläreunassa sekä tämänhetkinen tulos että huipputulos
	- mahdollisuus pelata kahdella pelaajalla (pelaajahahmoja on 2)
