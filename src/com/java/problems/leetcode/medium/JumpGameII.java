package com.java.problems.leetcode.medium;


public class JumpGameII {
    public static void main(String[] args) {
        int[] nums = {2,3,1,1,4};
        System.out.println(jump(nums));

    }

    public static int jump(int[] nums) {
        if (nums.length == 0) return 0;
        int minSteps = -1;

        int[] steps = new int[nums.length];
        for (int i = 1; i < nums.length; i++) {
            steps[i] = Integer.MAX_VALUE;
        }
        for (int i = 0; i < nums.length; i++) {
            if(steps[i] == Integer.MAX_VALUE) {
                steps[i] = Integer.MAX_VALUE;
                break;
            }
            for (int j = 1; j <= nums[i] && i+j < nums.length; j++) {
                steps[i+j] = Math.min(steps[i+j], steps[i] +1);
            }
        }
        minSteps = steps[nums.length-1];
        return minSteps;
    }

}
