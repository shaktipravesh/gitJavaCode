package com.java.problems.leetcode.easy;
import static java.lang.System.*;

public class BestTimeToBuyAndSellStock121 {
    public static void main(String[] args) {
        int[] prices = {1, 2, 3, 5};
        out.println(maxProfit(prices));
    }
    public static int maxProfit(int[] prices) {
        int maxProfit = Integer.MIN_VALUE;
        int buy = Integer.MAX_VALUE;
        for (int price : prices) {
            if (buy > price) {
                buy = price;
            }
            maxProfit = Math.max(maxProfit, price - buy);
        }
        return maxProfit;
    }
}
