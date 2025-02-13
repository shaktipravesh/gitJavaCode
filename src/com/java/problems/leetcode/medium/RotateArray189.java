package com.java.problems.leetcode.medium;

public class RotateArray189 {
    public void rotate(int[] nums, int k) {
        k = k%nums.length;
        k = nums.length-k;
        int[] temp = new int[k];
        int size = nums.length;
        for(int i = 0; i < nums.length; i++) {
            if(i < k) {
                temp[i] = nums[i];
            }
            if((i+k) <nums.length) {
                nums[i] = nums[k+i];
            } else {
                nums[i] = temp[(k+i)%size];
            }
        }

    }
}
