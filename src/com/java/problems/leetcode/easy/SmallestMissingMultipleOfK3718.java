package com.java.problems.leetcode.easy;

import java.util.HashSet;

public class SmallestMissingMultipleOfK3718 {
    public int missingMultiple(int[] nums, int k) {
        int smallest = 1;
        HashSet<Integer> multipleOfK = new HashSet<>();
        for (int i = 0; i < nums.length; i++) {
            int num = nums[i];
            if(num % k == 0)
                multipleOfK.add(num/k);
            if(num / k == smallest) {
                while(multipleOfK.contains(smallest)) {
                    smallest++;
                }
            }
        }
        return smallest*k;
    }
}
