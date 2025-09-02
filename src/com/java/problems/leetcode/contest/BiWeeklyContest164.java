package com.java.problems.leetcode.contest;

import java.util.Arrays;
import java.util.HashMap;

public class BiWeeklyContest164 {
    public static void main(String[] args) {
        BiWeeklyContest164 bw = new BiWeeklyContest164();
//        int n = 1553322;
//        bw.getLeastFrequentDigit(n);
        String[] cards = {"aa","ab","ba","ac"};
        char x = 'a';
        bw.score(cards, x);
    }
    int getLeastFrequentDigit(int n) {
        int[] freq = new int[10];
        Arrays.fill(freq, Integer.MAX_VALUE);
        while(n > 0) {
            freq[n%10] = freq[n%10] == Integer.MAX_VALUE ?  1: freq[n%10] + 1;
            n/=10;
        }
        int res = 0;
        for(int i=0; i<freq.length; i++) {
            if(freq[i] < freq[res]) {
                res = i;
            }
        }
        return res;
    }
    public int score(String[] cards, char x) {
        int[][] freq = new int[3][26];
        for (String card : cards) {
            if (card.charAt(0) == x && card.charAt(1) == x) {
                freq[0][0]++;
            } else if (card.charAt(0) == x && card.charAt(1) != x) {
                freq[1][card.charAt(1)-'a']++;
            } else if (card.charAt(0) != x && card.charAt(1) == x) {
                freq[2][card.charAt(0)-'a']++;
            }
        }
        int res = 0;
        int countFirst = 0;
        int countSecond = 0;


        for(int i=0; i<freq[0].length; i++) {
            res += Math.min(countFirst, freq[1][i]);
            countFirst = Math.max(countFirst, freq[1][i]) - Math.min(countFirst, freq[1][i]);
        }
        int firstTotal = res;
        for(int i=0; i<freq[0].length; i++) {
            res += Math.min(countSecond, freq[2][i]);
            countSecond = Math.max(countSecond, freq[2][i]) - Math.min(countSecond, freq[2][i]);
        }
        int secondTotal = res - firstTotal;
        if(freq[0][0] > 0 && countFirst > 0) {
            res += Math.min(countFirst, freq[0][0]);
            freq[0][0] = countFirst > freq[0][0] ? 0 : freq[0][0]-countFirst;
        }
        if(freq[0][0] > 0 && countSecond > 0) {
            res += Math.min(countSecond, freq[0][0]);
            freq[0][0] = countSecond > freq[0][0] ? 0 : freq[0][0]-countSecond;
        }

        res += Math.min(freq[0][0], firstTotal + secondTotal);
        return res;


    }
}
