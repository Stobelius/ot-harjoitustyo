/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package videopelitietokanta.domain;

import java.util.Objects;

/**
 *
 * @author stobe
 */
public class VideoGame {

    private String name;
    private String console;
    private int publicationYear;
    private boolean completed;

    public VideoGame(String name, String console, int publicationYear) {
        this.name = name;
        this.console = console;
        this.publicationYear = publicationYear;
        this.completed = false;
    }

    public String asFileString() {
        return name + ";" + console + ";" + publicationYear + ";" + completed;

    }

    @Override
    public String toString() {
        return name + ",  " + console + ",  " + publicationYear + " "; //To change body of generated methods, choose Tools | Templates.
    }

    public void complete() {
        this.completed = true;
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
        if (!Objects.equals(this.name, other.name)) {
            return false;
        }
        return true;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 43 * hash + Objects.hashCode(this.name);
        return hash;
    }

}