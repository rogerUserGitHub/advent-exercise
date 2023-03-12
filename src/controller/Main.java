package controller;

import model.Forest;
import model.RainForest;

public class Main {

    public static void main(String[] args) {

        Forest testForest = new Forest("A beautiful forest");
        Forest rainForest = new RainForest("Amazon Forest");

        boolean isTestMode1 = true;
        boolean isTestMode2 = false;

        testForest.parseTreesForForest(isTestMode1);
        rainForest.parseTreesForForest(isTestMode2);

        int numberOfVisibleTreesTestForest = testForest.calculateNumberOfVisibleTrees();
        int numberOfVisibleTreesRealForest = rainForest.calculateNumberOfVisibleTrees();

        System.out.println("Number of visible trees in the forest:");
        System.out.println("+----------------+------------+------------+------------+");
        System.out.println("| Forest Type    | Visible    | Total      | Grid       ");
        System.out.println("+----------------+------------+------------+------------+");
        System.out.printf("| Test           | %-10d | %-10d | %dx%d      \n",
                numberOfVisibleTreesTestForest,
                testForest.getTree().getNumberOfRows() * testForest.getTree().getNumberOfColumns(),
                testForest.getTree().getNumberOfRows(),
                testForest.getTree().getNumberOfColumns());
        System.out.println("+----------------+------------+------------+------------+");
        System.out.printf("| Real forest    | %-10d | %-10d | %dx%d      \n",
                numberOfVisibleTreesRealForest,
                rainForest.getTree().getNumberOfRows() * rainForest.getTree().getNumberOfColumns(),
                rainForest.getTree().getNumberOfRows(),
                rainForest.getTree().getNumberOfColumns());
        System.out.println("+----------------+------------+------------+------------+");

        System.out.println("@Roger Dirkx");
    }
}

