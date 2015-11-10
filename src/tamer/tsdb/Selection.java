package tamer.tsdb;

public class Selection {

    private String variableName;
    private int lag1;
    private int lag2;

    public Selection() {
        variableName = "";
        lag1 = -1;
        lag2 = -1;
    }

    public int getLag1() {
        return lag1;
    }

    public int getLag2() {
        return lag2;
    }

    public String getVariableName() {
        return variableName;
    }

    public void setVariableName(String variableName) {
        this.variableName = variableName;
    }

    public void setLags(int lag1, int lag2) {
        this.lag1 = lag1;
        this.lag2 = lag2;
    }
}
