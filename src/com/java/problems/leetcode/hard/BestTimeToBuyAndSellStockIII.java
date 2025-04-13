package com.java.problems.leetcode.hard;

import java.util.logging.Logger;

public class BestTimeToBuyAndSellStockIII {
    static Logger log = Logger.getLogger("BestTimeToBuyAndSellStockIII");
    public static void main(String[] args) {
        BestTimeToBuyAndSellStockIII obj = new BestTimeToBuyAndSellStockIII();
        int[] prices1 = {3,3,5,0,0,3,1,4};
        int[] prices2 = {1,2,3,4,5};
        int[] prices3 = {7,6,4,3,1};

        log.info("" + obj.maxProfit(prices1)); // Output: 6
        log.info("" + obj.maxProfit(prices2)); // Output: 4
        log.info("" + obj.maxProfit(prices3)); // Output: 0
    }
    public int maxProfit(int[] prices) {
        if (prices == null || prices.length == 0) return 0;

        int buy1 = Integer.MIN_VALUE;
        int buy2 = Integer.MIN_VALUE;
        int sell1 = 0;
        int sell2 = 0;

        for (int price : prices) {
            buy1 = Math.max(buy1, -price); // First buy (minimize cost)
            sell1 = Math.max(sell1, buy1 + price); // First sell (maximize profit)
            buy2 = Math.max(buy2, sell1 - price); // Second buy (use first sell profit)
            sell2 = Math.max(sell2, buy2 + price); // Second sell (maximize second transaction profit)
        }
        return sell2;
    }
}
