package tamer.tsdb;

import org.joda.time.DateTime;

public class MonthlySample extends AbstractSample {

    public MonthlySample(int year1, int month1, int year2, int month2) {
        super();
        date1 = new DateTime(year1, month1, 1, 0, 0);
        date2 = new DateTime(year2, month2, 1, 0, 0);
    }

    @Override
    public DateTime getDate(int index) {
        return date1.plusMonths(index);
    }

    @Override
    public Frequency getFrequency() {
        return Frequency.MONTHLY;
    }

    @Override
    public int getIndex(int year) {
        return this.getIndex(year, 1);
    }

    @Override
    public int getIndex(int year, int period) {
        return (year - date1.getYear()) * 12 + period - date1.getMonthOfYear();
    }

    @Override
    public int getSize() {
        return (date2.getYear() - date1.getYear()) * 12 + date2.getMonthOfYear() - date1.getMonthOfYear() + 1;
    }
}
