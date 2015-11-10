package tamer.tsdb;

import org.joda.time.DateTime;

/**
 * class for quarterly sample
 *
 * @author Tamer Kulaksizoglu
 */
public class QuarterlySample extends AbstractSample {

    public QuarterlySample(int year1, int quarter1, int year2, int quarter2) {
        super();
        int month1 = QuarterlySample.quarterToMonth(quarter1);
        date1 = new DateTime(year1, month1, 1, 0, 0);
        int month2 = QuarterlySample.quarterToMonth(quarter2);
        date2 = new DateTime(year2, month2, 1, 0, 0);
    }

    @Override
    public DateTime getDate(int index) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    /**
     * gets frequency
     *
     * @return QUARTERLY
     */
    @Override
    public Frequency getFrequency() {
        return Frequency.QUARTERLY;
    }

    @Override
    public int getIndex(int year) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int getIndex(int year, int period) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int getSize() {
        int quarter1 = QuarterlySample.monthToQuarter(date1.getMonthOfYear());
        int quarter2 = QuarterlySample.monthToQuarter(date2.getMonthOfYear());
        return (date2.getYear() - date1.getYear()) * 4 + quarter2 - quarter1 + 1;
    }

    private static int monthToQuarter(int month) {
        int quarter;
        if (month >= 1 && month <= 3) {
            quarter = 1;
        } else if (month >= 4 && month <= 6) {
            quarter = 2;
        } else if (month >= 7 && month <= 9) {
            quarter = 3;
        } else if (month >= 10 && month <= 12) {
            quarter = 4;
        } else {
            throw new IllegalArgumentException("Argument must be between 1 and 12.");
        }
        return quarter;
    }

    private static int quarterToMonth(int quarter) {
        int month;
        switch (quarter) {
            case 1:
                month = 1;
                break;
            case 2:
                month = 4;
                break;
            case 3:
                month = 7;
                break;
            case 4:
                month = 10;
                break;
            default:
                throw new IllegalArgumentException("Argument must be between 1 and 4.");
        }
        return month;
    }
}
