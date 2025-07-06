package com.java.problems.code360.easy;

import java.util.HashSet;

public class FindPairSumInRotatedAndSortedArray {
    public static boolean findPairSum(int[] arr, int target)
    {
        HashSet<Integer> set = new HashSet<>();
        for (int j : arr) {
            if (set.contains(target - j)) {
                return true;
            }
            set.add(j);
        }
        return false;
    }
}
