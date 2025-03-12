package com.java.problems.leetcode.easy;

import java.util.HashMap;

import static java.lang.System.*;

public class ContainsDuplicateII219 {
    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 1};
        int k = 3;
        ContainsDuplicateII219 c = new ContainsDuplicateII219();
        out.println(c.containsNearbyDuplicate(nums, k));
    }
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(nums[i])) {
                int value = map.get(nums[i]);
                if(i-value <= k) {
                    return true;
                }
            }
            map.put(nums[i], i);
        }
        return false;

    }
}
