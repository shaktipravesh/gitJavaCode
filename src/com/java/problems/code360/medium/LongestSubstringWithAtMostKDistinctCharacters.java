package com.java.problems.code360.medium;

import java.util.HashMap;
import java.util.Map;

public class LongestSubstringWithAtMostKDistinctCharacters {
    public static int kDistinctChars(int k, String str) {
        if(str == null || str.isEmpty()) return 0;
        Map<Character, Integer> map = new HashMap<>();
        int longestSubString = 0;
        int left = 0;
        for(int right = 0; right < str.length(); right++) {
            Character c = str.charAt(right);
            map.put(c, map.getOrDefault(c, 0) + 1);
            if(map.size() == k) {
                longestSubString = Math.max(longestSubString, right - left + 1);
            }
            while(map.size() > k) {
                Character c2 = str.charAt(left);
                map.put(c2, map.getOrDefault(c2, 0) - 1);
                if(map.get(c2) == 0) {
                    map.remove(c2);
                }
                left++;
            }
        }
        return longestSubString;
    }
}
