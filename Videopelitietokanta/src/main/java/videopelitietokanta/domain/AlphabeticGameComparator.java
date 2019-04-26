package videopelitietokanta.domain;

import java.util.Comparator;

/**
 * Comparator luokka videopelien järjestämiseen aakkosjärjestykseen.
 */
public class AlphabeticGameComparator implements Comparator<VideoGame> {

    @Override
    public int compare(VideoGame game1, VideoGame game2) {
        return game1.getName().compareTo(game2.getName());

    }
}
