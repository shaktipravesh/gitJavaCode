package com.java.problems.leetcode.medium;

public class LongestSubarrayMaxBitwiseAND2419 {
    public int longestSubarray(int[] nums) {
        int maxAND = Integer.MIN_VALUE;
        int maxCount = 0;
        int currCount = 0;
        for (int num : nums) {
            if(num > maxAND) {
                maxAND = num;
                currCount = 1;
                maxCount = 1;
            } else if(num == maxAND) {
                currCount++;
            } else {
                currCount = 0;
            }
            maxCount = Math.max(maxCount, currCount);
        }
        return maxCount;
    }
}
