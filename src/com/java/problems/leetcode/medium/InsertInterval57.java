package com.java.problems.leetcode.medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

import static java.lang.System.out;

public class InsertInterval57 {
    public static void main(String[] args) {
        int[][] intervals = {{1, 3}, {6, 9}};
        int[] newInterval = {2, 5};
        InsertInterval57 mergeIntervals57 = new InsertInterval57();
        out.println(Arrays.deepToString(mergeIntervals57.insert(intervals, newInterval)));
    }

    public int[][] insert(int[][] intervals, int[] newInterval) {
        List<int[]> inputIntervals = new ArrayList<>(List.of(intervals));
        inputIntervals.add(newInterval);
        inputIntervals.sort(Comparator.comparingInt(a -> a[0]));

        Arrays.sort(intervals, Comparator.comparingInt(a -> a[0]));
        List<int[]> intervalList = new ArrayList<>();
        intervalList.add(inputIntervals.getFirst());
        for(int i = 1; i < inputIntervals.size(); i++){
            int[] interval = intervalList.getLast();
            int[] currentInterval = inputIntervals.get(i);
            if(interval[1] >= currentInterval[0]){
                interval[0] = Math.min(interval[0], currentInterval[0]);
                interval[1] = Math.max(interval[1], currentInterval[1]);
                intervalList.set(intervalList.size()-1, interval);
            } else {
                intervalList.add(currentInterval);
            }
        }

        return intervalList.toArray(new int[intervalList.size()][]);
    }
}
