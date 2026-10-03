package com.java.problems.leetcode;

public class LongestValidParentheses32 {
    public static void main(String[] args) {
        LongestValidParentheses32 obj = new LongestValidParentheses32();
        String str = "()()))))()()(";
        System.out.println(obj.longestValidParentheses(str));
    }
    public int longestValidParentheses(String s) {
        char[] chars = s.toCharArray();
        int[] dp = new int[chars.length];
        int max = 0;
        for (int i = 0; i < chars.length; i++) {
            if (chars[i] == ')') {
                int prevIndex = i - 1;
                if(i > 0 && dp[i-1] > 0) {
                    prevIndex -= dp[i-1];
                }
                if(prevIndex >= 0 && chars[prevIndex] == '(') {
                    dp[i] = i - prevIndex + 1;
                }
                if(prevIndex > 0 && dp[i] > 0 && dp[prevIndex-1] > 0) {
                    dp[i] += dp[prevIndex-1];
                }
                max = Math.max(max, dp[i]);
            }
        }
        return max;
    }
}
