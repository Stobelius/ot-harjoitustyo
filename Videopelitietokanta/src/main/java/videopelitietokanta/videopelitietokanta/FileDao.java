/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package videopelitietokanta.videopelitietokanta;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import javax.swing.Box;

/**
 *
 * @author tkelomak
 */
public class FileDao implements Dao {

    private File file;
    private Scanner reader;
    private FileWriter writer;

    public FileDao() {

        this.file = new File("games.txt");
        try {
            reader = new Scanner(file);
            writer = new FileWriter(file, true);

        } catch (Exception e) {
            try {
                FileWriter fileMaker = new FileWriter(new File("games.txt"));
                fileMaker.close();

                reader = new Scanner(file);
                writer = new FileWriter(file, true);

            } catch (Exception ee) {
                System.out.println("failing to create games.txt");
            }
        }

    }

    @Override
    public void add(VideoGame game) {
        try {

            writer.write(game.asFileString() + "\r\n");
            writer.flush();

        } catch (Exception e) {
            System.out.println("not managing to write to file " + e.getMessage());
        }

    }

    public void deleteAll() {
        file.delete();
    }

    public void close() {
        try {
            writer.close();
        } catch (Exception e) {
            System.out.println("didnt manage to close the filewriter connection");
        }
    }

    @Override
    public List<VideoGame> list() {
        ArrayList<VideoGame> currentList = new ArrayList<>();
        while (reader.hasNextLine()) {
            String s = reader.nextLine();
            String[] parts = s.split(";");
            VideoGame game = new VideoGame(parts[0], parts[1], Integer.parseInt(parts[2]));
            currentList.add(game);
        }

        return currentList;
    }

}
