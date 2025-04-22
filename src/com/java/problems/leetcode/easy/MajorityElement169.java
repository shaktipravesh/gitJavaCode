package com.java.problems.leetcode.easy;

import java.util.HashMap;

public class MajorityElement169 {
    public static void main(String[] args) {
        int[] nums = {3,2,3};
        System.out.println(majorityElement(nums));
    }
    public static int majorityElement(int[] nums) {
        int majorityCount = 1;
        int majorityNum = nums[0];
        int count = 0;
        HashMap<Integer, Integer> numCount = new HashMap<>();
        for (int num : nums) {
            if (numCount.containsKey(num)) {
                count = numCount.get(num);
                count++;
                if(count > majorityCount) {
                    majorityNum = num;
                    majorityCount = count;
                }
            }
            numCount.put(num, numCount.getOrDefault(num, 0) + 1);
        }
        return majorityNum;
    }

}
