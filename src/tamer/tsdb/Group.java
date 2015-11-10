package tamer.tsdb;

import java.util.ArrayList;
import java.util.List;

public class Group {

    private String name;
    private List<Selection> selectionList;

    public Group() {
        name = "";
        selectionList = new ArrayList<>();
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public List<Selection> getSelectionList() {
        return selectionList;
    }

    public void addSelection(Selection selection) {
        this.selectionList.add(selection);
    }
}
