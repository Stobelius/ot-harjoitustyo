/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package videopelitietokanta.dao;

/**
 *
 * @author stobe
 */
import java.util.Comparator;
import videopelitietokanta.domain.VideoGame;

/**
 *
 * @author stobe
 */
public class ConsoleGameComparator implements Comparator<VideoGame> {

    @Override
    public int compare(VideoGame game1, VideoGame game2) {
        if(!game1.getConsole().equals(game2.getConsole())){
            return game1.getConsole().compareTo(game2.getConsole());
        }
        
        return game1.getName().compareTo(game2.getName());

    }
}
