package com.java;

import java.util.HashMap;
import java.util.Map;

public class LongestEvenFrequencySubstring {
    public static int findLongestEvenFrequencySubstring(String s) {
        Map<Integer, Integer> seen = new HashMap<>();
        int bitmask = 0, maxLength = 0;
        seen.put(0, -1); // Initial bitmask for an empty prefix

        for (int i = 0; i < s.length(); i++) {
            int charIndex = s.charAt(i) - 'a'; // Convert char to index (0-25)
            bitmask ^= (1 << charIndex); // Toggle bit for current character

            // If the same bitmask was seen before, update maxLength
            if (seen.containsKey(bitmask)) {
                maxLength = Math.max(maxLength, i - seen.get(bitmask));
            } else {
                seen.put(bitmask, i); // Store first occurrence of this bitmask
            }
            System.out.println(seen);
            System.out.println(Integer.toBinaryString(bitmask));
        }
        return maxLength;
    }

    public static void main(String[] args) {
        String s = "bdaaadadbcbdaaadadbdaa";
        System.out.println("Longest substring with even frequency: " + findLongestEvenFrequencySubstring(s));
    }
}
