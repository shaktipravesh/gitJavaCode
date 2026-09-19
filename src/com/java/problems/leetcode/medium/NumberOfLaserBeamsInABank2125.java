package com.java.problems.leetcode.medium;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedHashSet;

public class NumberOfLaserBeamsInABank2125 {
    public int numberOfBeams(String[] bank) {
        int numberOfBeams = 0;
        int prevDeviceCt = 0;
        int nextDeviceCt = 0;
        for (String s : bank) {
            nextDeviceCt = 0;
            for (int i = 0; i < s.length(); i++) {
                if (s.charAt(i) == '1') {
                    nextDeviceCt++;
                }
            }
            if (nextDeviceCt > 0) {
                numberOfBeams += prevDeviceCt * nextDeviceCt;
                prevDeviceCt = nextDeviceCt;
            }
        }
        return numberOfBeams;
    }
    public int[] plusOne(int[] digits) {
        ArrayList<Integer> list = new ArrayList<>();
        int remainder = 0;
        for (int i = digits.length - 1; i >= 0; i--) {
            list.addFirst((digits[i] + remainder) % 10);
            remainder = (remainder + digits[i]) / 10;
        }
        if(remainder > 0) {
            list.addFirst(remainder);
        }
        int[] result = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            result[i] = list.get(i);
        }
        return result;
    }

    public int repeatedNTimes(int[] nums) {
        HashSet<Integer> numSet = new HashSet<>();
        int repeatedNum = -1;
        for (int num : nums) {
            if(numSet.contains(num)) {
                repeatedNum = num;
                break;
            }
            numSet.add(num);
        }
        return repeatedNum;
    }

    public int numOfWays(int n) {
        int MOD = 1000000007;
        long ryrWays = 6;
        long rybWays = 6;
        long numOfWays = 12;
        for(int i = 1; i < n; i++) {
            long newRYRWays = ryrWays*3 + rybWays*3;
            long newRYBWays = ryrWays*2 + rybWays*1;
            ryrWays = newRYRWays % MOD;
            rybWays = newRYBWays % MOD;
        }
        numOfWays = (int)((ryrWays + rybWays) % MOD);
        return (int)numOfWays;
    }
}
