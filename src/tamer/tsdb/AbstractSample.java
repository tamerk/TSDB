package tamer.tsdb;

import org.joda.time.DateTime;

/**
 * abstract class for sample creation
 *
 * @author Tamer Kulaksizoglu
 */
public abstract class AbstractSample {

    protected DateTime date1;
    protected DateTime date2;
    protected String name;

    /**
     * constructor for AbstractSample class
     */
    public AbstractSample() {
        date1 = null;
        date2 = null;
        name = "";
    }

    public abstract DateTime getDate(int index);
    public abstract Frequency getFrequency();
    public abstract int getIndex(int year);
    public abstract int getIndex(int year, int period);
    public abstract int getSize();
}
