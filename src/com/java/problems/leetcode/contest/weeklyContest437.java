package com.java.problems.leetcode.contest;

import java.util.Arrays;

public class weeklyContest437 {

    public static void main(String[] args) {
        int[] pizzas = {1,2,3,4,5,6,7,8};
        System.out.println(maxWeight(pizzas));

    }
    public static long maxWeight(int[] pizzas) {
        Arrays.sort(pizzas);
        int numberofPizzas = pizzas.length - 1;
        long maxWeight = 0;
        int evenDays = pizzas.length/8;
        int oddDays = evenDays + (pizzas.length%8)/4;
        for(int i = 0; i < oddDays; i++) {
            maxWeight += pizzas[numberofPizzas-i];
        }
        for(int i = 0; i < evenDays; i++) {
            maxWeight += pizzas[numberofPizzas-oddDays-2*i-1];
        }
        return maxWeight;
    }

    public boolean hasSpecialSubstring(String s, int k) {
        if (s.length() < k) {
            return false;
        }
        if (s.length() == 1 && k == 1) {
            return true;
        }
        boolean hasSubstring = false;
        int subStringLength = 1;
        for (int i = 1; i < s.length(); i++) {
            if(s.charAt(i) == s.charAt(i - 1)) {
                subStringLength++;
            } else {
                if(subStringLength == k) {
                    hasSubstring = true;
                    break;
                }
                subStringLength = 1;
            }
        }
        if(subStringLength == k) {
            hasSubstring = true;
        }
        return hasSubstring;
    }
}
