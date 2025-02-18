package com.java.problems.leetcode.medium;

import java.util.TreeSet;

public class JumpGame {
    public static void main(String[] args) {
        int[] nums = {2,0};
        System.out.println(canJump(nums));
        System.out.println(canJumpBruteForce(nums));
    }

    public static boolean canJump(int[] nums) {
        if(nums == null || nums.length <= 1) return true;
        int canJumpTo = nums[0];
        for(int i = 1; i <= canJumpTo; i++) {
            canJumpTo = Math.max(canJumpTo, i + nums[i]);
            if(canJumpTo >= nums.length-1) return true;
        }
        return false;
    }

    public static boolean canJumpBruteForce(int[] nums) {
        if(nums == null || nums.length <= 1) return true;
        TreeSet<Integer> set = new TreeSet<>();
        set.add(0);
        while(!set.isEmpty()) {
            int index = set.getFirst();
            for(int i = 1; i <= nums[index]; i++) {
                if((index + i) >= nums.length-1) return true;
                set.add(index + i);
            }
            set.removeFirst();
        }
        return false;
    }
}
