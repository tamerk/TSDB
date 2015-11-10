package tamer.tsdb;

import java.util.ArrayList;
import java.util.List;
import org.apache.commons.math3.linear.Array2DRowRealMatrix;
import org.apache.commons.math3.linear.RealMatrix;

public class Modelbase extends Database {

    private List<Group> groupList;

    public Modelbase(int year1, int year2) {
        super(year1, year2);
        groupList = new ArrayList<>();
    }

    public Modelbase(int year1, int year2, String name) {
        super(year1, year2, name);
        groupList = new ArrayList<>();
    }

    public Modelbase(Frequency freq, int year1, int period1, int year2, int period2) {
        super(freq, year1, period1, year2, period2);
        groupList = new ArrayList<>();
    }

    public Modelbase(Frequency freq, int year1, int period1, int year2, int period2, String name) {
        super(freq, year1, period1, year2, period2, name);
        groupList = new ArrayList<>();
    }

    public void select(String groupName, String variableName, int lag1, int lag2) {
        // check if group already exists
        Group group = null;
        for (Group existingGroup : groupList) {
            if (existingGroup.getName().equals(groupName)) {
                group = existingGroup;
                break;
            }
        }
        Selection selection = new Selection();
        selection.setVariableName(variableName);
        selection.setLags(lag1, lag2);
        if (group != null) { // group already exists
            group.addSelection(selection);
        } else { // group does not exist
            group = new Group();
            group.setName(groupName);
            group.addSelection(selection);
            groupList.add(group);
        }
    }

    public void getGroup(String name) {
        int columnCount = 0;
        for (Group group : groupList) {
            if (group.getName().equals(name)) {
                List<Selection> selectionList = group.getSelectionList();
                for (Selection selection : selectionList) {
                    //String variableName = selection.getVariableName();
                    int lag1 = selection.getLag1();
                    int lag2 = selection.getLag2();
                    columnCount += lag2 - lag1 + 1;
                }
            }
        }
        int rowCount = sample.getSize();
        System.out.println(rowCount + " by " + columnCount);
        RealMatrix mat = new Array2DRowRealMatrix(rowCount, columnCount);

//                    Variable var = this.getVariable(variableName);
//                    System.out.println(lag1 + ", " + lag2);
    }
}
