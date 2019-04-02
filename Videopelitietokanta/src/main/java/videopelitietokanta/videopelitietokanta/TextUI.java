/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package videopelitietokanta.videopelitietokanta;

import java.util.Scanner;

/**
 *
 * @author tkelomak
 */
public class TextUI {

    public TextUI() {

    }

    public void start() {
        Scanner reader = new Scanner(System.in);
        FileDao fileDao = new FileDao("games.txt");

        while (true) {
            System.out.println("1 syötä peli, 2 tulosta pelejä, 3 poista kaikki, q lopeta");

            String input = reader.nextLine();

            if (input.equals("1")) {
                System.out.println("nyt syötetään peli");
                System.out.println("Anna nimi:");
                String name=reader.next();
                System.out.println("Anna konsoli");
                String gameConsole=reader.next();
                System.out.println("Anna julkaisuvuosi");
                int year=Integer.parseInt(reader.next());
                //add not allowing bad inputs here
                
                
                VideoGame game=new VideoGame(name,gameConsole,year);
                
                fileDao.create(game);
                //add here saving the game
                
                
                
                
            } else if (input.equals("2")) {
                System.out.println("nyt tulostetaan pelejä");
                
            } else if (input.equals("3")){
                System.out.println("poistetaan kaikki");
                fileDao.deleteAll();
            } else if (input.equals("q")) {
                break;
            }

        }
        System.out.println("heihei");

    }

}
