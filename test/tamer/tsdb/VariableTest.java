package tamer.tsdb;

import org.junit.Assert;
import org.junit.Test;

/**
 * unit tests for Variable class
 *
 * @author Tamer Kulaksizoglu
 */
public class VariableTest {

    @Test
    public void test_isLessThan_01() {
        Variable var = new Variable();
        double[] data = new double[]{2.0, -2.0};
        var.setData(data);
        int[] expected = new int[]{0, 1};
        int[] actual = var.isLessThan(1.0);
        Assert.assertArrayEquals(expected, actual);
    }

    @Test
    public void test_isLessThan_02() {
        Variable var = new Variable();
        double[] data = new double[]{2.0, -2.0, 3.0, -3.0};
        var.setData(data);
        int[] expected = new int[]{0, 1, 0, 1};
        int[] actual = var.isLessThan(1.0);
        Assert.assertArrayEquals(expected, actual);
    }
}
