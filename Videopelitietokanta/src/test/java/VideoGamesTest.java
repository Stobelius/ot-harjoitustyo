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
import videopelitietokanta.dao.FileDao;
import videopelitietokanta.domain.AlphabeticGameComparator;
import videopelitietokanta.domain.ConsoleGameComparator;
import videopelitietokanta.domain.VideoGame;
import videopelitietokanta.domain.YearGameComparator;

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
    public void saveOneGameAndReadIt() {
        VideoGame mario = new VideoGame("testgame1", "testconsole", -1);
        FileDao fileDao = new FileDao();
        fileDao.add(mario);

        String written = "";

        try (Scanner reader = new Scanner(new File("games.txt"))) {
            while (reader.hasNextLine()) {
                written = reader.nextLine();
                if (written.equals(mario.asFileString())) {
                    break;
                }

            }

        } catch (Exception e) {
            System.out.println("Not managing to read file in test" + e.getMessage());
        }
        fileDao.remove(mario.getName());

        assertEquals(mario.asFileString(), written);

    }

    @Test
    public void notAbleToAddDuplicateGames() {
        VideoGame mario = new VideoGame("testgame2", "testconsole", -1);
        FileDao fileDao = new FileDao();
        fileDao.add(mario);

        boolean duplicate = fileDao.add(mario);
        assertEquals(duplicate, false);

        fileDao.remove(mario.getName());

    }

    @Test
    public void removeGame() {
        VideoGame mario = new VideoGame("testgame3", "testconsole", -1);
        FileDao fileDao = new FileDao();
        fileDao.add(mario);
        fileDao.remove(mario.getName());

        assertEquals(fileDao.contains(mario), false);

    }

    @Test
    public void alphabeticCompare() {
        VideoGame game1 = new VideoGame("aa", "", -1);
        VideoGame game2 = new VideoGame("bb", "", -1);

        AlphabeticGameComparator alpha = new AlphabeticGameComparator();
        boolean comparison = (alpha.compare(game1, game2) < 0);
        assertEquals(comparison, true);

    }

    @Test
    public void yearCompare() {
        VideoGame game1 = new VideoGame("aa", "", 2);
        VideoGame game2 = new VideoGame("bb", "", 1);

        YearGameComparator year = new YearGameComparator();
        boolean comparison = (year.compare(game1, game2) > 0);
        assertEquals(comparison, true);

    }

    @Test
    public void ConsoleCompare() {
        VideoGame game1 = new VideoGame("aa", "cc", 2);
        VideoGame game2 = new VideoGame("bb", "dd", 1);

        ConsoleGameComparator console = new ConsoleGameComparator();
        boolean comparison = (console.compare(game1, game2) < 0);
        assertEquals(comparison, true);

    }

    @Test
    public void statistcsAsTextContainsAddedConsole() {
        VideoGame mario = new VideoGame("testgame4", "testconsole4", -1);
        FileDao fileDao = new FileDao();
        fileDao.add(mario);
        boolean contains = fileDao.statisticsAsText().contains("testconsole4" + " yhteensä " + 1 + " läpivedetty " + 0);
        fileDao.remove(mario.getName());

        assertEquals(contains, true);

    }

    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    // @Test
    // public void hello() {}
}
