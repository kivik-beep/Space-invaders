## Vaatimusmäärittely

Kyseessä on harjoitustyönä luotu SpaceInvaders peli. 
Pelissä tavoitteena on ehtiä ampua kaikki viholliset ennen kuin aika loppuu, eli viholliset ehtivät alimmalle riville. 

### Pelissä on kolme osaa:
1. Pelikenttä
	- neliön mallinen pohja
2. pelaajan ohjaama alus 
	- liikkuu nuolinäppäimillä vasemmalle ja oikealle
	- ampuu (space) (*ammus kuutio*)
3. vihollisalukset
	- vihollisen rivit jotka liikkuvat pelialuetta reunasta toiseen
	- kun saapuvat reunaan, lasketuvat hieman alaspäin ja vaihtavat suuntaa

### Käyttöliittymä
Pelissä on kolme näkymää.
 1. Aloitusnäkymä
  - pelaaja voi valita tason jolta aloittaa
  - pelaaja voi määrittää nimensä
 
 2. Pelinäkymä
  - Näkymä johon siirrytään kun aloitusnäkymässä on painettu nappia "start".
  - Sisältää yllä kuvatun toiminnallisuuden, eli itse pelin. 
  - Vihollisia on aina rivissä 5, taso määrittää montako riviä vihollia on.
  - Kun kaikki viholliset on tuhottu, alkaa uusi taso.
 
 3. Loppunäkymä
  - Tallettaa pelaajan tiedot ennätykset sisältävään tiedostoon.
  - Esittää pelaajalle 10 parasta tulosta
  - Loppunäkymässä on nappi "new game", jolla pääsee uuteen aloitusnäkymään.
  
  
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
