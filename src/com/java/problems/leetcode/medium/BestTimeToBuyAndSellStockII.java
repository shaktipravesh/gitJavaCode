package com.java.problems.leetcode.medium;

public class BestTimeToBuyAndSellStockII {
    public static void main(String[] args) {
        int[] prices = {7,1,5,3,6,4};
        System.out.println(maxProfit(prices));
    }
    public static int maxProfit(int[] prices) {
        int maxProfit = 0;
        int currentProfit = 0;
        int start = 0;
        int current = 0;
        for(; current < prices.length; current++) {
            if((prices[current] - prices[start]) < currentProfit) {
                maxProfit += currentProfit;
                start = current;
                currentProfit = 0;
            } else {
                currentProfit = prices[current] - prices[start];
            }
        }
        maxProfit += currentProfit;
        return maxProfit;
    }
}
