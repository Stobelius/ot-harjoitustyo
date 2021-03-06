/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package videopelitietokanta.ui;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;
import videopelitietokanta.dao.FileDao;
import java.util.Scanner;
import videopelitietokanta.domain.VideoGame;

/**
 * Teksitikäyttöliittymä, joka käyttää fileDao-luokkaa tietojen lukemiseen ja
 * tallentamiseen.
 *
 */
public class TextUI {

    private Scanner reader;
    private FileDao fileDao;

    /**
     * Antaa FileDaolle tiedoston nimen, johon pelit tallennetaan.
     *
     * @param fileName tiedoston nimi, johon pelit tallennetaan.
     */
    public TextUI(String fileName) {
        this.reader = new Scanner(System.in);
        this.fileDao = new FileDao(fileName);

    }

    /**
     * Käyttöliittymän käynnistys
     */
    public void start() {

        OUTER_1:
        while (true) {
            System.out.println("1 syötä peli, 2 tulosta pelejä, 3 poista peli, 4 pelaa peli läpi, 5 tilastoja, 6 poista kaikki, q lopeta");
            String input = reader.nextLine();
            switch (input) {
                case "1":
                    this.inputGame();
                    break;
                case "2":
                    this.printGames();
                    break;
                case "3":
                    this.removeGame();
                    break;
                case "4":
                    this.completeGame();
                    break;
                case "5":
                    this.printStatistics();
                    break;
                case "6":
                    this.removeAllGames();
                    break;
                case "q":
                    break OUTER_1;
                default:
                    break;
            }
        }
        System.out.println("heihei");

    }

    private void inputGame() {
        System.out.println("Anna nimi:");
        String name = reader.nextLine();
        if (name.contains(";")) {
            System.out.println("pelin nimi tai konsoli ei saa sisältää puolipistettä");
            return;
        }
        System.out.println("Anna konsoli");
        String gameConsole = reader.nextLine();
        if (gameConsole.contains(";")) {
            System.out.println("pelin nimi tai konsoli ei saa sisältää puolipistettä");
            return;
        }
        System.out.println("Anna julkaisuvuosi");
        boolean properIntRecieved = false;
        int year = -1;
        while (!properIntRecieved) {
            try {
                year = Integer.parseInt(reader.nextLine());
                properIntRecieved = true;
            } catch (Exception e) {
                System.out.println("Anna julkaisuvuosi numerona");
            }
        }
        VideoGame game = new VideoGame(name, gameConsole, year);
        boolean added = fileDao.add(game);
        if (!added) {
            System.out.println("peli on jo lisätty aiemmin");
        } else {
            System.out.println("peli syötetty");
        }
        System.out.println("");

    }

    private void printGames() {
        System.out.println("Minkä mukaan tulostus järjestetään");
        List<VideoGame> printingList;
        String orderChoice = "";
        OUTER:
        while (true) {
            System.out.println("1 aakkosittain, 2 konsoleittain, 3 vuoden mukaan");
            orderChoice = reader.nextLine();
            switch (orderChoice) {
                case "1":
                    printingList = fileDao.alphabeticList();
                    break OUTER;
                case "2":
                    printingList = fileDao.consoleList();
                    break OUTER;
                case "3":
                    printingList = fileDao.yearList();
                    break OUTER;
                default:
                    break;
            }
        }
        System.out.println("tulostetaan pelit muodossa");
        System.out.println("peli,   konsoli,   vuosi, pelattu läpi");
        System.out.println("");
        for (VideoGame vg : printingList) {
            System.out.println(vg.toString());
        }
        System.out.println("");

    }

    private void removeGame() {
        System.out.println("Minkä niminen peli poistetaan?");
        String name = reader.nextLine();
        boolean removed = fileDao.remove(name);
        if (removed) {
            System.out.println("poistettu");
        } else {
            System.out.println("ei ole tuon nimistä peliä alunperinkään");
        }
        System.out.println("");

    }

    private void removeAllGames() {
        System.out.println("Varmista, että haluat poistaa kaikki: Y");
        String confirmation = reader.nextLine();
        if (confirmation.equals("Y")) {
            System.out.println("poistetaan kaikki");
            fileDao.deleteAll();

        } else {
            System.out.println("keskeytetään poisto");
        }
        System.out.println("");
    }

    private void completeGame() {
        System.out.println("Minkä niminen peli on pelattu läpi?");
        String gameName = reader.nextLine();
        boolean completed = fileDao.complete(gameName);
        if (completed) {
            System.out.println("Peli merkitty läpipelatuksi");
        } else {
            System.out.println("ei ole tuon nimistä peliä");
        }
        System.out.println("");

    }

    private List<String> statisticsAsText() {

        List<String> statisticsList = new ArrayList<>();
        for (String console : fileDao.statistics().keySet()) {
            int amount = fileDao.statistics().get(console)[1];
            int completedAmount = fileDao.statistics().get(console)[0];
            double precent = completedAmount * 1.0 / amount;
            DecimalFormat df = new DecimalFormat("##%");

            String stat = console + " yhteensä " + amount + " läpivedetty "
                    + completedAmount + " läpivetoprosentti " + df.format(precent);
            statisticsList.add(stat);
        }

        return statisticsList;

    }

    private void printStatistics() {
        for (String s : this.statisticsAsText()) {
            System.out.println(s);
        }
        System.out.println("");
    }

}
