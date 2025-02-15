package com.java.problems.leetcode.medium;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

/*
//Blocks
0|1|2
3|4|5
6|7|8

*/
public class ValidSudoku36 {
    public static void main(String[] args) {
        char[][] board =    {{'5','3','.','.','7','.','.','.','.'}
                            ,{'6','.','.','1','9','5','.','.','.'}
                            ,{'.','9','8','.','.','.','.','6','.'}
                            ,{'8','.','.','.','6','.','.','.','3'}
                            ,{'4','.','.','8','.','3','.','.','1'}
                            ,{'7','.','.','.','2','.','.','.','6'}
                            ,{'.','6','.','.','.','.','2','8','.'}
                            ,{'.','.','.','4','1','9','.','.','5'}
                            ,{'.','.','.','.','8','.','.','7','9'}};
        isValidSudoku(board);
    }
    public static boolean isValidSudoku(char[][] board) {
        boolean isValid = true;
        List<HashSet<Integer>> listRow = new ArrayList<>();
        List<HashSet<Integer>> listCol = new ArrayList<>();
        List<HashSet<Integer>> listBox = new ArrayList<>();

        int boxNumber = 0;
        for(int i = 0; i < 9; i++){
            HashSet<Integer> row = new HashSet<>();
            HashSet<Integer> col = new HashSet<>();
            HashSet<Integer> box = new HashSet<>();
            listRow.add(row);
            listCol.add(col);
            listBox.add(box);
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
