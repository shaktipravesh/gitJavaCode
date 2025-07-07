package com.java.problems.leetcode.medium;

import java.util.Arrays;
import java.util.HashSet;

import static java.lang.System.*;

public class MaximumEventsAttended1353 {
    public static void main(String[] args) {
        int[][] events = {{1,2}, {2,3}, {3,4}};
        MaximumEventsAttended1353 obj = new MaximumEventsAttended1353();
        out.println(obj.maxEvents(events));
    }
    public int maxEvents(int[][] events) {
        int eventAttended = 0;
        Arrays.sort(events, (o1, o2) -> o1[1] == o2[1] ? Integer.compare(o1[0], o2[0])
                : Integer.compare(o1[1], o2[1]));

        HashSet<Integer> daysAttendedSet = new HashSet<>();
        int prevStart = 0;
        int daysBooked = 0;
        for (int[] event : events) {
            int start = event[0];
            int end = event[1];
            if(prevStart == start) {
                start = daysBooked + 1;
            } else {
                prevStart = start;
            }
            while (start <= end) {
                if (!daysAttendedSet.contains(start)) {
                    daysAttendedSet.add(start);
                    daysBooked = start;
                    eventAttended++;
                    break;
                }
                start++;
            }
        }
        return eventAttended;
    }
}
