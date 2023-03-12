package controller;

import model.Forest;

public class Main {

    public static void main(String[] args) {
        Forest regularForest = new Forest("A beautiful forest");
        boolean isTestMode = true;
        regularForest.parseTreesForForest(isTestMode);
        int numberOfVisibleTrees = regularForest.calculateNumberOfVisibleTrees();
        System.out.println(numberOfVisibleTrees);

    }
}

