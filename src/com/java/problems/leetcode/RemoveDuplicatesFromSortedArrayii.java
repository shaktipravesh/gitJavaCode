package com.java.problems.leetcode;

public class RemoveDuplicatesFromSortedArrayii {
    public static void main(String[] args) {
        int[] nums = {0,0,0,0,0};
        removeDuplicates(nums);
    }
    public static int removeDuplicates(int[] nums) {
        int size = nums.length;
        int max = 1000000;
        int start = 0;
        if(size <=2) {
            return size;
        }
        for(int temp = 2; temp < size; temp++) {
            if(nums[temp] == nums[temp-2]) {
                nums[temp-2] = max;
            }
        }
        for(int temp = 0; temp < size; temp++) {
            if(nums[temp] != max) {
                nums[start++] = nums[temp];
            }
        }
        return start;
    }
}
