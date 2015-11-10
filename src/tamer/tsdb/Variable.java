package tamer.tsdb;

import it.unimi.dsi.fastutil.doubles.DoubleArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * class for variable creation
 *
 * @author Tamer Kulaksizoglu
 */
public class Variable {

    /* fields =============================================================== */
    private DoubleArrayList data;
    private String description;
    private String name;
    private VariableType type;

    /* constructor ========================================================== */
    /**
     * constructor
     */
    public Variable() {
        data = null;
        description = "";
        name = "";
        type = VariableType.NOTSET;
    }

    /* get methods ========================================================== */
    /**
     * gets a copy of data
     *
     * @return a copy of data
     */
    public DoubleArrayList getData() {
        return data.clone();
    }

    /**
     * gets a copy of data as double array
     *
     * @return a copy of data
     */
    public double[] getDataAsDoubleArray() {
        return data.toDoubleArray();
    }

    /**
     * gets a copy of data as a list of Double
     *
     * @return a copy of data
     */
    public List<Double> getDataAsList() {
        Double[] array = new Double[data.size()]; // default: null
        array = data.toArray(array);
        List<Double> list = Arrays.asList(array);
        return list;
    }

    /**
     * gets variable description
     *
     * @return description
     */
    public String getDescription() {
        return description;
    }

    /**
     * gets number of missing values
     *
     * @return number of missing values
     */
    public int getMissingCount() {
        int count = 0;
        for (Double val : data) {
            if (val.isNaN()) {
                count++;
            }
        }
        return count;
    }

    /**
     * gets variable name
     *
     * @return name
     */
    public String getName() {
        return name;
    }

    /**
     * gets variable type
     *
     * @return variable type
     */
    public VariableType getVariableType() {
        return type;
    }

    /* set methods ========================================================== */
    /**
     * sets data for variable
     *
     * @param data data
     */
    public void setData(double[] data) {
        this.data = new DoubleArrayList(data.length);
        this.data.addElements(0, data); // deep copies data
    }
    
    public void setData(Double[] data) {
        this.data = new DoubleArrayList(data.length);
        this.data.addAll(Arrays.asList(data));
    }

    /**
     * sets data for variable
     *
     * @param data
     */
    public void setData(List<Double> data) {
        this.data = new DoubleArrayList(data.size());
        this.data.addAll(data); // deep copies data
    }

    /**
     * sets variable description
     *
     * @param description variable description
     */
    public void setDescription(String description) {
        this.description = description;
    }

    /**
     * sets variable name
     *
     * @param name variable name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * sets variable type
     *
     * @param type variable type
     */
    public void setVariableType(VariableType type) {
        this.type = type;
    }

    /* methods ============================================================== */
    public int[] isLessThan(Double val) {
        int[] isLessThan = new int[data.size()];
        int index = -1;
        for (Double datum : data) {
            index++;
            if (datum < val) {
                isLessThan[index] = 1;
            } else {
                isLessThan[index] = 0;
            }
        }
        return isLessThan;
    }
    
    public void getData(int lag1, int lag2) {
        
    }
    
}
