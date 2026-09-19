package com.java.problems.code360.easy;

import java.util.ArrayList;
import java.util.List;

public class MaximumOfAllSubarraysOfSizeK {
    public static void main(String[] args) {

    }
    public static List<Integer> maximumInAllSubarraysOfSizeK(int[] arr, int n, int k) {
        List<Integer> result = new ArrayList<>();
        for (int i = 0; i < arr.length-k+1; i++) {
            int max = Integer.MIN_VALUE;
            for (int j = i; j < i+k; j++) {
                max = Math.max(max, arr[j]);
            }
            result.add(max);
        }
        return result;
    }
}
