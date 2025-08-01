package com.java.problems.leetcode.medium;

import java.util.HashSet;

public class BitwiseORsofSubarrays898 {
    public int subarrayBitwiseORs(int[] arr) {
        HashSet<Integer> result = new HashSet<>(arr.length);
        HashSet<Integer> ithPrevSet = new HashSet<>();
        for (int num : arr) {
            HashSet<Integer> ithSet = new HashSet<>(32);
            ithSet.add(num);
            for (int j : ithPrevSet) {
                ithSet.add(num | j);
            }
            result.addAll(ithSet);
            ithPrevSet = ithSet;
        }
        return result.size();
    }
}
