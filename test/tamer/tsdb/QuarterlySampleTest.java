package tamer.tsdb;

import org.junit.Test;
import static org.junit.Assert.*;

/**
 * unit test for QuarterlySample class
 *
 * @author Tamer Kulaksizoglu
 */
public class QuarterlySampleTest {

    @Test
    public void test_getFrequency_01() throws Exception {
        QuarterlySample sample = new QuarterlySample(2001, 1, 2002, 4);
        Frequency actual = sample.getFrequency();
        Frequency expected = Frequency.QUARTERLY;
        assertEquals(expected, actual);
    }
}
