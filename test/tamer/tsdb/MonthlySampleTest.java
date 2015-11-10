package tamer.tsdb;

import static org.junit.Assert.assertEquals;
import org.junit.Test;

public class MonthlySampleTest {

    @Test
    public void test_getFrequency_01() throws Exception {
        MonthlySample sample = new MonthlySample(2001, 1, 2002, 12);
        Frequency actual = sample.getFrequency();
        Frequency expected = Frequency.MONTHLY;
        assertEquals(expected, actual);
    }

    @Test
    public void test_getSize_01() throws Exception {
        MonthlySample sample = new MonthlySample(2001, 1, 2002, 12);
        int actual = sample.getSize();
        int expected = 24;
        assertEquals(expected, actual);
    }

    @Test
    public void test_getSize_02() throws Exception {
        MonthlySample sample = new MonthlySample(2001, 1, 2001, 12);
        int actual = sample.getSize();
        int expected = 12;
        assertEquals(expected, actual);
    }

    @Test
    public void test_getSize_03() throws Exception {
        MonthlySample sample = new MonthlySample(2001, 1, 2001, 1);
        int actual = sample.getSize();
        int expected = 1;
        assertEquals(expected, actual);
    }
}
