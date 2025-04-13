package com.java.problems.leetcode.medium;

import static java.lang.System.*;

public class MaximalSquare221 {
    public static void main(String[] args) {
        char[][] matrix = new char[][]{{'1', '0', '1', '0', '0'}, {'1', '0', '1', '1', '1'}, {'1', '1', '1', '1','1'},{'1','0','0','1','0'}};
        MaximalSquare221 maximalSquare = new MaximalSquare221();
        out.println(maximalSquare.maximalSquare(matrix));

        }

    public int maximalSquare(char[][] matrix) {
        int[][] dp = new int[matrix.length][matrix[0].length];
        int max = 0;
        for (int i = 0; i < matrix.length; i++) {
            dp[i][0] = matrix[i][0] - '0';
            max = Math.max(max, dp[i][0]);
        }
        for (int j = 0; j < matrix[0].length; j++) {
            dp[0][j] = matrix[0][j] - '0';
            max = Math.max(max, dp[0][j]);
        }

        for (int i = 1; i < matrix.length; i++) {
            for (int j = 1; j < matrix[0].length; j++) {
                if (matrix[i][j] == '1' && matrix[i][j - 1] == '1' && matrix[i - 1][j] == '1' && matrix[i - 1][j - 1] == '1') {
                    dp[i][j] = Math.min(Math.min(dp[i - 1][j], dp[i][j - 1]), dp[i - 1][j - 1]) + 1;
                } else {
                    dp[i][j] = matrix[i][j] - '0';
                }
                max = Math.max(max, dp[i][j]);
            }
        }
        return max*max;
    }
}
