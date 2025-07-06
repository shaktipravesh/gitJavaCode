package com.java.problems.leetcode.medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

import static java.lang.System.*;

public class MergeIntervals56 {
    public static void main(String[] args) {
        int[][] intervals = {{1,3}, {8,10}, {2,6}, {15,18}};
        int[][] intervals01 = {{2,3}, {4,5}, {6,7}, {8,9}, {1,10}};
        MergeIntervals56 mergeIntervals56 = new MergeIntervals56();
        out.println(Arrays.deepToString(mergeIntervals56.merge(intervals)));
        out.println(Arrays.deepToString(mergeIntervals56.merge(intervals01)));
    }
    public int[][] merge(int[][] intervals) {
        if (intervals == null || intervals.length == 0) return new int[0][0];
        Arrays.sort(intervals, Comparator.comparingInt(a -> a[0]));
        List<int[]> intervalList = new ArrayList<>();
        intervalList.add(intervals[0]);
        for(int i = 1; i < intervals.length; i++){
            int[] interval = intervalList.getLast();
            if(interval[1] >= intervals[i][0]){
                interval[0] = Math.min(interval[0], intervals[i][0]);
                interval[1] = Math.max(interval[1], intervals[i][1]);
                intervalList.set(intervalList.size()-1, interval);
            } else {
                intervalList.add(intervals[i]);
            }
        }

        return intervalList.toArray(new int[intervalList.size()][]);
    }
}
