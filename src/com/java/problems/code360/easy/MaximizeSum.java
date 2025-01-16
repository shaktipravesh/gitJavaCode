package com.java.problems.code360.easy;

public class MaximizeSum {
    public static void main(String[] args) {
        //https://www.naukri.com/code360/problems/maximize-sum_1376445?kunjiRedirection=true
        int[] arr1 = {5,5,6,4,3};
        int[] arr2 = {1,2,5,6,5};
        System.out.println(calculateMaximisedSum(arr1, arr2, 5));
    }

    public static int calculateMaximisedSum(int[] arr1, int[] arr2, int n) {
        int[][] dp = new int[n][2];
        for(int i = 0; i < n; i++) {
            dp[i][1] = Math.abs(arr1[i] - arr2[i]) + (i > 0 ?
                    Math.max(Math.abs(arr2[i] - arr1[i - 1]) + dp[i - 1][1],
                            Math.abs(arr2[i] - arr2[i - 1]) + dp[i - 1][0]) : 0);

            dp[i][0] = Math.abs(arr1[i] - arr2[i]) + (i > 0 ?
                    Math.max(Math.abs(arr1[i] - arr2[i - 1]) + dp[i - 1][0],
                            Math.abs(arr1[i] - arr1[i - 1]) + dp[i - 1][1]) : 0);
        }

        return Math.max(dp[n - 1][0], dp[n - 1][1]);

    }
}
