package com.java.problems.leetcode.medium;

import java.util.Arrays;

public class HIndex274 {
    public int hIndex(int[] citations) {
        Arrays.sort(citations);
        int index = 0;
        for (int i = 0; i < citations.length; i++) {
            if (citations[i] >= citations.length - i) {
                index = citations.length - i;
                break;
            }
        }
        return index;
    }
}
