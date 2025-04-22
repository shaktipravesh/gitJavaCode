package com.java.problems.code360.medium;

import java.util.Arrays;
import java.util.TreeSet;

public class DetectOdd {
    public static void main(String[] args) {
        int[] nums = new int[10];
        System.out.println(Arrays.toString(detectOdd(nums.length, nums)));
    }
    static int[] detectOdd(int n, int nums[]) {
        TreeSet<Integer> oddSet = new TreeSet<>();
        for (int num : nums) {
            if (oddSet.contains(num)) {
                oddSet.remove(num);
            } else {
                oddSet.add(num);
            }
        }
        return oddSet.stream().mapToInt(Integer::intValue).toArray();
    }
}
