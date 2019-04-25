/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package videopelitietokanta.domain;

import java.util.Comparator;
import videopelitietokanta.domain.VideoGame;

/**
 *
 * @author stobe
 */
public class AlphabeticGameComparator implements Comparator<VideoGame> {

    @Override
    public int compare(VideoGame game1, VideoGame game2) {
        return game1.getName().compareTo(game2.getName());

    }
}
