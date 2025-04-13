package com.java.problems.leetcode.medium;

import java.util.Arrays;

import static java.lang.System.out;

public class TwoSumIIInputArrayIsSorted {
    public static void main(String[] args) {
        int[] numbers = {2,7,11,15};
        int target = 9;
        TwoSumIIInputArrayIsSorted ts = new TwoSumIIInputArrayIsSorted();
        out.println(Arrays.toString(ts.twoSum(numbers, target)));
    }
    public int[] twoSum(int[] numbers, int target) {
        int[] retValue = new int[2];
        for(int i = 0; i < numbers.length && numbers[i] <=target; i++) {
            retValue[0] = i + 1;
            int left = i+1;
            int right = numbers.length-1;
            while(left <= right) {
                int mid = (left + right)/2;
                if(numbers[mid] + numbers[i] == target) {
                    retValue[1] = mid + 1;
                    i = numbers.length;
                    break;
                }
                if(numbers[mid] + numbers[i] > target) {
                    right = mid - 1;
                } else {
                    left = mid + 1;
                }
            }
        }
        return retValue;
    }
}
