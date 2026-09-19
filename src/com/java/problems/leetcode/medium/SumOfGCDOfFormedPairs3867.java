package com.java.problems.leetcode.medium;

import java.util.ArrayList;
import java.util.Arrays;

public class SumOfGCDOfFormedPairs3867 {
    public static void main(String[] args) {
        SumOfGCDOfFormedPairs3867 solution = new SumOfGCDOfFormedPairs3867();
        String s = "bbbab";
        System.out.println(solution.createAllSubString(s));
        int[] nums = {3,6,2,8};
        System.out.println(solution.gcdSum(nums));
    }
    public long gcdSum(int[] nums) {
        int[] prefixGCD = new int[nums.length];
        long sumGcd = 0;
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < nums.length; i++) {
            max = Math.max(max, nums[i]);
            prefixGCD[i] = getGcd(max, nums[i]);
        }
        Arrays.sort(prefixGCD);
        for (int i = 0, j = prefixGCD.length -1; i < j; i++, j--) {
            sumGcd += getGcd(prefixGCD[i], prefixGCD[j]);
        }
        return sumGcd;
    }

    private int getGcd(int a, int b) {
        while (b != 0) {
            int temp = b;
            b = a % b;
            a = temp;
        }
        return a;
    }
    public int createAllSubString(String s) {
        ArrayList<ArrayList<ArrayList<Integer>>> subString = new ArrayList<>();
        ArrayList<ArrayList<Integer>> sub = new ArrayList<>();
        for (int i = 0; i < s.length(); i++) {
            ArrayList<Integer> row = new ArrayList<>();
            row.add(i);
            sub.add(row);
        }
        subString.add(sub);
        while (subString.size() < s.length() ) {
            ArrayList<ArrayList<Integer>> previosSub = subString.get(subString.size() - 1);
            ArrayList<ArrayList<Integer>> currentSub = new ArrayList<>();
            for(int i= 0; i < previosSub.size(); i++) {
                ArrayList<Integer> row = previosSub.get(i);
                for(int j = row.getLast()+1; j < s.length(); j++) {
                    ArrayList<Integer> newRow = new ArrayList<>();
                    newRow.addAll(row);
                    newRow.add(j);
                    currentSub.add(newRow);
                }
            }
            subString.add(currentSub);
        }
        System.out.println(subString);
        return subString.size();
    }
}
