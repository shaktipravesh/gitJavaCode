package com.java.problems.leetcode.contest;

import java.util.Map;
import java.util.TreeMap;

public class BiWeeklyContest167 {
    public boolean scoreBalance(String s) {
        int sum = 0;
        int halfSum = 0;
        for (int i = 0; i < s.length(); i++) {
            sum += s.charAt(i) - 'a' + 1;
        }
        if(sum%2 != 0) {
            return false;
        }
        for (int i = 0; i < s.length() && halfSum < sum; i++) {
            halfSum += s.charAt(i) - 'a' + 1;
            if(halfSum == sum/2) {
                return true;
            }
        }
        return false;
    }
}

class ExamTracker {
    TreeMap<Integer, Integer> map;
    public ExamTracker() {
        map = new TreeMap<>();
    }

    public void record(int time, int score) {
        map.put(time, map.getOrDefault(time, 0) + score);
    }

    public long totalScore(int startTime, int endTime) {
        long sum = 0;
        // Get a sub-map containing entries within the specified key range
        // The subMap method returns a view of the portion of this map whose keys range from lowerKey, inclusive, to upperKeyExclusive, exclusive.
        for (Map.Entry<Integer, Integer> entry : map.subMap(startTime, endTime).entrySet()) {
            sum += entry.getValue();
        }
        return sum;
    }
}