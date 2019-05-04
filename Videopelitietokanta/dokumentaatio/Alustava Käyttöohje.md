# Käyttöohje

Lataa tiedosto videopelitietokanta.jar (linkki tähän)

Ohjelma suoritetaan komennolla 
`java -jar videopelitietokanta.jar`

Sovellus käynnistyy perusnäkymään, jolloin näet eri mahdolliset komennot:

kuva perusnäkymästä

Käydään seuraavaksi kaikki komennot läpi.

### 1 Pelin lisääminen
Valitsemalla 1, voit lisätä uuden pelin. Tällöin ohjelma kysyy pelin nimeä, konsolia ja vuosilukua, jolloin se on tehty. Huomaa, että pelin nimi tai konsoli eivät saa sisältää puolipisteitä, ja vuosiluvun pitää olla kokonaisluku.

kuva pelin lisäämisestä

Saman nimistä peliä ei voi lisätä moneen kertaan.


### 2 Pelien tulostaminen
Valitsemalla 2 voit tulostaa kaikki pelit. Ohjelma kysyy ensin, että haluatko ryhmitellä tulostuksen aakkosittain (1), konsoleittain (2), vai vuosittain(3). 

kuva tulostuksesta

### 3 Pelin poistaminen ja  4 merkitseminen läpipelatuksi
Syöttämällä 3 voit poistaa pelin. Ohjelma kysyy tällöin sen pelin nimeä, jonka haluat poistaa. Vastaavasti toimii pelin merkitseminen läpipelatuksi. Voit tarkistaa, että muutokset toimivat perusnäkymästä valitsemalla 2 ja tulostamalla kaikki pelit.

Kuva pelin poistamisesta.

Lisäys, jos saat lowercaset toimimaan

### 5 Tilastojen tulostaminen
Saat tulostettua konsolikohtaisia tilastoja valitsemalla 5.

### 6 Kaikkien pelien poistaminen
Valitsemalla 6 voit poistaa kaikki ohjelmaan tallennetut pelit. Tällöin ohjelma kysyy sinulta vahvistusta ja syöttämällä Y poistat kaikki pelit. Syöttämällä mitä tahansa muuta, esim n voit perua poiston.


1 syötä peli, 2 tulosta pelejä, 3 poista peli, 4 pelaa peli läpi, 5 tilastoja, 6 poista kaikki, q lopeta
1
nyt syötetään peli
Anna nimi:
The Legend Of Zelda
Anna konsoli
NES
Anna julkaisuvuosi
1986

1 syötä peli, 2 tulosta pelejä, 3 poista peli, 4 pelaa peli läpi, 5 tilastoja, 6 poista kaikki, q lopeta
1
nyt syötetään peli
Anna nimi:
the legend of zelda
Anna konsoli
nes
Anna julkaisuvuosi
1986
peli on jo lisätty

1 syötä peli, 2 tulosta pelejä, 3 poista peli, 4 pelaa peli läpi, 5 tilastoja, 6 poista kaikki, q lopeta
2
Minkä mukaan tulostus järjestetään
1 aakkosittain, 2 konsoleittain, 3 vuoden mukaan
1
tulostetaan pelit muodossa
peli,   konsoli,   vuosi, pelattu läpi

Castlevania,  nes,  1986,  ei pelattu läpi
Final Fantasy X,  ps2,  2002,  ei pelattu läpi
MediEvil 2,  ps1,  2000,  ei pelattu läpi
Super Mario Bros.,  nes,  1986,  ei pelattu läpi
The Legend Of Zelda,  nes,  1986,  ei pelattu läpi

1 syötä peli, 2 tulosta pelejä, 3 poista peli, 4 pelaa peli läpi, 5 tilastoja, 6 poista kaikki, q lopeta
3
Anna nimi:
zelda
ei ole tuon nimistä peliä alunperinkään

1 syötä peli, 2 tulosta pelejä, 3 poista peli, 4 pelaa peli läpi, 5 tilastoja, 6 poista kaikki, q lopeta
3
Anna nimi:
the legend of zelda
poistettu

1 syötä peli, 2 tulosta pelejä, 3 poista peli, 4 pelaa peli läpi, 5 tilastoja, 6 poista kaikki, q lopeta
4
Mikä peli on pelattu läpi
castlevania
Peli merkitty läpipelatuksi

1 syötä peli, 2 tulosta pelejä, 3 poista peli, 4 pelaa peli läpi, 5 tilastoja, 6 poista kaikki, q lopeta
2
Minkä mukaan tulostus järjestetään
1 aakkosittain, 2 konsoleittain, 3 vuoden mukaan
3
tulostetaan pelit muodossa
peli,   konsoli,   vuosi, pelattu läpi

Super Mario Bros.,  nes,  1986,  ei pelattu läpi
Castlevania,  nes,  1986,  läpivedetty
MediEvil 2,  ps1,  2000,  ei pelattu läpi
Final Fantasy X,  ps2,  2002,  ei pelattu läpi

1 syötä peli, 2 tulosta pelejä, 3 poista peli, 4 pelaa peli läpi, 5 tilastoja, 6 poista kaikki, q lopeta
5
tulostetaan tilastoja
nes yhteensä 2 läpivedetty 1 läpivetoprosentti 50%
ps2 yhteensä 1 läpivedetty 0 läpivetoprosentti 0%
ps1 yhteensä 1 läpivedetty 0 läpivetoprosentti 0%

1 syötä peli, 2 tulosta pelejä, 3 poista peli, 4 pelaa peli läpi, 5 tilastoja, 6 poista kaikki, q lopeta
6
Varmista, että haluat poistaa kaikki: Y
n
keskeytetään poisto

1 syötä peli, 2 tulosta pelejä, 3 poista peli, 4 pelaa peli läpi, 5 tilastoja, 6 poista kaikki, q lopeta
q
heihei


