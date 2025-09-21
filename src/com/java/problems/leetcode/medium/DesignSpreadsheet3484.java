package com.java.problems.leetcode.medium;

public class DesignSpreadsheet3484 {
    public static void main(String[] args) {
        //[[24],["B24",66688],["O15"]]
        Spreadsheet spreadsheet = new Spreadsheet(24);
    }
}
class Spreadsheet {

    int[][] spreadsheet;
    public Spreadsheet(int rows) {
        spreadsheet = new int[rows][26];
    }

    public void setCell(String cell, int value) {
        int row = Integer.parseInt(cell.replaceAll("[^0-9]", ""));
        int col = cell.replaceAll("[^a-zA-Z]", "").charAt(0) - 'A';
        spreadsheet[row][col] = value;
    }

    public void resetCell(String cell) {
        setCell(cell, 0);
    }

    public int getValue(String formula) {
        String[] cells = formula.substring(1).split("[^A-Z0-9]+");
        int firstNum;
        int firstRow = Integer.parseInt(cells[0].replaceAll("[^0-9]", ""));
        if(!cells[0].replaceAll("[^a-zA-Z]", "").isEmpty()) {
            int firstCol = cells[0].replaceAll("[^a-zA-Z]", "").charAt(0) - 'A';
            firstNum = spreadsheet[firstRow][firstCol];
        } else {
            firstNum = firstRow;
        }

        int secondNum;
        int secondRow = Integer.parseInt(cells[1].replaceAll("[^0-9]", ""));
        if(!cells[1].replaceAll("[^a-zA-Z]", "").isEmpty()) {
            int secondCol = cells[1].replaceAll("[^a-zA-Z]", "").charAt(0) - 'A';
            secondNum = spreadsheet[secondRow][secondCol];
        } else {
            secondNum = secondRow;
        }
        return firstNum + secondNum;
    }

}
