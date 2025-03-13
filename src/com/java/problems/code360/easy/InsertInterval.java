package com.java.problems.code360.easy;

import java.util.ArrayList;
import java.util.Arrays;

public class InsertInterval {
    public static void main(String[] args) {
        ArrayList<ArrayList<Integer>> intervals = new ArrayList<>();

        // Add some intervals to the list
        intervals.add(new ArrayList<>(Arrays.asList(2, 3)));
        intervals.add(new ArrayList<>(Arrays.asList(5, 8)));
        ArrayList<Integer> newInterval = new ArrayList<>(Arrays.asList(1, 9));
        System.out.println(insertInterval(intervals, newInterval));

    }
    public static ArrayList<ArrayList<Integer>> insertInterval(ArrayList<ArrayList<Integer>> intervals, ArrayList<Integer> newInterval)
    {
        boolean isAdded = false;
        intervals.sort((interval1,interval2) -> interval1.get(1)-interval2.get(1));
        int index = 0;
        for(index = 0; index < intervals.size(); index++) {
            ArrayList<Integer> interval = intervals.get(index);
            if(interval.get(1) >= newInterval.get(0)) {
                intervals.add(index, newInterval);
                isAdded = true;
                break;
            }
        }
        if(!isAdded) {
            intervals.add(newInterval);
            return intervals;
        }
        index++;
        while(index < intervals.size() && newInterval.get(1) >= intervals.get(index).get(0)) {
            Integer end = intervals.get(index).get(1);
            Integer start = intervals.get(index).get(0);
            if(end > newInterval.get(1)) {
                newInterval.remove(1);
                newInterval.add(end);
            }
            if(start < newInterval.get(0)) {
                newInterval.remove(0);
                newInterval.add(0, start);
            }
            intervals.remove(index);
        }
        return intervals;
    }
}
