# Videopelitietokanta
Tähän sovellukseen voin tallentaa oman videopelikokoelmani. Peleistä pidetään kirjaa ja luodaan tilastoja.

## Ongelmia pakkauksiin jakaessa
Aiemmin minulla oli kaikki koodi samassa pakkauksessa. Kun rupesin jakamaan sitä, kuten pyydettiin, niin koodi ei enää toiminutkaan. En saanut tätä korjattua mitenkään helposti yksinäni, joten siirsin kaikki takaisin samaan pakkaukseen. Koodi kääntyy nyt sentään jotenkin, mutta siinä on edelleen enemmän bugeja, kun ennen pakkauksiin jakoa. Aion katsoa tätä pajassa ohjaajien kanssa, kunhan tervehdyn ja pääsen laitokselle. 

Tosiaan pakkauksiin jako on nyt kesken, mutta aion sen tehdä seuraavalla tavalla. Pakkaus ui: VideoGameDataBaseApplication, TextUI. Pakkaus domain: VideoGame. Pakkaus dao: Dao, FileDao.



## Dokumentaatio
[Määrittelydokumentti](https://github.com/Stobelius/ot-harjoitustyo/blob/master/laskarit/viikko2/Alustava_maarittelydokumentti.md)

[Työaikakirjanpito](https://github.com/Stobelius/ot-harjoitustyo/blob/master/laskarit/tyoaikakirjanpito.md)


## Komentorivitoiminnot
Testit suoritetaan komennolla: `mvn test`

Testikattavuus:
``
mvn test jacoco:report
``
Checkstyle:`mvn jxr:jxr checkstyle:checkstyle`

