package tamer.tsdb;

import org.junit.Test;

public class ModelbaseTest {

    @Test
    public void test() {
        Modelbase mb = new Modelbase(2001, 2005);
        mb.addVariable(new double[] {1.2, 1.4, 2.1, 0.8, 1.1}, "inf");
        mb.addVariable(new double[] {122, 114, 210, 118, 111}, "m1");
        mb.select("x", "inf", 1, 2);
        mb.select("x", "m1", 1, 2);
        mb.getGroup("x");
    }
}
