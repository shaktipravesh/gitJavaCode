package com.java.problems.leetcode.hard;

public class NQueensII52 {
    public static void main(String[] args) {
        NQueensII52 solution = new NQueensII52();
        System.out.println(solution.totalNQueens(1));
    }

    static int countWays = 0;
    public int totalNQueens(int n) {
        countWays = 0;
        int row = 0;
        int[][] blocks = new int[n][n];
        placeQueens(row, blocks, n);
        return countWays;
    }

    private void placeQueens(int row, int[][] blocks, int n) {
        for(int i = 0; i < n; i++) {
            if(blocks[row][i] == 0) {
                if(row == n - 1) {
                    blocks[row][i] = 2;
                    countWays++;
                } else {
                    int[][] newBlocks = getNewBlocks(row, i, blocks, n);
                    placeQueens(row+1, newBlocks, n);
                }

            }
        }
    }

    private int[][] getNewBlocks(int row, int col, int[][] blocks, int n) {

        int[][] newBlocks = new int[n][n];
        newBlocks[row][col] = 2;
        for(int i = 1; i + row < n; i++) {
            System.arraycopy(blocks[row + i], 0, newBlocks[row + i], 0, n);
            newBlocks[row + i][col] = 1;  //down
            if(col + i < n) { //left diagonal
                newBlocks[row + i][col + i] = 1;
            }
            if(col - i >= 0) { //right diagonal
                newBlocks[row + i][col - i] = 1;
            }
        }
        return newBlocks;
    }
}
