package com.java.problems.leetcode.hard;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class SudokuSolver37 {
    public void solveSudoku(char[][] board) {

    }

    public boolean isValidSudoku(char[][] board) {
        boolean isValid = true;
        List<HashSet<Integer>> listRow = new ArrayList<>();
        List<HashSet<Integer>> listCol = new ArrayList<>();
        List<HashSet<Integer>> listBox = new ArrayList<>();
        List<Integer> zeroList = new ArrayList<>();
        HashSet<Integer>[][] my2DHashSetArray = new HashSet[board.length+1][board[0].length+1];

        int boxNumber = 0;
        for(int i = 1; i <= 9; i++){
            HashSet<Integer> row = new HashSet<>();
            HashSet<Integer> col = new HashSet<>();
            HashSet<Integer> box = new HashSet<>();
            listRow.add(row);
            listCol.add(col);
            listBox.add(box);
        }
        for(int row = 0; row < 9; row++) {
            for (int col = 0; col < 9; col++) {
                if(board[row][col] != '.'){
                    zeroList.add(row*10+col);
                } else {
                    int value = board[row][col] - '0';
                    listRow.get(row).remove(value);
                    listCol.get(col).remove(value);
                    listBox.get(getBoxNumber(row, col)).remove(value);
                }
            }
        }


        for(int row = 0; row < 9 && isValid; row++){
            for(int col = 0; col < 9 && isValid; col++){
                if(board[row][col] != '.') {
                    boxNumber = getBoxNumber(row, col);
                    int value = board[row][col] - '0';
                    if (listRow.get(row).contains(value)) {
                        isValid = false;
                    } else {
                        listRow.get(row).add(value);
                    }
                    if (listCol.get(col).contains(value)) {
                        isValid = false;
                    } else {
                        listCol.get(col).add(value);
                    }
                    if (listBox.get(boxNumber).contains(value)) {
                        isValid = false;
                    } else {
                        listBox.get(boxNumber).add(value);
                    }
                }
            }
        }
        return isValid;
    }

    private static int getBoxNumber(int row, int col) {
        row = row/3;
        col = col/3;
        return row*3+col;
    }
}
