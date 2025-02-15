package com.java.problems.leetcode.medium;

public class JumpGame {
    public static void main(String[] args) {
        int[] nums = {2,3,1,1,4};
        System.out.println(canJump(nums));
    }
    public static boolean canJump(int[] nums) {
        int index = 0;
        for(index = 0; index < nums.length-1; ) {
            if(nums[index] == 0) {
                break;
            }
            index = nums[index] + index;
        }
        if(index == nums.length -1) {
            return true;
        } else {
            return false;
        }
    }
}
