package com.java.problems.leetcode.medium;

public class FractionToRecurringDecimal166 {
    public static int minimumPathSum(int[][] triangle, int n) {
        int minPathSum = Integer.MAX_VALUE;
        for (int i = 1; i < triangle.length; i++) {
            for (int j = 0; j < triangle[i].length; j++) {
                if(j == triangle[i].length - 1) {
                    triangle[i][j] += triangle[i - 1][j - 1];
                } else if(j > 0) {
                    triangle[i][j] += Math.min(triangle[i - 1][j], triangle[i - 1][j - 1]);
                } else {
                    triangle[i][j] += triangle[i - 1][j];
                }
                if(i == triangle.length - 1) {
                    minPathSum = Math.min(minPathSum, triangle[i][j]);
                }
            }
        }
        return minPathSum;
    }
}
