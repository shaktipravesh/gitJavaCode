package com.java.problems.leetcode.hard;

import java.util.Arrays;
import java.util.HashSet;

public class KthSmallestAmountWithSingleDenominationCombination3116 {
    public static void main(String[] args) {
        KthSmallestAmountWithSingleDenominationCombination3116 kTh = new KthSmallestAmountWithSingleDenominationCombination3116();
        int[] coins = {2,25,17,19,3,13,15,14,1,4};
        int k = 20368;
        System.out.println(kTh.findKthSmallest(coins, k));

    }
    public long findKthSmallest(int[] coins, int k) {
        int coinsLCM = 1;
        coinsLCM = getLCM(coins);
        HashSet<Integer> denominationSet = new HashSet<>();
        for(int i = 0; i < coins.length; i++) {
            int coin = coins[i];
            for (int j = 1; coin*j <= coinsLCM; j++) {
                denominationSet.add(coin*j);
            }
        }
        int[] denominationArray = new int[denominationSet.size()];
        int i = 0;
        for (int deomination : denominationSet) {
            denominationArray[i++] = deomination;
        }
        Arrays.sort(denominationArray);
        int index = k % denominationArray.length;
        long quotient = k / denominationArray.length;
        int indexValue = index > 0 ? denominationArray[index-1]:0;
        return quotient*denominationArray[denominationArray.length-1] + indexValue;
    }

    private int getLCM(int[] coins) {
        int lcm = coins[0];
        for (int i = 1; i < coins.length; i++) {
            int gcd = getGCD(lcm, coins[i]);
            lcm = (lcm * coins[i])/gcd;
        }
        return lcm;
    }

    public static int getGCD(int x, int y) {
        if(y == 0) return x;
        return getGCD(y, x % y);
    }
}
