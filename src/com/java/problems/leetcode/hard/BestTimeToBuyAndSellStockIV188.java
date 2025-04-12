package com.java.problems.leetcode.hard;

import java.util.Arrays;
import java.util.logging.Logger;

public class BestTimeToBuyAndSellStockIV188 {
    Logger logger = Logger.getLogger("BestTimeToBuyAndSellStockIV188");
    public static void main(String[] args) {
        int k = 5;
        int[] prices = {3,4,1};
        System.out.println(maxProfit(k, prices));
    }

    public static int maxProfit(int k, int[] prices) {
        int[] buy = new int[k];
        int[] sell = new int[k];
        Arrays.fill(buy, Integer.MIN_VALUE);
        Arrays.fill(sell, 0);

        for (int price : prices) {
            buy[0] = Math.max(buy[0], -price);
            sell[0] = Math.max(sell[0], price + buy[0]);
            for (int j = 1; j < k; j++) {
                buy[j] = Math.max(buy[j], sell[j - 1] - price);
                sell[j] = Math.max(sell[j], price + buy[j]);
            }
        }
        return sell[k-1];
    }
}
