package videopelitietokanta.dao;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
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
 *
 * @author tkelomak
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

    public boolean complete(String name) {
        VideoGame testGame = new VideoGame(name, "", 0);
        if (!this.contains(testGame)) {
            return false;
        }

        VideoGame game = this.getGameByName(name);

        game.setCompleted(true);
        System.out.println(game.toString());

        this.remove(name);
        this.add(game);
        System.out.println("halp");
        return true;
    }

    private boolean contains(VideoGame game) {

        if (this.list().contains(game)) {
            return true;
        }

        return false;
    }

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

    public void deleteAll() {

        try {
            FileWriter fileMaker = new FileWriter(file);
            fileMaker.write("");
            fileMaker.close();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
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

    public List<VideoGame> alphabeticList() {
        List<VideoGame> gameList = this.list();
        AlphabeticGameComparator alpha = new AlphabeticGameComparator();
        gameList.sort(alpha);
        return gameList;
    }

    public List<VideoGame> yearList() {
        List<VideoGame> gameList = this.list();
        YearGameComparator alpha = new YearGameComparator();
        gameList.sort(alpha);
        return gameList;
    }

    public List<VideoGame> consoleList() {
        List<VideoGame> gameList = this.list();
        ConsoleGameComparator alpha = new ConsoleGameComparator();
        gameList.sort(alpha);
        return gameList;
    }

    public List<String> statistics() {
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
        return null;
    }

}
