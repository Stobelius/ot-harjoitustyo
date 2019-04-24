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
public class YearGameComparator implements Comparator<VideoGame> {

    @Override
    public int compare(VideoGame game1, VideoGame game2) {
        return game1.getPublicationYear()-game2.getPublicationYear();

    }
}
