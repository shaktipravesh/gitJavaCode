package com.java.problems.leetcode;

import java.util.*;

public class FindTheLongestSubstringContainingVowelsInEvenCounts {

    public int findTheLongestSubstring(String s) {
        Map<Integer, Integer> map = new HashMap<>();
        Set<Character> vowels = new HashSet<>(List.of('a', 'e', 'i', 'o', 'u'));
        int mask = 0;
        int maxLength = 0;
        int charIndex = 0;
        map.put(mask, -1);
        for(int i = 0; i < s.length(); i++) {
            if(vowels.contains(s.charAt(i))) {
                charIndex = s.charAt(i)-'a';
                mask ^=1<<charIndex;
            }
            if(map.containsKey(mask)) {
                charIndex = map.get(mask);
                maxLength = Math.max(maxLength, i - charIndex);
            } else {
                map.put(mask, i);
            }
        }
        return maxLength;

    }
}
