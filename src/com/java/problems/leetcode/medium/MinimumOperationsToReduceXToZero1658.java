package com.java.problems.leetcode.medium;

public class MinimumOperationsToReduceXToZero1658 {
    public static void main(String[] args) {
        MinimumOperationsToReduceXToZero1658 m = new MinimumOperationsToReduceXToZero1658();
//        int[] nums = {1,1,4,2,3};
//        int x = 5;
        int[] nums = {1,1};
        int x = 3;
        System.out.println(m.minOperations(nums, x));
    }

    public int minOperations(int[] nums, int x) {
        int minOperation = Integer.MAX_VALUE;
        int size = nums.length;
        int curSum = 0;
        int left = -1;
        int right = size;

        while (left < size - 1 && curSum < x) {
            curSum += nums[++left];
        }
        if (curSum == x) {
            minOperation = Math.min(minOperation, left + 1);
        }
        while (left >= 0) {
            curSum -= nums[left--];
            while (right > left + 1 && curSum < x) {
                curSum += nums[--right];
            }
            if (curSum == x) {
                minOperation = Math.min(minOperation,(left + 1) + (size - right));
            }
        }
        return minOperation == Integer.MAX_VALUE ? -1 : minOperation;
    }
}
