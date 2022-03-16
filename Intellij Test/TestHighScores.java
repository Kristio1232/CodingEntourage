import static org.junit.Assert.*;
import org.junit.Test;

import java.util.ArrayList;

public class TestHighScores {
    @Test
    public void test_Score_1()
    {
        Score a = new Score();
        a.add("Andrew", 123);
        String[] b = a.getScores();
        String[] expected = {"Andrew", "123"};
        assertArrayEquals(expected, b);
    }

    @Test
    public void test_Score_2()
    {
        Score a = new Score();
        a.add("Marina", 2);
        String[] b = a.getScores();
        String[] expected = {"Marina", "2"};
        assertArrayEquals(expected, b);
    }

    @Test
    public void test_Score_3()
    {
        Score a = new Score();
        a.add("Kristio", 2544);
        String[] b = a.getScores();
        String[] expected = {"Kristio", "2544"};
        assertArrayEquals(expected, b);
    }

    @Test
    public void test_Score_4()
    {
        Score a = new Score();
        a.add("struggle city", 1091);
        String[] b = a.getScores();
        String[] expected = {"struggle city", "1091"};
        assertArrayEquals(expected, b);
    }

    @Test
    public void test_Score_5()
    {
        Score a = new Score();
        a.add("Makus31", 1130);
        String[] b = a.getScores();
        String[] expected = {"Makus31", "1130"};
        assertArrayEquals(expected, b);
    }

    @Test
    public void test_HighScores_1()
    {
        Score e = new Score();
        e.add("marina",400);
        Score f = new Score();
        f.add("marina",300);
        Score d = new Score();
        d.add("michael", 99);
        HighScores c = new HighScores();

        c.addScores(d);
        c.addScores(e);
        c.addScores(f);
        String p = c.getHighScores().get(0).getScores()[0];
        String expected = "marina";
        String o = c.getHighScores().get(0).getScores()[1];
        String expected_1 = "400";

        String q = c.getHighScores().get(1).getScores()[0];
        String expected_3 = "michael";
        String u = c.getHighScores().get(1).getScores()[1];
        String expected_4 = "99";


        assertEquals(expected, p);
        assertEquals(expected_1, o);
        assertEquals(expected_3, q);
        assertEquals(expected_4, u);


    }




}
