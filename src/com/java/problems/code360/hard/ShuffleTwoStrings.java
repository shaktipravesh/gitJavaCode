package com.java.problems.code360.hard;

public class ShuffleTwoStrings {
    public static void main(String[] args) {
        //aabd abdc aabdabcd
        String a = "abdd";
        String b = "fef";
        String c = "abfddef";
        System.out.println(isInterleave(a, b, c));
    }

    public static boolean isInterleave(String A, String B, String C) {
        int n = A.length(), m = B.length(), k = C.length();

        if (n + m != k) return false; // If lengths don't match, return false

        boolean[][] dp = new boolean[n + 1][m + 1];

        // Fill DP table
        for (int i = 0; i <= n; i++) {
            for (int j = 0; j <= m; j++) {
                if (i == 0 && j == 0) {
                    dp[i][j] = true;
                } else if (i == 0) {
                    dp[i][j] = dp[i][j - 1] && B.charAt(j - 1) == C.charAt(i + j - 1);
                } else if (j == 0) {
                    dp[i][j] = dp[i - 1][j] && A.charAt(i - 1) == C.charAt(i + j - 1);
                } else {
                    dp[i][j] = (dp[i - 1][j] && A.charAt(i - 1) == C.charAt(i + j - 1)) ||
                            (dp[i][j - 1] && B.charAt(j - 1) == C.charAt(i + j - 1));
                }
            }
        }

        return dp[n][m];
    }
    public static boolean isInterleaveBruteForce(String a, String b, String c) {
        int i = 0;
        int j = 0;
        int k = 0;

        for(; k < c.length(); k++) {
            if(i < a.length() && a.charAt(i) == c.charAt(k)) {
                i++;
            } else if(j < b.length() && b.charAt(j) == c.charAt(k)) {
                j++;
            } else {
                return false;
            }
        }
        if(i < a.length() || j < b.length() || k < c.length()) {
            return false;
        }
        return true;
    }
}
