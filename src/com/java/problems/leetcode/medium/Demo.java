package com.java.problems.leetcode.medium;

public class Demo {
    public long[] distance(int[] nums) {
        long[] result = new long[nums.length];
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] == nums[j]) {
                    result[i] += Math.abs(i-j);
                    result[j] += Math.abs(i-j);
                }
            }
        }
        return result;
    }
}
