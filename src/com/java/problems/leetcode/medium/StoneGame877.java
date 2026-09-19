package com.java.problems.leetcode.medium;

public class StoneGame877 {
    public static void main(String[] args) {
        StoneGame877 stoneGame877 = new StoneGame877();
        int[] piles = {5,3,4,5};
        stoneGame877.stoneGame(piles);
        int[]  piles01 = {5,3,4,5};
        stoneGame877.stoneGame(piles01);
    }
    public boolean stoneGame(int[] piles) {
        int n = piles.length;
        int[][] dp = new int[n][n];

        // Base case: one pile
        for (int i = 0; i < n; i++) {
            dp[i][i] = piles[i];
        }

        // Build DP table
        for (int len = 2; len <= n; len++) {
            for (int i = 0; i + len - 1 < n; i++) {
                int j = i + len - 1;

                int takeLeft = piles[i] - dp[i + 1][j];
                int takeRight = piles[j] - dp[i][j - 1];

                dp[i][j] = Math.max(takeLeft, takeRight);
            }
        }

        return dp[0][n - 1] > 0;
    }
}
