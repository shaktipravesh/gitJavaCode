package com.java.problems.leetcode.easy;

public class MaximumLengthSubstringWithTwoOccurrences3090 {
    public int maximumLengthSubstring(String s) {
        int maxLength = 0;
        int start = 0;
        int[] charCount = new int[26];
        for (int end = 0; end < s.length(); end++) {
            charCount[s.charAt(end) - 'a']++;
            while (charCount[s.charAt(end) - 'a'] > 2) {
                charCount[s.charAt(start++) - 'a']--;
            }
            maxLength = Math.max(maxLength, end - start + 1);
        }
        return maxLength;
    }
}
