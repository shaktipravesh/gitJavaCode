package com.java.problems.leetcode.medium;

import java.util.Arrays;

public class MaximumNumberofJumpsToReachLastIndex2770 {
    public static void main(String[] args) {
        MaximumNumberofJumpsToReachLastIndex2770 max = new MaximumNumberofJumpsToReachLastIndex2770();
        int[] nums = {0,2,1,3};
        int target = 1;
        System.out.println(max.maximumJumps(nums, target));
    }
    public int maximumJumps(int[] nums, int target) {
        int[] dp = new int[nums.length];
        Arrays.fill(dp, -1);
        dp[0] = 0;
        for (int i = 0; i < nums.length; i++) {
            if(i > 0 && dp[i] <= 0) {
                continue;
            }
            for (int j = i + 1; j < nums.length; j++) {
                if(Math.abs(nums[i] - nums[j]) <= Math.abs(target)) {
                    dp[j] = Math.max(dp[i]+1, dp[j]);
                }
            }
        }
        return dp[nums.length - 1];
    }
}
