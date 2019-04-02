/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package videopelitietokanta.videopelitietokanta;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.List;

/**
 *
 * @author tkelomak
 */
public class FileDao implements Dao {

    private String file;

    public FileDao(String file) {
        this.file = file;
    }

    @Override
    public void create(VideoGame game) {
        try (FileWriter writer = new FileWriter(new File(file))) {
            writer.write(game.asFileString());

        } catch (Exception e) {
            System.out.println("not managing to write to file");
        }

    }

    public void deleteAll() {
        File tiedosto = new File(file);
        tiedosto.delete();
    }

    @Override
    public List<VideoGame> list() {

        


        return null;
    }

}
