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
 *
 * @author tkelomak
 */
public class TextUI {

    public TextUI() {

    }

    public void start() {
        Scanner reader = new Scanner(System.in);
        FileDao fileDao = new FileDao();

        OUTER_1:
        while (true) {
            System.out.println("1 syötä peli, 2 tulosta pelejä, 3 poista peli, 4 pelaa peli läpi, 5 poista kaikki, q lopeta");
            String input = reader.nextLine();
            switch (input) {
                case "1": {
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
                    break;
                }
                case "2":
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
                    System.out.println("peli,   konsoli,   vuosi");
                    for (VideoGame vg : printingList) {
                        System.out.println(vg.toString());
                    }
                    System.out.println("");
                    break;
                case "3": {
                    System.out.println("Anna nimi:");
                    String name = reader.nextLine();
                    boolean removed = fileDao.remove(name);
                    if (removed) {
                        System.out.println("poistettu");
                    } else {
                        System.out.println("ei ole tuon nimistä peliä alunperinkään");
                    }
                    break;
                }
                case "4":
                    System.out.println("Mikä peli on pelattu läpi");
                    String completed = reader.nextLine();
                    fileDao.complete(completed);
                    break;
                case "5":
                    System.out.println("Varmista, että haluat poistaa kaikki Y");
                    String confirmation = reader.nextLine();
                    if (confirmation.equals("Y")) {
                        System.out.println("poistetaan kaikki");
                        fileDao.deleteAll();
                        break;
                    }
                    System.out.println("keskeutetään poisto");
                    break;
                case "q":
                    break OUTER_1;
                default:
                    break;
            }
        }
        System.out.println("heihei");

    }

}
