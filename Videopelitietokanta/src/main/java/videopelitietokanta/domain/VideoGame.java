package videopelitietokanta.domain;

import java.util.Objects;

/**
 * Lähinnä gettereitä ja setteritä sisältävä luokka, johon tallennetaan tiedot
 * yksittäisestä pelistä. Samannimiset pelit samaistetaan.
 */
public class VideoGame {

    private String name;
    private String console;
    private int publicationYear;
    private boolean completed;

    public VideoGame(String name, String console, int publicationYear) {
        this.name = name;
        this.console = console.trim().toLowerCase();
        this.publicationYear = publicationYear;
        this.completed = false;
    }

    /**
     * Muuntaa pelin merkkijonoksi tiedostoon tallentamista varten
     *
     * @return peli merkkijonona tiedostoon tallentamista varten
     */
    public String asFileString() {
        return name + ";" + console + ";" + publicationYear + ";" + completed;

    }

    /**
     * Käyttäjälle ystävällinen tulostus
     *
     * @return sievässä muodossa oleva tulostus
     */

    @Override
    public String toString() {
        String complition = "ei pelattu läpi";
        if (this.completed) {

            complition = "läpivedetty";
        }
        return name + ",  " + console + ",  " + publicationYear + ",  " + complition;
    }

    public void setCompleted(boolean completed) {
        this.completed = completed;
    }

    public String getName() {
        return name;
    }

    public String getConsole() {
        return console;
    }

    public int getPublicationYear() {
        return publicationYear;
    }

    public boolean isCompleted() {
        return completed;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final VideoGame other = (VideoGame) obj;
        if (!Objects.equals(this.name.trim().toLowerCase(), other.name.trim().toLowerCase())) {
            return false;
        }
        return true;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 43 * hash + Objects.hashCode(this.name.trim().toLowerCase());
        return hash;
    }

}
