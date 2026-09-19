package com.java.problems.leetcode.medium;

public class CountSubmatricesWithAllOnes1504 {
    public static void main(String[] args) {

    }
    public int numSubmat(int[][] mat) {
        int rectangleCount = 0;
        int rows = mat.length;
        int cols = mat[0].length;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (i > 0 && mat[i][j] == 1) {
                    mat[i][j] = mat[i][j] + mat[i - 1][j];
                }
            }

            for(int j = 0; j < cols; j++) {
                int minheight = mat[i][j];
                for (int k = j; k >= 0 && minheight > 0; k--) {
                    minheight = Math.min(minheight, mat[i][k]);
                    rectangleCount += minheight;
                }
            }
        }
        return rectangleCount;
    }
}
