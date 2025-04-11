package com.java.problems.leetcode.medium;

import static java.lang.System.*;

public class LongestIncreasingSubsequence300 {
    public static void main(String[] args) {
        int[] nums = {10, 9, 2, 5, 3, 7, 101, 4, 119};
        LongestIncreasingSubsequence300 lis = new LongestIncreasingSubsequence300();
        out.println(lis.lengthOfLIS(nums));
    }
    public int lengthOfLIS(int[] nums) {
        if (nums == null || nums.length == 0) return 0;
        int n = nums.length;
        int[] longestSubsequence = new int[n];
        longestSubsequence[0] = nums[0];
        int longestIndex = 0;
        for (int i = 1; i < n; i++) {
            int index = longestIndex;
            while(index >= 0 && longestSubsequence[index] >= nums[i]) {
                index--;
            }
            longestSubsequence[++index] = nums[i];
            longestIndex = Math.max(index, longestIndex);
        }
        return longestIndex+1;
    }
}
