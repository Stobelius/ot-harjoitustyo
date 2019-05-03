package videopelitietokanta.dao;

import java.util.HashMap;
import java.util.List;
import videopelitietokanta.domain.VideoGame;

/**
 *
 * Rajapinta tiedoston lukemiseen, jonka FileDao toteuttaa
 */
public interface Dao {

    boolean add(VideoGame game);

    boolean remove(String name);

    boolean complete(String name);

    boolean contains(VideoGame game);

    List<VideoGame> alphabeticList();

    List<VideoGame> yearList();

    List<VideoGame> consoleList();

    List<VideoGame> list();

    public HashMap<String, int[]> statistics();

    void deleteAll();

//    
}
