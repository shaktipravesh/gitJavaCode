package com.java.problems.leetcode.medium;

import java.util.HashMap;

public class LengthOfLongestSubarrayWithAtMostKFrequency2958 {
    public int maxSubarrayLength(int[] nums, int k) {
        int maxLength = 0;
        int start = 0;
        HashMap<Integer, Integer> numCountMap = new HashMap<>();
        for(int end = 0 ; end < nums.length ; end++) {
            int num = nums[end];
            numCountMap.put(num, numCountMap.getOrDefault(num, 0) + 1);
            while(numCountMap.get(num) > k) {
                numCountMap.put(nums[start], numCountMap.get(nums[start++]) - 1);
            }
            maxLength = Math.max(maxLength, end - start+1);
        }
        return maxLength;
    }

    public int longestSubsequence(int[] nums) {
        int maxLength = 0;
        int start = 0;
        int XOR = 0;
        for(int end = 0 ; end < nums.length ; end++) {
            int num = nums[end];
            XOR = XOR ^ num;
            while(XOR == 0) {
                XOR = XOR ^ nums[start++];
            }
            maxLength = Math.max(maxLength, end - start+1);
        }
        return maxLength;
    }
}
