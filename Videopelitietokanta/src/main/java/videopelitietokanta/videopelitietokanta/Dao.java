package videopelitietokanta.videopelitietokanta;


import java.util.List;

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
    void create(VideoGame game);
    List<VideoGame> list();

    
    
    
}
