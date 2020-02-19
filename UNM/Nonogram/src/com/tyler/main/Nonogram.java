package com.tyler.main;

public class Nonogram {

    public int height;          // The number of rows in the puzzle.
    public int width;           // The number of columns in the puzzle.
    public int maxRowGroups;    // An upper bound on the number of groups in any one row.
    public int maxColGroups;    // An upper bound on the number of groups in any one column.
    // Note: the above fields are used by the GUI classes, so don't eliminate them.
    // Do ensure that they are initialized to appropriate values.
    boolean[][] guess;          // A rectangular array to hold the user's solution to the puzzle.
    // The next two arrays are the heart of the puzzle.
    int[][] rowGroupLength;     // The group sizes for each row.  rowGroupLength[i][k] is the k'th group in row i.
    int[][] colGroupLength;     // Same, but for columns.  colGroupLength[j][k] is the k'th group in column j.

    public Nonogram(boolean[][] targetSolution) {
        // targetSolution must be an mxn rectangular array where m,n >= 1.

        // Initialize the fields correctly to make a nonogram puzzle of which
        // targetSolution is a valid solution.
        // TODO: your code here

    }

    // The next constructor is provided for you.  It builds off the constructor above.
    public Nonogram(String s) {
        this(stringToBooleanArray(s));
    }


    // The next method is provided for you.  It converts a string to a 2D boolean array.
    static boolean[][] stringToBooleanArray(String s) {

        String[] lines = s.split("\n");
        boolean[][] rv = new boolean[lines.length][];
        for (int i = 0; i < lines.length; i++) {
            String line = lines[i];
            rv[i] = new boolean[line.length()];
            for (int j = 0; j < line.length(); j++) {
                rv[i][j] = (line.charAt(j) != '.');
            }
        }
        return rv;
    }

    int[] findGroupLengths(boolean[] data) {
        // figure out the groups in data, and record their
        // lengths in rowGroupLengths and colGroupLengths
        // TODO: your code here

        return null; // you will replace this
    }

    public String toString() {
        // print out the nonogram as a string.
        // this should include the group lengths
        // as well as the current guess.

        // this will be mainly used as an debugging tool, as
        // the GUI will be better for interacting with the user.

        // For the guess, we will represent the "EMPTY color" by the '.' char,
        // and the "FULL color" (black) by the 'X' char.

        // TODO: your code here.

        return null; // you will replace this
    }

    boolean isGuessCorrect() {
        // return true iff the guess has all the correct row/column
        // group lengths.  It does not have to match the "solution" field.
        // TODO: your code here

        return false;    // you will replace this.
    }

    // The next 4 methods are callback methods that will be invoked by the GUI when appropriate.
    // You need to fill them in to provide the correct functionality.
    public void handleMouseClickAt(int i, int j) {
        // Add code here to handle a "mouseClick" event at row i, column j.
        // You should toggle the guessed color for the cell at the clicked location.
        // You will need to handle the possibility that (i,j) is out of bounds (negative or too big).
        // TODO: your code here

    }

    public void handleMousePressAt(int i, int j) {
        // Add code here to handle a "mousePress" event at row i, column j.
        // You should record the location of the press in an instance variable.
        // Don't display anything until the mouse is released.
        // You will need to handle the possibility that (i,j) is out of bounds (negative or too big).
        // TODO: your code here

    }

    public void handleMouseReleaseAt(int i, int j) {
        // Add code here to handle a "mouseRelease" event at row i, column j.
        // If there was a previous mousePress event, you should now check whether the "release" cell is
        // in the same row or column as the "press" cell.  If it is, you should flip the color of the
        // "press" cell, and color all the other cells between the "press" and "release" cells to match.
        // You will need to handle the possibility that (i,j) is out of bounds (negative or too big).
        // TODO: your code here

    }

    public void handleResetButtonClick() {
        // Add code to handle a click of the "reset" button.
        // You should reset all cells to be empty (white) again.
        // TODO: your code here
    }

    // main method: you can put your own test code in here.
    public static void main(String[] args) {

        String pic = "..XXX..\n.XX.XX.\nXX...XX\nX.....X\nXX...XX\n.XX.XX.\n..XXXX..";
        Nonogram nono = new Nonogram(pic);

        System.out.println(pic);
        System.out.println();
        System.out.println(nono);

        NonogramGUI gui = new NonogramGUI(nono);   // starts up a GUI interface for the puzzle passed to it.
    }

}
