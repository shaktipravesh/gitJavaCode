package com.java.problems.leetcode.contest;

public class weeklyContest443 {
    public int[] minCosts(int[] cost) {
        int[] res = new int[cost.length];
        res[0] = cost[0];
        for (int i = 1; i < cost.length; i++) {
            res[i] = Math.min(res[i-1], cost[i]);
        }
        return res;
    }

    public int longestPalindrome(String s, String t) {
        int m = t.length();
        int n = s.length();
        int longest = 0;
        for(int i = 0; i <= n; i++){
            for(int j = 0; j < m; j++){
                String res = s.substring(0,n-i) + t.substring(j,m);
                if(longest < res.length()) {
                    longest = Math.max(longest, longestPalindrome(res));
                } else {
                    break;
                }
            }
            if(longest >= n-i + m) {
                break;
            }
        }
        return longest;
    }

    public int longestPalindrome(String s) {
        if (s == null || s.isEmpty()) return 0;

        // Preprocess: Convert "abc" -> "^#a#b#c#$"
        StringBuilder t = new StringBuilder("^");
        for (char c : s.toCharArray()) {
            t.append("#").append(c);
        }
        t.append("#$");

        int n = t.length();
        int[] p = new int[n]; // Radius array
        int center = 0, right = 0, maxLength = 0, start = 0;

        for (int i = 1; i < n - 1; i++) {
            int mirror = 2 * center - i;
            if (i < right) {
                p[i] = Math.min(right - i, p[mirror]);
            }

            // Expand around center
            while (t.charAt(i + p[i] + 1) == t.charAt(i - p[i] - 1)) {
                p[i]++;
            }

            // Update center and right boundary
            if (i + p[i] > right) {
                center = i;
                right = i + p[i];
            }

            // Keep track of longest palindrome
            if (p[i] > maxLength) {
                maxLength = p[i];
                start = (i - maxLength) / 2;
            }
        }
        return s.substring(start, start + maxLength).length();
    }

    public static void main(String[] args) {
        String s = "b";
        String t = "aaaa";
        weeklyContest443 w = new weeklyContest443();
        System.out.println(w.longestPalindrome(s, t));
    }

}
