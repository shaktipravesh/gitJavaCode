package com.java.problems.leetcode.medium;

import java.util.ArrayList;
import java.util.List;

public class SetMatrixZeroes73 {
    public static void main(String[] args) {
        int[][] matrix = {};
        SetMatrixZeroes73 setMatrixZeroes73 = new SetMatrixZeroes73();
        setMatrixZeroes73.setZeroes(matrix);
    }

    public void setZeroes(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        List<List<Integer>> list = new ArrayList<>();
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] == 0) {
                    list.add(new ArrayList<>(List.of(i, j)));
                }
            }
        }
        for (List<Integer> grid : list) {
            int row = grid.get(0);
            int col = grid.get(1);
            for (int j = 0; j < n; j++) {
                matrix[row][j] = 0;
            }
            for (int j = 0; j < m; j++) {
                matrix[j][col] = 0;
            }
        }
    }
}
