package com.java.problems.leetcode.contest;

import java.util.ArrayList;

public class WeeklyContest469 {
    public static void main(String[] args) {
        WeeklyContest469 wc = new WeeklyContest469();
        int[] nums = {3,1,2};
        wc.splitArray(nums);
    }
    public int[] decimalRepresentation(int n) {
        ArrayList<Integer> list = new ArrayList<>();
        int place = 1;
        while (n > 0) {
            if((n % 10)*place > 0){
                list.addFirst((n % 10) * place);
            }
            place = place * 10;
            n /= 10;
        }
        return list.stream().mapToInt(i -> i).toArray();
    }
    public long splitArray(int[] nums) {
        if(!checkSplitability(nums)) {
            return -1;
        }
        long[] leftSum = new long[nums.length];
        long[] rightSum = new long[nums.length];
        int size = nums.length - 1;
        long minDiffirence = Integer.MAX_VALUE;
        for (int i = 0; i <= size; i++) {
            if(i == 0){
                leftSum[i] = nums[i];
                rightSum[size - i] = nums[size - i];
            } else {
                leftSum[i] = leftSum[i - 1] + nums[i];
                rightSum[size - i] = rightSum[size - i + 1] + nums[size - i];
            }
        }

        for (int i = 0; i < size; i++) {
            minDiffirence = Math.min(minDiffirence, Math.abs(leftSum[i] - rightSum[i+1]));
        }
        return minDiffirence;
    }

    boolean checkSplitability(int[] nums) {
        int left = 1;
        int right = nums.length - 2;
        while (left <= right) {
           if(nums[left] >= nums[left - 1]){
               left++;
           } else if(nums[right] >= nums[right + 1]){
               right--;
           } else {
               return false;
           }
        }
        return true;
    }
}
