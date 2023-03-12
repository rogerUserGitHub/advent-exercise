package model;

import java.util.ArrayList;
import java.util.List;

public class RainForest extends Forest {

    // example of a property specific to RainForest
    private List<String> tropicalTrees;

    public RainForest(String forestName) {
        super(forestName);
        this.tropicalTrees = new ArrayList<>();
    }

}
