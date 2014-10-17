###**Aihemäärittely**###

#### Aihe:  Tetris
Reaaliaikainen peli, jossa ylhäältä laskeutuu erimuotoisia palikoita. Käyttäjän tarkoitus on valintansa mukaan sijoittaa palikat ruudun pohjalle niiden liikkuessa koko ajan alaspäin. Kun tulee täysi rivi, niin rivi häviää ja pisteet nousevat. Rivin hävitessä myös nopeus kasvaa. Peli loppuu, kun jokin palikka ei enää mahdu ruudulle. 

####Käyttäjät:  Pelaaja

####Pelaajan toiminnot:####
<ul>
 <li>Pelaaja aloittaa pelin</li>
 <li>Pelaaja voi kääntää palikkaa</li>
 <ul>
 <li>onnistuu, jos palikka on yhä liikkeellä</li> </ul>
 <li>Pelaaja voi liikuttaa palikkaa sivusuunnassa</li>
 <ul>
 <li>onnistuu, jos palikka on yhä liikkeellä</li> </ul>
 </ul>

---

###**Rakennekuvaus**###

Tähän tetrikseen kuuluu kolme pakettia: grafiikka, pelilogiikka ja objektit. 

Kaiken keskellä on pelilogiikka, jonka luokka Tetris sisältää pelin käynnistykseen ja kulkuun kuuluvat metodit. Pisteidenlasku tapahtuu pelilogiikan lisäksi myös Pelilaudalla. Täällä sijaitsee muun muassa tetrominon liikuttamiseen tarvittavat metodit, tetrominon lisääminen uudeksi liikkuvaksi palikaksi ja vanhojen jo pysähtyneiden palojen säilytys. 

Grafiikka puolestaan sisältää Käyttöliittymän, Näppäimistönkuuntelijan ja Piirtoalustan. Käyttöliittymään on kytketty Piirtoalusta, joka hoitaa konkreettisen palojen piirron jotka näytetään Tetriksen käynnistyessä avautuvassa ikkunassa. Näkymä päivittyy jokaisella kierroksella. Käyttöliittymään kuuluu myös Näppäimistönkuuntelija, joka välittää pelaajan napinpainallukset tetrikselle. 

Viimeinen paketti on objektit, joka sisältää luokat Pelilauta, Tetrominot, Palikka ja Pala. Kolme viimeisintä ovat yhteydessä toisiinsa, sillä tetriksen pelinappuloina toimivat tetrominot, jotka ovat itseasiassa palikoita, jotka puolestaan koostuvat neljästä palasta. Tetrominot-luokassa Palikan paloille annetaan viimeisin silaus. Tetromino ei voi olla olemassa ilman palikkaa eikä palikka ilman paloja. 
Pelilauta toimii tässä tetriksessä hieman niinkuin luurankona, ja yhdellä pelillä on yksi pelilauta. Sen päätoiminen tehtävä on kertoa, onko jossain "ruudussa" pala vai ei, ja laskea myös täysiä rivejä ja niiden mukana pisteitä, joita se sitten ilmoittaa pelilogiikan Tetris-luokalle. 
