package com.java.problems.leetcode.medium;

import java.util.ArrayList;

public class FindTwoNonOverlappingSubArraysEachWithTargetSum1477 {
    public static void main(String[] args) {
        FindTwoNonOverlappingSubArraysEachWithTargetSum1477 obj = new FindTwoNonOverlappingSubArraysEachWithTargetSum1477();
        int[] arr = {4,3,2,6,2,3,4};
        int target = 6;
        System.out.println(obj.minSumOfLengths(arr, target));
    }
    public int minSumOfLengths(int[] arr, int target) {
        int size = arr.length;
        int[] left = new int[arr.length];
        int[] right = new int[arr.length];
        for (int i = 0; i < arr.length; i++) {
            left[i] = Integer.MAX_VALUE;
            right[i] = Integer.MAX_VALUE;
        }
        int currTarget = 0;
        int minLength = Integer.MAX_VALUE;

        for (int start = 0, end = 0; end < arr.length; end++) {
            currTarget += arr[end];
            while (currTarget > target) {
                currTarget -= arr[start++];
            }
            while (currTarget == target && start <= end) {
                left[start] = end - start +1;
                currTarget -= arr[start++];
            }
        }
        currTarget = 0;
        for (int start = arr.length-1, end = arr.length -1 ; start >=0; start--) {
            currTarget += arr[start];
            while (currTarget > target) {
                currTarget -= arr[end--];
            }
            while (currTarget == target && end >= start) {
                right[end] = end - start +1;
                currTarget -= arr[end--];
            }
        }

        for(int i = 1; i < size ; i++){
            left[size-i-1] = Math.min(left[size - i - 1], left[size - i]);
            right[i] = Math.min(right[i], right[i - 1]);
        }
        for(int i = 0; i < size - 1 ; i++){
            if(left[i+1] != Integer.MAX_VALUE && right[i] != Integer.MAX_VALUE){
                minLength = Math.min(minLength, right[i] + left[i+1]);
            }
        }
        return minLength == Integer.MAX_VALUE ? -1 : minLength;
    }
}
