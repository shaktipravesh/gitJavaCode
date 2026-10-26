package com.java.problems.leetcode.contest;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class WeeklyContest523 {
    List<Long> fibonacci;
    HashSet<Long> fibonacciSet;

    public static void main(String[] args) {
        WeeklyContest523 wc = new WeeklyContest523();
        int n = 16;
        System.out.println(wc.threeFibonacciSum(n));
    }
    public boolean threeFibonacciSum(int n) {
        if(fibonacci == null) {
            fibonacci = new ArrayList<>();
            fibonacciSet = new HashSet<>();
            fibonacci.add(0L);
            fibonacciSet.add(0L);
            fibonacci.add(1L);
            fibonacciSet.add(1L);
            fibonacci.add(1L);
            fibonacciSet.add(1L);
            for(int i = 3; fibonacci.get(i-1) <= 1000000000; i++) {
                fibonacci.add(fibonacci.get(i - 1) + fibonacci.get(i - 2));
                fibonacciSet.add(fibonacci.get(i));
            }
        }
        if(n % 2 == 0 && fibonacciSet.contains(n/2L)) {
            return true;
        }
        else {
            return false;
        }
    }

    public int sumCounts(List<Integer> nums) {
        Set<Integer> distinicNumSet = new HashSet<>();
        int res = 0;
        for (int i = 0; i < nums.size(); i++) {
            distinicNumSet.clear();
            for (int j = i; j < nums.size(); j++) {
                distinicNumSet.add(nums.get(j));
                int d = distinicNumSet.size();
                res += d * d;
            }
        }
        return res;
    }
}
