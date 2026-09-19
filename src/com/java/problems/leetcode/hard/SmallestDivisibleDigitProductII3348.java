package com.java.problems.leetcode.hard;

import java.util.ArrayList;
import java.util.HashMap;

public class SmallestDivisibleDigitProductII3348 {
    public String smallestNumber(String num, long t) {
        int[] digitsTFrequency = new int[10];
        char[] numChars = num.toCharArray();
        HashMap<Integer, Integer> numFrequency = new HashMap<>();
        ArrayList<HashMap<Integer, Integer>> numDigitFrequency = new ArrayList<>();
        long devisor = t;
        for(int i = 9; i > 1; i--) {
            while(devisor/i == 0) {
                digitsTFrequency[i]++;
                devisor = devisor/i;
            }
        }
        for(int i = 0; i < numChars.length; i++) {
            int digit = Character.getNumericValue(numChars[i]);
            numFrequency.put(digit, numFrequency.getOrDefault(digit, 0) + 1);
            HashMap<Integer, Integer> ithNumFrequency = new HashMap<>(numFrequency);
            numDigitFrequency.add(ithNumFrequency);
        }
        return "";
    }
}
