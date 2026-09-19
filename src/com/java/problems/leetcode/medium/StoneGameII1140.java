package com.java.problems.leetcode.medium;

public class StoneGameII1140 {
    public static void main(String[] args) {
        StoneGameII1140 s = new StoneGameII1140();
        int[] piles = {2,7,9,4,4};
        System.out.println(s.stoneGameII(piles));
    }
    public int stoneGameII(int[] piles) {
        int n = piles.length;
        int[][] dp = new int[n][n];
        int[][] dpMax = new int[n][n];

        // Base case: one pile
        for (int i = 0; i < n; i++) {
            dp[i][i] = piles[i];
            dpMax[i][i] = piles[i];
        }

        // Build DP table
        for (int len = 2; len <= n; len++) {
            for (int i = 0; i + len - 1 < n; i++) {
                int j = i + len - 1;

                int takeLeft = piles[i] - dp[i + 1][j];
                int takeRight = piles[j] - dp[i][j - 1];

                dp[i][j] = Math.max(takeLeft, takeRight);
                if(takeLeft >= takeRight) {
                    dpMax[i][j] = dpMax[i+1][j-1] + piles[i];
                } else {
                    dpMax[i][j] = dpMax[i+1][j-1] + piles[j];
                }
            }
        }

        return dpMax[0][n - 1];
    }
}
