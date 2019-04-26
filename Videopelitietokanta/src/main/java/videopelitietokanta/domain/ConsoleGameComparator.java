package videopelitietokanta.domain;

import java.util.Comparator;

/**
 * Comparator luokka videopelien järjestämiseen konsoleittain.
 */
public class ConsoleGameComparator implements Comparator<VideoGame> {

    @Override
    public int compare(VideoGame game1, VideoGame game2) {
        if (!game1.getConsole().equals(game2.getConsole())) {
            return game1.getConsole().compareTo(game2.getConsole());
        }

        return game1.getName().compareTo(game2.getName());

    }
}
