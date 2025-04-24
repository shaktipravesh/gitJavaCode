package com.java.problems.code360.hard;

import java.util.HashMap;
import java.util.Map;

public class CountTheAP {

    public static void main(String[] args) {
        int[] A = {1, 2, 2, 3, 4};
        System.out.println(countAP(5, A));

    }
    public static int countAP(int n, int[] A) {
        int count = 0;
        Map<Integer, Integer>[] dp = new HashMap[n];
        for(int i = 0; i < n ; i++) {
            dp[i] = new HashMap<>();
            for(int j= 0; j < i; j++) {
                long diff = (long) A[i] - A[j];
                if(diff < Integer.MIN_VALUE || diff > Integer.MAX_VALUE) continue;

                int d = (int) diff;
                int prevCount = dp[j].getOrDefault(d, 0);
                dp[i].put(d, dp[i].getOrDefault(d, 0) + prevCount +1);
                count += prevCount;
            }
        }
        return count;
    }
}
