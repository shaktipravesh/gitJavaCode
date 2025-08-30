package com.java.problems.leetcode.medium;

public class CountSquareSubmatricesWithAllOnes1277 {
    public static void main(String[] args) {

    }

    public int countSquares(int[][] matrix) {
        int numOfSquares = 0;
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (i >0 && j > 0 && matrix[i][j] == 1) {
                    matrix[i][j] = Math.min(Math.min(matrix[i - 1][j - 1], matrix[i - 1][j]), matrix[i][j - 1]) + matrix[i][j];
                }
                numOfSquares = numOfSquares + matrix[i][j];
            }
        }
        return numOfSquares;
    }
}
