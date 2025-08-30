package com.java.problems.leetcode.medium;

public class LongestSubarrayOf1sAfterDeletingOneElement1493 {
    public static void main(String[] args) {
        LongestSubarrayOf1sAfterDeletingOneElement1493 solution = new LongestSubarrayOf1sAfterDeletingOneElement1493();
        int[] nums = {0,1,1,1,1,1};
        System.out.println(solution.longestSubarray(nums));
    }
    public int longestSubarray(int[] nums) {
        int longestSubArrayAfterDelete = 0;
        int prevLongestSubArray = 0;
        int longestSubArray = 0;
        boolean isDeleted = false;
        for (int i = 0; i < nums.length; i++) {
            if(nums[i] == 1) {
                longestSubArray++;
                continue;
            } else {
                isDeleted = true;
            }
            if(i > 0) {
                longestSubArrayAfterDelete = Math.max(longestSubArrayAfterDelete, prevLongestSubArray + longestSubArray);
                if(nums[i-1] == 0) {
                    prevLongestSubArray = 0;
                } else {
                    prevLongestSubArray = longestSubArray;
                }
                longestSubArray = 0;
            }
        }
        longestSubArrayAfterDelete = Math.max(longestSubArrayAfterDelete, prevLongestSubArray + longestSubArray);
        if(!isDeleted && longestSubArrayAfterDelete > 0){
            longestSubArrayAfterDelete--;
        }
        return longestSubArrayAfterDelete;
    }
}
