/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.File;
import java.io.FileWriter;
import java.util.Scanner;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import videopelitietokanta.dao.FileDao;
import videopelitietokanta.domain.AlphabeticGameComparator;
import videopelitietokanta.domain.ConsoleGameComparator;
import videopelitietokanta.domain.VideoGame;
import videopelitietokanta.domain.YearGameComparator;
import videopelitietokanta.ui.TextUI;

/**
 *
 * @author tkelomak
 */
public class VideoGamesTest {

    FileDao testFileDao;
    VideoGame testGame;
    VideoGame otherTestGame;
    String testFileName;
    File testFile;
    TextUI testTextUI;

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
        testFileName = "testfile";
        testFile = new File(testFileName);
        testFileDao = new FileDao(testFileName);
        testGame = new VideoGame("testgame", "testconsole", -1);
        otherTestGame = new VideoGame("testgame2", "testconsole", -1);
        testTextUI = new TextUI(testFileName);

    }

    @After
    public void tearDown() {
        testFileDao.deleteAll();
    }

    @Test
    public void saveOneGameAndReadIt() {

        testFileDao.add(testGame);

        String written = "";

        try (Scanner reader = new Scanner(testFile)) {
            while (reader.hasNextLine()) {
                written = reader.nextLine();
                if (written.equals(testGame.asFileString())) {
                    break;
                }
            }
        } catch (Exception e) {
            System.out.println("Not managing to read file in test" + e.getMessage());
        }

        assertEquals(testGame.asFileString(), written);

    }

    @Test
    public void notAbleToAddDuplicateGames() {
        testFileDao.add(testGame);

        boolean duplicate = testFileDao.add(testGame);
        assertEquals(duplicate, false);

    }

    @Test
    public void removeGame() {
        testFileDao.add(testGame);
        testFileDao.remove(testGame.getName());

        assertEquals(testFileDao.contains(testGame), false);

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
    public void alphabeticListOrdered() {
        VideoGame game1 = new VideoGame("aa", "", -1);
        VideoGame game2 = new VideoGame("bb", "", -1);
        testFileDao.add(game1);
        testFileDao.add(game2);
        assertEquals(game1, testFileDao.alphabeticList().get(0));
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
    public void yearListOrdered() {
        VideoGame game1 = new VideoGame("aa", "", 2);
        VideoGame game2 = new VideoGame("bb", "", 1);

        testFileDao.add(game1);
        testFileDao.add(game2);
        assertEquals(game2, testFileDao.yearList().get(0));
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
    public void ConsoleListOrdered() {
        VideoGame game1 = new VideoGame("aa", "cc", 2);
        VideoGame game2 = new VideoGame("bb", "dd", 1);
        testFileDao.add(game1);
        testFileDao.add(game2);
        assertEquals(game1, testFileDao.consoleList().get(0));
    }

    @Test
    public void statisticsContainOneConsole() {
        testFileDao.add(testGame);
        boolean contains = testFileDao.statistics().keySet().contains(testGame.getConsole());
        assertEquals(contains, true);
    }

    @Test
    public void statisticsTwoGamesOneConsole() {
        testFileDao.add(testGame);
        testFileDao.complete(testGame.getName());
        testFileDao.add(otherTestGame);
        int[] pair = {1, 2};
        Assert.assertArrayEquals(pair, testFileDao.statistics().get(testGame.getConsole()));
    }

    @Test
    public void videoGameToString() {
        assertEquals(testGame.toString(), testGame.getName() + ",  " + testGame.getConsole() + ",  " + testGame.getPublicationYear() + ",  ei pelattu läpi");

    }

    @Test
    public void completeExistingGame() {
        testFileDao.add(testGame);
        assertEquals(true, testFileDao.complete(testGame.getName()));
    }

    @Test
    public void completeNotExistingGame() {
        assertEquals(false, testFileDao.complete("not a game"));
    }

    @Test
    public void completeChangesComplition() {
        testFileDao.add(testGame);
        testFileDao.complete(testGame.getName());
        testGame = testFileDao.list().get(0);
        assertEquals(true, testGame.isCompleted());
    }

    @Test
    public void removingNotExistingGame() {
        assertEquals(false, testFileDao.remove("not a game"));
    }

}
