package model;

import model.interfaces.ForestGenerator;
import model.utilities.Pair;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Forest implements ForestGenerator {
    public String forestName;
    private Tree tree;
    private Set<Pair> countedTrees;
    private final String pathnameToRealTrees = "src/resources/trees.txt";
    private final String pathnameToMockTrees = "src/resources/test.txt";
    private final String pathnameToMockTrees2 = "src/resources/test2.txt";

    private Forest(String forestName, Tree tree, Set<Pair> countedTrees) {
        this.forestName = forestName;
        this.tree = tree;
        this.countedTrees = countedTrees;
    }

    public Forest(String forestName) {
        this(forestName, new Tree(), new HashSet<>());
    }

    public void parseTreesForForest(boolean isTestMode) {
        try {
            Scanner scanner;
            if (isTestMode) {
                scanner = new Scanner(new File(pathnameToMockTrees2));
            } else {
                scanner = new Scanner(new File(pathnameToRealTrees));
            }

            ArrayList<ArrayList<Integer>> arrayOfTrees = new ArrayList<>();
            int numRows = 0;
            int numCols = 0;

            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                ArrayList<Integer> rowOfTrees = new ArrayList<>();
                for (int i = 0; i < line.length(); i++) {
                    int tree = Character.getNumericValue(line.charAt(i));
                    rowOfTrees.add(tree);
                }
                arrayOfTrees.add(rowOfTrees);
                numRows++;
                numCols = rowOfTrees.size();
            }

            tree.setNumberOfRows(numRows);
            tree.setNumberOfColumns(numCols);

            // convert the ArrayList to a 2D array
            tree.setCollectionOfTrees(new int[numRows][numCols]);
            int[][] twoDArrayOfTrees = tree.getCollectionOfTrees();
            for (int i = 0; i < numRows; i++) {
                ArrayList<Integer> row = arrayOfTrees.get(i);
                for (int j = 0; j < numCols; j++) {
                    twoDArrayOfTrees[i][j] = row.get(j);
                }
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    /*
     * The method has a 4-step approach to calculating the line of sight.
     * Uses the Pair object to keep track of trees that have already been
     * counted.
     * @return total number of visible trees in the forest
     */
    public int calculateNumberOfVisibleTrees() {
        int count = 0;
        int rowLength = tree.collectionOfTrees.length;
        int columnLength = tree.collectionOfTrees[0].length;

        // count visible numbers in each row, left to right
        for (int row = 0; row < rowLength; row++) {
            int visible = 0;
            int max = -1;
            for (int column = 0; column < columnLength; column++) {
                if (tree.collectionOfTrees[row][column] > max) {
                    Pair tempPair = new Pair(row, column);
                    countedTrees.add(tempPair);
                    visible++;
                    max = tree.collectionOfTrees[row][column];
                }
                else if (tree.collectionOfTrees[row][column] < max) {
                    break;
                }
            }
            count += visible;
        }

        // count visible numbers in each row, right to left
        for (int row = 0; row < rowLength; row++) {
            int visible = 0;
            int max = -1;
            for (int column = columnLength - 1; column >= 0; column--) {
                if (tree.collectionOfTrees[row][column] > max && !countedTrees.contains(new Pair(row, column))) {
                    Pair tempPair = new Pair(row, column);
                    countedTrees.add(tempPair);
                    visible++;
                    max = tree.collectionOfTrees[row][column];
                } else if (tree.collectionOfTrees[row][column] < max) {
                    break;
                }
            }
            count += visible;
        }

        // count visible numbers in each column, top to down
        for (int column = 0; column < columnLength; column++) {
            int visible = 0;
            int max = -1;
            for (int row = 0; row < rowLength; row++) {
                if (countedTrees.contains(new Pair(row, column)) && tree.collectionOfTrees[row][column] > max) {
                    max = tree.collectionOfTrees[row][column];
                }
                if (tree.collectionOfTrees[row][column] > max && !countedTrees.contains(new Pair(row, column))) {
                    Pair tempPair = new Pair(row, column);
                    countedTrees.add(tempPair);
                    visible++;
                    max = tree.collectionOfTrees[row][column];
                }
                else if (tree.collectionOfTrees[row][column] < max) {
                    break;
                }
            }
            count += visible;
        }

        // count visible numbers in each column, bottom to up
        for (int column = 0; column < columnLength; column++) {
            int visible = 0;
            int max = -1;
            for (int row = rowLength - 1; row >= 0; row--) {
                if (countedTrees.contains(new Pair(row, column)) && tree.collectionOfTrees[row][column] > max) {
                    max = tree.collectionOfTrees[row][column];
                }
                if (tree.collectionOfTrees[row][column] > max && !countedTrees.contains(new Pair(row, column))) {
                    Pair tempPair = new Pair(row, column);
                    countedTrees.add(tempPair);
                    visible++;
                    max = tree.collectionOfTrees[row][column];
                }  else if (tree.collectionOfTrees[row][column] < max) {
                    break;
                }
            }
            count += visible;
        }
        return count;
    }

    /*
     * getters & setters
     */
    public Tree getTree() {
        return tree;
    }

}
