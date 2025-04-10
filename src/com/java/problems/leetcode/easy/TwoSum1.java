package com.java.problems.leetcode.easy;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import static java.lang.System.*;

public class TwoSum1 {
    public static void main(String[] args) {
        int[] nums = {2, 7, 11, 15};
        int target = 9;

        int[] result = twoSum(nums, target);
        out.println(Arrays.toString(result));
    }
    public static int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        int size = nums.length;

        for (int i = 0; i < size; i++) {
            int complement = target - nums[i];

            if (map.containsKey(complement)) {
                return new int[]{map.get(complement), i};
            }

            map.put(nums[i], i);
        }

        return new int[]{-1, -1};
    }
}
