package tamer.tsdb;

import org.joda.time.DateTime;

public class AnnualSample extends AbstractSample {

    /**
     * constructs an AnnualSample object
     *
     * @param year1 beginning year
     * @param year2 ending year
     */
    public AnnualSample(int year1, int year2) {
        super();
        date1 = new DateTime(year1, 1, 1, 0, 0);
        date2 = new DateTime(year2, 1, 1, 0, 0);
    }

    /**
     * gets date corresponding to an observation index
     *
     * @param index observation index
     * @return date
     */
    @Override
    public DateTime getDate(int index) {
        return date1.plusYears(index);
    }

    /**
     * gets frequency
     *
     * @return Annual
     */
    @Override
    public Frequency getFrequency() {
        return Frequency.ANNUAL;
    }

    /**
     * gets observation index corresponding to a year
     *
     * @param year year
     * @return observation index
     */
    @Override
    public int getIndex(int year) {
        return this.getIndex(year, 1);
    }

    /**
     * gets observation index corresponding to a year and a period
     *
     * @param year year
     * @param period period
     * @return index corresponding to year and period
     */
    @Override
    public int getIndex(int year, int period) {
        return year - date1.getYear();
    }

    /**
     * gets sample size
     *
     * @return sample size
     */
    @Override
    public int getSize() {
        return date2.getYear() - date1.getYear() + 1;
    }
}
