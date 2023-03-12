package model;

import java.util.Arrays;

public class Tree {
    public int[][] collectionOfTrees;
    private int numberOfRows;
    private int numberOfColumns;

    public Tree() {
        this.collectionOfTrees = new int[numberOfRows][numberOfColumns];
    }

    /*
     * getters & setters
     */
    public int[][] getCollectionOfTrees() {
        return collectionOfTrees;
    }

    public void setCollectionOfTrees(int[][] collectionOfTrees) {
        this.collectionOfTrees = collectionOfTrees;
    }

    public int getNumberOfRows() {
        return numberOfRows;
    }

    public int getNumberOfColumns() {
        return numberOfColumns;
    }

    public void setNumberOfRows(int numberOfRows) {
        this.numberOfRows = numberOfRows;
    }

    public void setNumberOfColumns(int numberOfColumns) {
        this.numberOfColumns = numberOfColumns;
    }

    @Override
    public String toString() {
        return "Tree{" +
                "collectionOfTrees=" + Arrays.toString(collectionOfTrees) +
                '}';
    }
}
