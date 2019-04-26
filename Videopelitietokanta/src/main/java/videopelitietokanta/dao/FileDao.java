package videopelitietokanta.dao;

import videopelitietokanta.domain.YearGameComparator;
import videopelitietokanta.domain.ConsoleGameComparator;
import videopelitietokanta.domain.AlphabeticGameComparator;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import videopelitietokanta.domain.VideoGame;

/**
 * Luokka kirjoittaa videopelejä tiedostoon, sekä lukee sieltä listoja ja
 * järjestää niitä.
 */
public class FileDao implements Dao {

    private File file;
    private FileWriter writer;

    public FileDao() {

        this.file = new File("games.txt");
        try {
            writer = new FileWriter(file, true);

        } catch (Exception e) {
            try {
                FileWriter fileMaker = new FileWriter(new File("games.txt"));
                fileMaker.close();

                writer = new FileWriter(file, true);

            } catch (Exception ee) {
                System.out.println("failing to create games.txt");
            }
        }

    }

    /**
     * Lisää videopelin tiedostoon.
     *
     * @param game Käyttäjän tiedoista muodostettu peli
     * @return Palauttaa true, jos pelin lisääminen onnistui. Palauttaa false,
     * jos samanniminen peli on jo tiedostossa.
     */
    @Override
    public boolean add(VideoGame game) {
        if (this.contains(game)) {
            return false;
        }

        try {

            writer.write(game.asFileString() + "\r\n");
            writer.flush();
            return true;

        } catch (Exception e) {
            System.out.println("not managing to write to file " + e.getMessage());
        }
        return false;

    }

    private VideoGame getGameByName(String name) {
        for (VideoGame vg : this.list()) {
            if (vg.getName().equals(name)) {
                return vg;
            }
        }

        return null;
    }

    /**
     * Merkitsee, että annettu peli on pelattu läpi.
     *
     *
     * @param name Pelin nimi
     *
     * @return Paluttaa true, argumentin niminen peli löydettiin tiedostosta ja
     * muutettiin läpipelatuksi. Palauttaa false, jos peliä ei löydetty.
     */
    public boolean complete(String name) {
        VideoGame testGame = new VideoGame(name, "", 0);
        if (!this.contains(testGame)) {
            return false;
        }

        VideoGame game = this.getGameByName(name);

        game.setCompleted(true);

        this.remove(name);
        this.add(game);

        return true;
    }

    /**
     * Kertoo, onko kyseinen peli jo tiedostossa.
     *
     * @param game Pelin nimi
     * @return Löytyykö peli
     */
    public boolean contains(VideoGame game) {

        if (this.list().contains(game)) {
            return true;
        }

        return false;
    }

    /**
     * Poistaa pelin, jonka nimenä on annettu argumentti
     *
     *
     * @param name Pelin nimi
     *
     * @return Paluttaa true, argumentin niminen peli löydettiin tiedostosta ja
     * poistettiin. Palauttaa false, jos peliä ei löydetty.
     */
    @Override
    public boolean remove(String name) {
        VideoGame game = new VideoGame(name, "", 0);

        if (!this.contains(game)) {
            return false;
        }
        List<VideoGame> gameList = this.list();
        gameList.remove(game);
        this.deleteAll();

        for (VideoGame vg : gameList) {
            this.add(vg);
        }

        return true;
    }

    /**
     * Poistaa kaikki pelit tiedostosta
     *
     */
    public void deleteAll() {

        try {
            FileWriter fileMaker = new FileWriter(file);
            fileMaker.write("");
            fileMaker.close();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    /**
     * Palauttaa kaikki pelit listana
     *
     * @return Palauttaa kaikki pelit listana satunnaisessa järjestyksessä
     */
    @Override
    public List<VideoGame> list() {

        ArrayList<VideoGame> currentList = new ArrayList<>();
        Scanner reader;
        try {
            reader = new Scanner(file);
            while (reader.hasNextLine()) {
                String s = reader.nextLine();
                String[] parts = s.split(";");
                VideoGame game = new VideoGame(parts[0], parts[1], Integer.parseInt(parts[2]));
                if (Boolean.parseBoolean(parts[3])) {
                    game.setCompleted(true);
                }
                currentList.add(game);
            }
        } catch (FileNotFoundException ex) {
            Logger.getLogger(FileDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return currentList;
    }

    /**
     * Palauttaa kaikki pelit aakkosittain järjestettynä
     *
     * @return Palauttaa kaikki pelit aakkosjärjestyksessä nimen mukaan
     */
    @Override
    public List<VideoGame> alphabeticList() {
        List<VideoGame> gameList = this.list();
        AlphabeticGameComparator alpha = new AlphabeticGameComparator();
        gameList.sort(alpha);
        return gameList;
    }

    /**
     * Palauttaa kaikki pelit iän mukaan järjestettynä
     *
     * @return Palauttaa kaikki pelit ikäjärjestyksessä
     */
    @Override
    public List<VideoGame> yearList() {
        List<VideoGame> gameList = this.list();
        YearGameComparator alpha = new YearGameComparator();
        gameList.sort(alpha);
        return gameList;
    }

    /**
     * Palauttaa kaikki pelit konsoleittain järjestettynä
     *
     * @return Palauttaa kaikki pelit järjestettynä konsoleittain
     */
    @Override
    public List<VideoGame> consoleList() {
        List<VideoGame> gameList = this.list();
        ConsoleGameComparator alpha = new ConsoleGameComparator();
        gameList.sort(alpha);
        return gameList;
    }

    private HashMap<String, int[]> statistics() {
        List<VideoGame> gameList = this.list();
        HashMap<String, int[]> consoleMap = new HashMap<>();
        for (VideoGame vg : gameList) {
            if (!consoleMap.containsKey(vg.getConsole())) {
                int[] pair = new int[2];
                if (vg.isCompleted()) {
                    pair[0] = 1;
                }
                pair[1] = 1;
                consoleMap.put(vg.getConsole(), pair);
            } else {
                int[] pair = consoleMap.get(vg.getConsole());
                if (vg.isCompleted()) {
                    pair[0]++;
                }
                pair[1]++;
                consoleMap.put(vg.getConsole(), pair);
            }
        }
        return consoleMap;
    }

    /**
     * Palauttaa listan, jossa on käyttäjälle sievästi muotoiltuja tilastoja
     * konsoleista. Tilastot on muutettu merkkijonoiksi valmiina tulostusta
     * varten
     *
     * @return Palauttaa tilastot merkkijonoina
     */
    public List<String> statisticsAsText() {
        List<String> statisticsList = new ArrayList<>();
        for (String console : this.statistics().keySet()) {
            String stat = console + " yhteensä " + this.statistics().get(console)[1] + " läpivedetty " + this.statistics().get(console)[0];
            statisticsList.add(stat);
        }

        return statisticsList;
    }

}
