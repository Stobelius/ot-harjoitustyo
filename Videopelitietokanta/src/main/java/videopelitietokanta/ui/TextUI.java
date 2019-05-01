/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package videopelitietokanta.ui;

import java.util.List;
import videopelitietokanta.dao.FileDao;
import java.util.Scanner;
import videopelitietokanta.domain.VideoGame;

/**
 * Teksitikäyttöliittymä, joka käyttää fileDao-luokkaa tietojen lukemiseen ja
 * tallentamiseen
 */
public class TextUI {

    private Scanner reader;
    private FileDao fileDao;

    public TextUI() {
        this.reader = new Scanner(System.in);
        this.fileDao = new FileDao("games.txt");

    }

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
        System.out.println("nyt syötetään peli");
        System.out.println("Anna nimi:");
        String name = reader.nextLine();
        System.out.println("Anna konsoli");
        String gameConsole = reader.nextLine();
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
            System.out.println("peli on jo lisätty");
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
        System.out.println("Anna nimi:");
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
        System.out.println("Mikä peli on pelattu läpi");
        String gameName = reader.nextLine();
        boolean completed = fileDao.complete(gameName);
        if (completed) {
            System.out.println("Peli merkitty läpipelatuksi");
        } else {
            System.out.println("ei ole tuon nimistä peliä");
        }
        System.out.println("");

    }

    private void printStatistics() {
        System.out.println("tulostetaan tilastoja");
        for (String s : fileDao.statisticsAsText()) {
            System.out.println(s);
        }
        System.out.println("");

    }

}
