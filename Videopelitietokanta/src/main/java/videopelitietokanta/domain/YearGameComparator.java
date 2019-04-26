package videopelitietokanta.domain;

import java.util.Comparator;

/**
 * Comparator luokka videopelien järjestämiseen iän perusteella.
 */
public class YearGameComparator implements Comparator<VideoGame> {

    @Override
    public int compare(VideoGame game1, VideoGame game2) {
        return game1.getPublicationYear() - game2.getPublicationYear();

    }
}
