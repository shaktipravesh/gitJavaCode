package com.java.problems.leetcode.easy;

import java.util.TreeSet;

import static java.lang.System.*;

public class FindLuckyIntegerInAnArray1394 {
    public static void main(String[] args) {
        int[] arr = {2,2,3,4};
        FindLuckyIntegerInAnArray1394 luckyIntegerInAnArray1394 = new FindLuckyIntegerInAnArray1394();
        out.println(luckyIntegerInAnArray1394.findLucky(arr));
    }
    public int findLucky(int[] arr) {
        int maxLucky = 0;
        TreeSet<Integer> set = new TreeSet<>();
        int[] numFrequency = new int[501];
        for (int j : arr) {
            numFrequency[j]++;
            set.add(j);
        }
        for (int num : set) {
            if (numFrequency[num] == num) {
                maxLucky = num;
            }
        }
        return maxLucky;
    }
}
