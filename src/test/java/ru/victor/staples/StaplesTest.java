package ru.victor.staples;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;

@RunWith(Parameterized.class)
public class StaplesTest {

    private final String staple;
    private final String check;
    private final Staples staples = new Staples();

    public StaplesTest(String staples, String check) {
        this.staple = staples;
        this.check = check;
    }

    @Parameterized.Parameters
    public static Iterable<Object[]> data() {
        return Arrays.asList(new Object[][] {
                {"(()", "2 - ()"},
                {")()())", "4 - ()()"},
                {")(()())", "6 - (()())"},
                {")(", "0"},
                {"())(()())(()", "10 - ()(()())()"},
        });
    }

    @Test
    public void testCheckStaples() {
        Assert.assertEquals(check, staples.checkStaples(staple));
    }
}