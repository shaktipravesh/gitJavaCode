package com.java.problems.leetcode.contest;

public class BiweeklyContest150 {
    public static void main(String[] args) {
        int[] nums = {1,3,2,1,5,4};
        System.out.println(sumOfGoodNumbers(nums, 2));
        nums = new int[]{17, 20};
        System.out.println(sumOfGoodNumbers(nums, 1));
    }
    public static int sumOfGoodNumbers(int[] nums, int k) {        int sum = 0;
        for (int i = 0; i < nums.length; i++) {

            if(((i-k >= 0 && nums[i] > nums[i-k]) && (i+k < nums.length && nums[i] > nums[i+k]))
                    || ((i-k < 0) && (i+k < nums.length && nums[i] > nums[i+k]))
                    || ((i-k >= 0 && nums[i] > nums[i-k]) && (i+k >= nums.length))) {
                sum += nums[i];
            }
        }
        return sum;
    }
}
