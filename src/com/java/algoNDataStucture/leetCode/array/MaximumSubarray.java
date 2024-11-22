package com.java.algoNDataStucture.leetCode.array;

public class MaximumSubarray {
    public static void main(String[] args) {
        int[] nums = {-2,1,-3,4,-1,2,1,-5,4};
        System.out.println(maxSubArray(nums));
    }

    public static int maxSubArray(int[] nums) {
        int maxSubArraySum = Integer.MIN_VALUE;
        int currentSum = 0;
        for (int num : nums) {

            if (currentSum < 0) {
                currentSum = num;
            } else {
                currentSum += num;
            }
            if (currentSum > maxSubArraySum) {
                maxSubArraySum = currentSum;
            }
        }
        return maxSubArraySum;
    }
}
