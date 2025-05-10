package com.java.problems.leetcode.contest;

import java.util.ArrayList;
import java.util.List;

public class weeklyContest444 {
    public static void main(String[] args) {
        int[] nums = {1, 2, 2};
        weeklyContest444 obj = new weeklyContest444();
        System.out.println(obj.minimumPairRemoval(nums));
    }
    public int minimumPairRemoval(int[] nums) {
        int size = nums.length;
        int operationCt = 0;
        int curr = nums[0];
        List<Integer> list = new ArrayList<>();
        list.add(nums[0]);
        for(int i = 1; i < size; ) {
            int cur = 0;
            while (i < size && cur < list.getLast()) {
                cur += nums[i++];
                operationCt++;
            }
            if(cur >= list.getLast()) {
                operationCt--;
            }
            list.add(cur);
        }
        return operationCt;
    }
}
