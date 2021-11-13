import org.junit.Assert;
import org.junit.Test;

import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;

public class TestBoggle {
    @Test
    public void test1() {

        String dict = "rain\ntail\nsilk\nsatin\nnail\nyeti";
        String grid = "rwkb\ntasl\nytik\neaan";
        String result = "nail\t4\t1\tLUE\nrain\t1\t4\tSSS\nsatin\t3\t3\tLDRS\nsilk\t3\t3\tDED\ntail\t1\t3\tRSE\nyeti\t1\t2\tDER";

        // Creating an object of BufferedReader class to
        // take input
        BufferedReader dictBr = new BufferedReader(new InputStreamReader(new ByteArrayInputStream(dict.getBytes(StandardCharsets.UTF_8))));
        BufferedReader gridBr = new BufferedReader(new InputStreamReader(new ByteArrayInputStream(grid.getBytes(StandardCharsets.UTF_8))));

        Boggle b = new Boggle();
        Assert.assertTrue(b.getDictionary(dictBr));
        Assert.assertTrue(b.getPuzzle(gridBr));
        Assert.assertEquals("Result String Size: ", 6, b.solve().size());
        Assert.assertEquals("Print String", result, b.print());
    }

    @Test(expected = RuntimeException.class)
    public void test2() {

        String dict = "rain\nt\nsilk\nsatin\nnail\nyeti";
        BufferedReader dictBr = new BufferedReader(new InputStreamReader(new ByteArrayInputStream(dict.getBytes(StandardCharsets.UTF_8))));

        Boggle b = new Boggle();
        b.getDictionary(dictBr);
    }

    @Test(expected = RuntimeException.class)
    public void test3() {

        String grid = "rwkb\ntsl\nytik\neaan";
        BufferedReader gridBr = new BufferedReader(new InputStreamReader(new ByteArrayInputStream(grid.getBytes(StandardCharsets.UTF_8))));

        Boggle b = new Boggle();
        b.getPuzzle(gridBr);
    }

    @Test(expected = RuntimeException.class)
    public void test4() {
        Boggle b = new Boggle();
        b.solve();
    }

    @Test(expected = RuntimeException.class)
    public void test5() {
        Boggle b = new Boggle();
        b.print();
    }

}
