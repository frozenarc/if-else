package org.frozenarc.ifelse;

import org.frozenarc.ifelse.If;
import org.frozenarc.ifelse.Work;
import org.junit.Assert;
import org.junit.Test;

import java.util.Objects;

/**
 * Unit test for simple App.
 */
public class IfElseTest {
    /**
     * Rigorous Test :-)
     */
    @Test
    public void test() {

        Work<String, String> work = If.<String, String>of(Objects::isNull)
                .thn(s -> "Hello Naisu")
                .els(If.<String, String>of(s -> s.length() == 0)
                        .thn(s -> "Hello Priya")
                        .els(If.<String, String>of(s -> s.contains("H"))
                                .thn(If.<String, String>of(s -> s.equals("Hello"))
                                        .thn(s -> s + " Manan")
                                        .els(If.<String, String>of(s -> s.equals("Hi"))
                                                .thn(s -> s + " Bhumi")
                                                .els(s -> "Halo...")))
                                .els(s -> "Holla...")));

        Assert.assertTrue(work.doFor(null).equals("Hello Naisu"));
        Assert.assertTrue(work.doFor("").equals("Hello Priya"));
        Assert.assertTrue(work.doFor("Hello").equals("Hello Manan"));
        Assert.assertTrue(work.doFor("Hi").equals("Hi Bhumi"));
        Assert.assertTrue(work.doFor("Halo").equals("Halo..."));
        Assert.assertTrue(work.doFor("lla").equals("Holla..."));


        Work<String, Integer> work2 = If.<String, Integer>of(Objects::isNull)
                .thn(s -> -1)
                .els(If.<String, Integer>of(s -> s.length() == 0)
                        .thn(s -> 0)
                        .els(If.<String, Integer>of(s -> s.contains("H"))
                                .thn(If.<String, Integer>of(s -> s.equals("Hello"))
                                        .thn(s -> 1)
                                        .els(If.<String, Integer>of(s -> s.equals("Hi"))
                                                .thn(s -> 2)
                                                .els(s -> 3)))
                                .els(s -> 4)));

        Assert.assertTrue(work2.doFor(null).equals(-1));
        Assert.assertTrue(work2.doFor("").equals(0));
        Assert.assertTrue(work2.doFor("Hello").equals(1));
        Assert.assertTrue(work2.doFor("Hi").equals(2));
        Assert.assertTrue(work2.doFor("Halo").equals(3));
        Assert.assertTrue(work2.doFor("lla").equals(4));

    }

}
