package com.java.problems.code360.hard;

import java.util.HashMap;

public class PalindromeCount {

    public static int palinCount(String str) {
        int n = str.length();
        int res = 0;
        int mask = 0;
        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(0, 1); // Base case: empty prefix

        for (int i = 0; i < n; i++) {
            int c = str.charAt(i) - 'a';
            mask ^= (1 << c); // Toggle the bit for this character

            // Count occurrences of substrings with the same mask
            res += map.getOrDefault(mask, 0);

            // Check for substrings differing by one bit (single odd character allowed)
            for (int j = 0; j < 26; j++) {
                res += map.getOrDefault(mask ^ (1 << j), 0);
            }

            // Update the map with the current mask
            map.put(mask, map.getOrDefault(mask, 0) + 1);
        }

        return res;
    }

    public static void main(String[] args) {
        System.out.println(palinCount("beena")); // Output: 6
    }
}
