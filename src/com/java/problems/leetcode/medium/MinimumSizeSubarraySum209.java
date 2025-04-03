package com.java.problems.leetcode.medium;

import static java.lang.System.*;

public class MinimumSizeSubarraySum209 {
    public static void main(String[] args) {
        int target = 11;
        int[] nums = {1,2,3,4,5};
        MinimumSizeSubarraySum209 ms = new MinimumSizeSubarraySum209();
        out.println(ms.minSubArrayLen(target, nums));
    }

    public int minSubArrayLen(int target, int[] nums) {
        if (nums == null || nums.length == 0) return 0;
        int sum = 0;
        int start = 0;
        int end = 0;
        int minSize = Integer.MAX_VALUE;
        while (end < nums.length) {
            sum += nums[end];

            while (sum >= target) {
                minSize = Math.min(minSize, end - start + 1);
                sum -= nums[start];
                start++;
            }
            end++;
        }
        return minSize == Integer.MAX_VALUE? 0:minSize;
    }
}

