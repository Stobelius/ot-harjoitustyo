# Videopelitietokanta
Tähän sovellukseen voin tallentaa oman videopelikokoelmani. Peleistä pidetään kirjaa ja luodaan tilastoja.




## Dokumentaatio
[Määrittelydokumentti](https://github.com/Stobelius/ot-harjoitustyo/blob/master/Videopelitietokanta/dokumentaatio/Alustava_maarittelydokumentti.md)

[Työaikakirjanpito](https://github.com/Stobelius/ot-harjoitustyo/blob/master/Videopelitietokanta/dokumentaatio/tyoaikakirjanpito.md)

[Alustava arkkitehtuuri](https://github.com/Stobelius/ot-harjoitustyo/blob/master/Videopelitietokanta/dokumentaatio/arkkitehtuuri.md)

[Alustava käyttöohje](https://github.com/Stobelius/ot-harjoitustyo/blob/master/Videopelitietokanta/dokumentaatio/Alustava%20K%C3%A4ytt%C3%B6ohje.md)

## Releaset
Käyttämällä koneellani tuli jar-tiedoston suorittamisessa virhe java.lang.UnsupportedClassVersionError Pienen Googlauksen mukaan tämä johtuisi koneeni java versiosta. Valitettavasti en pääse nyt testaamaan toisella koneella asiaa. Viime viikolla laitoksen koneella viime viikon jar toimi hyvin. Netbeansissa tämän viikon koodi kääntyy normaalisti. Julkaisin mahdollisesti ei kääntyvän jarin kuitenkin alla releasena.

[Viikko 6](https://github.com/Stobelius/ot-harjoitustyo/releases/tag/viikko6)

[Viikko 5](https://github.com/Stobelius/ot-harjoitustyo/releases/tag/viikko5)

## Komentorivitoiminnot
Testit suoritetaan komennolla: `mvn test`

Testikattavuus:
``
mvn test jacoco:report
``

Checkstyle:`mvn jxr:jxr checkstyle:checkstyle`

jar-tiedoston genenerointi. : `mvn package`

