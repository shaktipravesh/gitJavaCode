package com.java.problems.leetcode.medium;

import java.util.Arrays;

public class ValidTriangleNumber611 {
    public static void main(String[] args) {

    }

    public int firstGreaterIndex(int[] arr, int target) {
        int left = 0, right = arr.length - 1;
        int result = -1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (arr[mid] > target) {
                result = mid;       // candidate found
                right = mid - 1;    // try to find smaller index
            } else {
                left = mid + 1;     // need bigger number
            }
        }
        return result;
    }
}
