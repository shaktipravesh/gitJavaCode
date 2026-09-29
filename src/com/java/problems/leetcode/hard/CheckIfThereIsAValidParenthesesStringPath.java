package com.java.problems.leetcode.hard;

import java.util.Stack;

public class CheckIfThereIsAValidParenthesesStringPath {
    public boolean hasValidPath(char[][] grid) {
        int m = grid.length;
        int n = grid[0].length;

        return checkValidPath(0, 0, m, n, grid, 0);
    }

    private boolean checkValidPath(int row, int col, int m, int n, char[][] grid, int openCount) {

        if (row < 0 || row >= m || col < 0 || col >= n) {
            return false;
        }

        int openCountTemp = openCount;
        if (grid[row][col] == '(') {
            openCountTemp++;
        } else {
            openCountTemp--;
        }
        if (openCountTemp < 0) {
            return false;
        }

        if (row == m - 1 && col == n - 1) {
            return openCountTemp == 0;
        }
        return checkValidPath(row, col + 1, m, n, grid,openCountTemp) || checkValidPath(row + 1, col, m, n, grid,openCountTemp);
    }
}
