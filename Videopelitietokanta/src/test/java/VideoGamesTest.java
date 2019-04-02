/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.File;
import java.util.Scanner;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import videopelitietokanta.videopelitietokanta.FileDao;
import videopelitietokanta.videopelitietokanta.VideoGame;

/**
 *
 * @author tkelomak
 */
public class VideoGamesTest {

    public VideoGamesTest() {
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
    }

    @After
    public void tearDown() {
    }

    @Test
    public void saveOneGame() {
        VideoGame mario = new VideoGame("mario", "nes", 1985);
        String testFile = "testfile.txt";
        FileDao fileDao = new FileDao(testFile);
        fileDao.create(mario);
        
        String written="";

        try (Scanner reader = new Scanner(new File(testFile))) {
            written=reader.nextLine();


        } catch (Exception e) {
            System.out.println("Not managing to read file in test" + e.getMessage());
        }
        
        assertEquals(written, mario.asFileString());

    }

    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    // @Test
    // public void hello() {}
}
