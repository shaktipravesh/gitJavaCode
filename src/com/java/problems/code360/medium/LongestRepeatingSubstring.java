package com.java.problems.code360.medium;

public class LongestRepeatingSubstring {
    public static int longestRepeatingSubstring(String str, int k) {
        int[] count = new int[26];
        int maxFreq = 0;
        int left = 0;
        int maxLength = 0;

        for (int right = 0; right < str.length(); right++) {
            count[str.charAt(right) - 'A']++;
            maxFreq = Math.max(maxFreq, count[str.charAt(right) - 'A']);

            // if the number of characters to change > k, shrink the window
            if ((right - left + 1) - maxFreq > k) {
                count[str.charAt(left) - 'A']--;
                left++;
            }

            maxLength = Math.max(maxLength, right - left + 1);
        }

        return maxLength;
    }
}
