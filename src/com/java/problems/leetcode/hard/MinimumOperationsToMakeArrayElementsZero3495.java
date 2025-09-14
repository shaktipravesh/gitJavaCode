package com.java.problems.leetcode.hard;

public class MinimumOperationsToMakeArrayElementsZero3495 {
    public long minOperations(int[][] queries) {
        long minOperation = 0;
        for (int[] query : queries) {
            minOperation += query[1]-query[0];
        }
        return minOperation;
    }
}
