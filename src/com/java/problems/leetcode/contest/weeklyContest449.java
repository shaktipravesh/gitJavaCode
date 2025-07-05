package com.java.problems.leetcode.contest;

import java.util.*;

public class weeklyContest449 {
    public int minDeletion(String s, int k) {
        Map<Character, Integer> freqMap = new HashMap<>();

        // Count frequency of each character
        for (char c : s.toCharArray()) {
            freqMap.put(c, freqMap.getOrDefault(c, 0) + 1);
        }

        // If already <= k distinct characters, no deletions needed
        if (freqMap.size() <= k) {
            return 0;
        }

        // Get frequencies in ascending order
        List<Integer> frequencies = new ArrayList<>(freqMap.values());
        Collections.sort(frequencies);

        int deletions = 0;
        int toRemove = freqMap.size() - k;

        // Remove lowest frequency characters
        for (int i = 0; i < toRemove; i++) {
            deletions += frequencies.get(i);
        }

        return deletions;
    }
}
