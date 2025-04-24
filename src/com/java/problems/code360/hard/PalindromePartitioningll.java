package com.java.problems.code360.hard;

public class PalindromePartitioningll {
    public static void main(String[] args) {
        System.out.println(palindromePartitioning("aaccb")); // Output: 1
    }
    public static int palindromePartitioning(String str) {
        int n = str.length();
        if (n == 0) return 0;

        // Step 1: Precompute palindrome substrings
        boolean[][] isPalindrome = new boolean[n][n];

        for (int i = 0; i < n; i++) {
            isPalindrome[i][i] = true; // Single character is always a palindrome
        }

        for (int length = 2; length <= n; length++) { // Substring length
            for (int i = 0; i <= n - length; i++) {
                int j = i + length - 1;
                if (str.charAt(i) == str.charAt(j)) {
                    if (length == 2) {
                        isPalindrome[i][j] = true;
                    } else {
                        isPalindrome[i][j] = isPalindrome[i + 1][j - 1];
                    }
                }
            }
        }

        // Step 2: DP to compute min partitions
        int[] dp = new int[n];
        for (int i = 0; i < n; i++) {
            if (isPalindrome[0][i]) {
                dp[i] = 0; // If s[0:i] is already a palindrome, no cuts needed
            } else {
                dp[i] = Integer.MAX_VALUE;
                for (int j = 0; j < i; j++) {
                    if (isPalindrome[j + 1][i]) { // If s[j+1:i] is a palindrome
                        dp[i] = Math.min(dp[i], dp[j] + 1);
                    }
                }
            }
        }

        return dp[n - 1];
    }
}
