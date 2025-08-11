package com.java.problems.leetcode.contest;

public class weeklyContest450 {
    public static void main(String[] args) {
        int[] nums = {1,3,2};
        weeklyContest450 w = new weeklyContest450();
        System.out.println(w.smallestIndex(nums));
    }
    public int smallestIndex(int[] nums) {
        if (nums == null || nums.length == 0)
            return 0;
        for(int i=0; i<nums.length; i++) {
            int num = nums[i];
            int digitSum = 0;
            while (num > 0) {
                digitSum += num % 10;
                num = num / 10;
            }
            if(digitSum == i) {
                return i;
            }
        }
        return 0;
    }
}
