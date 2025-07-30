package com.java.problems.leetcode.easy;

public class CountHillsNValleys2210 {
    public int countHillValley(int[] nums) {
        int hillORvalley = 0;
        int count = 0;
        int size = nums.length;
        for(int i = 1; i < size; i++) {
            if(nums[i] > nums[i-1]) {
                if(hillORvalley == -1) {
                    count++;
                }
                hillORvalley = 1;
            }
            if(nums[i] < nums[i-1]) {
                if(hillORvalley == 1) {
                    count++;
                }
                hillORvalley = -1;
            }
        }
        return count;
    }
}
