package tamer.tsdb;

import java.util.ArrayList;
import java.util.List;

public class Database {

    /* fields =============================================================== */
    protected String name;
    protected AbstractSample sample;
    protected final List<Variable> variables;

    /* constructors ========================================================= */
    public Database(int year1, int year2) {
        this(year1, year2, "");
    }

    public Database(int year1, int year2, String name) {
        this.name = name;
        sample = new AnnualSample(year1, year2);
        variables = new ArrayList<>();
    }

    public Database(Frequency freq, int year1, int period1, int year2, int period2) {
        this(freq, year1, period1, year2, period2, "");
    }

    public Database(Frequency freq, int year1, int period1, int year2, int period2, String name) {
        this.name = name;
        if (null != freq) {
            switch (freq) {
                case ANNUAL:
                    sample = new AnnualSample(year1, year2);
                    break;
                case MONTHLY:
                    sample = new MonthlySample(year1, period1, year2, period2);
                    break;
                case QUARTERLY:
                    sample = new QuarterlySample(year1, period1, year2, period2);
                    break;
                default:
                    break;
            }
        }
        this.variables = new ArrayList<>();
    }

    /**
     * adds a variable to database
     *
     * @param data data of variable to be added
     * @param name name of variable
     */
    public void addVariable(double[] data, String name) {
        if (this.variableExists(name) == true) {
            throw new IllegalArgumentException("Variable " + name + " already exists in the database.");
        }
        if (data.length != sample.getSize()) {
            throw new IllegalArgumentException("Variable data must contain " + sample.getSize() + " elements.");
        }
        Variable var = new Variable();
        var.setData(data);
        var.setName(name);
        variables.add(var);
    }

    public void addVariable(Double[] data, String name) {
        if (this.variableExists(name) == true) {
            throw new IllegalArgumentException("Variable " + name + " already exists in the database.");
        }
        if (data.length != sample.getSize()) {
            throw new IllegalArgumentException("Variable data must contain " + sample.getSize() + " elements.");
        }
        Variable var = new Variable();
        var.setData(data);
        var.setName(name);
        variables.add(var);
    }

    public void addVariable(List<Double> data, String name) {
        if (this.variableExists(name) == true) {
            throw new IllegalArgumentException("Variable " + name + " already exists in the database.");
        }
        if (data.size() != sample.getSize()) {
            throw new IllegalArgumentException("Variable data must contain " + sample.getSize() + " elements.");
        }
        Variable var = new Variable();
        var.setData(data);
        var.setName(name);
        variables.add(var);
    }

    public void addVariable(Double[] data, String name, int index) {
        Variable var = new Variable();
        double[] newData = new double[index + data.length];
        for (int i = 0; i < index; i++) {
            newData[i] = Double.NaN;
        }
        for (int i = index; i < newData.length; i++) {
            newData[i] = data[i - index];
        }
        var.setData(newData);
        var.setName(name);
        variables.add(var);
    }

    public void addVariables(double[][] data, String[] names) {
        int index = -1;
        for (double[] array : data) {
            this.addVariable(array, names[++index]);
        }
    }

    public void addVariables(Double[][] data, String[] names) {
        int index = -1;
        for (Double[] array : data) {
            this.addVariable(array, names[++index]);
        }
    }

    public void addVariables(List<List<Double>> data, String[] names) {
        int index = -1;
        for (List<Double> list : data) {
            this.addVariable(list, names[++index]);
        }
    }

    public void addTrend(String name) {
        if (this.variableExists(name) == true) {
            throw new IllegalArgumentException("Variable " + name + " already exists in database.");
        }
        Double[] data = new Double[sample.getSize()];
        for (int i = 0; i < sample.getSize(); i++) {
            data[i] = i + 1d;
        }
        Variable var = new Variable();
        var.setData(data);
        //var.setTrend();
        var.setName(name);
        variables.add(var);
    }

    public void addTrend(String name, int index1, int index2) {
        Double[] data = new Double[sample.getSize()];
        for (int i = index1; i < index2; i++) {
            data[i] = i - index1 + 1d;
        }
        Variable var = new Variable();
        var.setData(data);
        //var.setTrend();
        var.setName(name);
        variables.add(var);
    }

    /**
     * gets sample frequency
     *
     * @return sample frequency
     */
    public Frequency getFrequency() {
        return sample.getFrequency();
    }

    /**
     * gets number of variables in database
     *
     * @return number of variables
     */
    public int getVariableCount() {
        return variables.size();
    }

    /**
     * gets number of observations in database
     *
     * @return number of observations
     */
    public int getObservationCount() {
        return sample.getSize();
    }

    public void info() {
        System.out.println("Database Name:\t\t" + name);
        System.out.println("Variable Count:\t\t" + this.getVariableCount());
        System.out.println("Observation Count:\t" + this.getObservationCount());
        System.out.println("Frequency:\t\t" + this.getFrequency().toString());
        System.out.println("Variable Name\t\t#Missing");
        variables.stream().forEach((var) -> {
            System.out.println(var.getName() + "\t\t\t" + var.getMissingCount());
        });
    }

    /**
     * removes a variable by name
     *
     * @param name name of variable to be removed
     */
    public void removeVariable(String name) {
        int index = this.getVariableIndex(name);
        variables.remove(index);
    }

    private Boolean variableExists(String name) {
        Boolean varExist = false;
        for (Variable var : variables) {
            if (var.getName().equals(name)) {
                varExist = true;
                break;
            }
        }
        return varExist;
    }

    private int getVariableIndex(String name) {
        int index = -1;
        int counter = -1;
        for (Variable var : variables) {
            counter++;
            if (var.getName().equals(name)) {
                index = counter;
                break;
            }
        }
        return index;
    }

    public Variable getVariable(String name) {
        int index = this.getVariableIndex(name);
        return variables.get(index);
    }

    public void setVariableType(String name, VariableType type) {
        int index = this.getVariableIndex(name);
        if (index == -1) {
            throw new IllegalArgumentException("Variable " + name + " does not exist in database.");
        }
        variables.get(index).setVariableType(type);
    }
}
