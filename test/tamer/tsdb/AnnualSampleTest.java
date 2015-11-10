package tamer.tsdb;

import static org.junit.Assert.assertEquals;
import org.junit.Test;
import org.joda.time.DateTime;

/**
 * unit test for AnnualSample class
 *
 * @author Tamer Kulaksizoglu
 */
public class AnnualSampleTest {

    @Test
    public void test_getDate_01() throws Exception {
        AnnualSample sample = new AnnualSample(2001, 2010);
        DateTime dateTime1 = sample.getDate(1);
        DateTime dateTime2 = new DateTime(2002, 1, 1, 0, 0);
        int actual = dateTime1.getYear();
        int expected = dateTime2.getYear();
        assertEquals(expected, actual);
    }

    @Test
    public void test_getFrequency_01() throws Exception {
        AnnualSample sample = new AnnualSample(2001, 2010);
        Frequency actual = sample.getFrequency();
        Frequency expected = Frequency.ANNUAL;
        assertEquals(expected, actual);
    }

    @Test
    public void test_getSize_01() throws Exception {
        AnnualSample sample = new AnnualSample(2001, 2001);
        int actual = sample.getSize();
        int expected = 1;
        assertEquals(expected, actual);
    }

    @Test
    public void test_getSize_02() throws Exception {
        AnnualSample sample = new AnnualSample(2001, 2010);
        int actual = sample.getSize();
        int expected = 10;
        assertEquals(expected, actual);
    }
}
