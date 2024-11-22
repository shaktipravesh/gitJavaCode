package com.java.algoNDataStucture.leetCode.array;

public class MaximumAbsoluteSumOfAnySubarray {
    public static void main(String[] args) {
        int[] nums = {1,-3,2,3,-4};
        System.out.println(maxAbsoluteSum(nums));

        nums = new int[]{2, -5, 1, -4, 3, -2};
        System.out.println(maxAbsoluteSum(nums));
    }
    public static int maxAbsoluteSum(int[] nums) {
        int maxSubArraySum = Integer.MIN_VALUE;
        int minSubArraySum = Integer.MAX_VALUE;
        int currentMaxSum = Integer.MIN_VALUE;
        int currentMinSum = Integer.MAX_VALUE;
        for (int num : nums) {
            if (currentMaxSum < 0) {
                currentMaxSum = num;
            } else {
                currentMaxSum += num;
            }
            if (currentMaxSum > maxSubArraySum) {
                maxSubArraySum = currentMaxSum;
            }
            if (currentMinSum > 0) {
                currentMinSum = num;
            } else {
                currentMinSum += num;
            }
            if (currentMinSum < minSubArraySum) {
                minSubArraySum = currentMinSum;
            }
        }
        return Math.max(maxSubArraySum, Math.abs(minSubArraySum));
    }
}
