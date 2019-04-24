package videopelitietokanta.dao;

import java.util.List;
import videopelitietokanta.domain.VideoGame;


/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author stobe
 */

public interface Dao {

    boolean add(VideoGame game);
    boolean remove(String name);

    List<VideoGame> list();

//    
}
