package com.java.problems.leetcode.easy;

import java.util.*;

public class ReverseDegreeOfAString3498 {
    public int reverseDegree(String s) {
        int result = 0;
        char[] chars = s.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            int charVal = 26 - chars[i] - 'a' + 1;
            result += charVal * (i + 1);
        }
        return result;
    }

    public static void main(String[] args) {
        ReverseDegreeOfAString3498 r = new ReverseDegreeOfAString3498();
        int[][] intervals = {{1,2}, {2,3}, {3,4}};
        System.out.println(r.countIntersectingIntervals(intervals));
    }

    public int countIntersectingIntervals(int[][] intervals) {
        int intersecting = 0;
        TreeMap<Integer, Integer> endMapCount = new TreeMap<>();
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        Arrays.sort(intervals, (a, b) -> {
            if(a[0] != b[0]) {
                return a[0] - b[0];
            } else {
                return a[1] - b[1];
            }
        });
        for (int[] interval : intervals) {
            while (!endMapCount.isEmpty() && endMapCount.firstKey() < interval[0]) {
                endMapCount.remove(endMapCount.firstKey());
            }
            while (!pq.isEmpty() && pq.peek() < interval[0]) {
                pq.poll();
            }
            intersecting += pq.size();
            pq.offer(interval[1]);
        }
        return intersecting;
    }
}
