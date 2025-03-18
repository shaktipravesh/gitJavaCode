package com.java.problems.leetcode.hard;

import java.util.HashMap;
import java.util.Map;

public class MinimumWindowSubstring76 {
    public String minWindow(String s, String t) {
        if (s.length() < t.length()) return "";

        // Step 1: Build the frequency map for t
        Map<Character, Integer> targetFreq = new HashMap<>();
        for (char c : t.toCharArray()) {
            targetFreq.put(c, targetFreq.getOrDefault(c, 0) + 1);
        }

        int requiredCount = targetFreq.size(); // Unique characters in t
        int formedCount = 0; // Characters in the current window matching the targetFreq
        Map<Character, Integer> windowFreq = new HashMap<>();

        int left = 0, right = 0;
        int minLength = Integer.MAX_VALUE;
        int start = 0;

        // Step 2: Expand the right pointer
        while (right < s.length()) {
            char c = s.charAt(right);
            windowFreq.put(c, windowFreq.getOrDefault(c, 0) + 1);

            // If the character in window matches the count in target, increase formedCount
            if (targetFreq.containsKey(c) && windowFreq.get(c).equals(targetFreq.get(c))) {
                formedCount++;
            }

            // Step 3: Contract from left while window is valid
            while (formedCount == requiredCount) {
                if (right - left + 1 < minLength) {
                    minLength = right - left + 1;
                    start = left;
                }

                // Remove the left character from the window
                char leftChar = s.charAt(left);
                windowFreq.put(leftChar, windowFreq.get(leftChar) - 1);

                if (targetFreq.containsKey(leftChar) && windowFreq.get(leftChar) < targetFreq.get(leftChar)) {
                    formedCount--; // Lost a valid match, stop contracting
                }
                left++;
            }

            right++;
        }

        return minLength == Integer.MAX_VALUE ? "" : s.substring(start, start + minLength);
    }
}
