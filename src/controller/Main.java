package controller;

import model.Forest;

public class Main {

    public static void main(String[] args) {

        boolean isTestMode1 = true;
        boolean isTestMode2 = false;

        Forest regularForest = new Forest("A beautiful forest");
        Forest rainForest = new Forest("Amazon Forest");

        regularForest.parseTreesForForest(isTestMode1);
        rainForest.parseTreesForForest(isTestMode2);

        int numberOfVisibleTreesRegularForest = regularForest.calculateNumberOfVisibleTrees();
        int numberOfVisibleTreesRainForest = rainForest.calculateNumberOfVisibleTrees();

        System.out.println("Number of visible trees in the forest:");
        System.out.println("+----------------+------------+------------+------------+");
        System.out.println("| Forest Type    | Visible    | Total      | Grid       ");
        System.out.println("+----------------+------------+------------+------------+");
        System.out.printf("| Regular        | %-10d | %-10d | %dx%d      \n",
                numberOfVisibleTreesRegularForest,
                regularForest.getTree().getNumberOfRows() * regularForest.getTree().getNumberOfColumns(),
                regularForest.getTree().getNumberOfRows(),
                regularForest.getTree().getNumberOfColumns());
        System.out.println("+----------------+------------+------------+------------+");
        System.out.printf("| Rain           | %-10d | %-10d | %dx%d      \n",
                numberOfVisibleTreesRainForest,
                rainForest.getTree().getNumberOfRows() * rainForest.getTree().getNumberOfColumns(),
                rainForest.getTree().getNumberOfRows(),
                rainForest.getTree().getNumberOfColumns());
        System.out.println("+----------------+------------+------------+------------+");

        System.out.println("@Roger Dirkx");
    }
}

