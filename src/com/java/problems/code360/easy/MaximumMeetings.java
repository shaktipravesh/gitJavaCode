package com.java.problems.code360.easy;

import java.util.Arrays;
import java.util.Comparator;

public class MaximumMeetings {
    public static void main(String[] args) {
        int[] start = {0, 7, 1, 4, 8};
        int[] end = {2, 9, 5, 9, 10};
        maximumMeetings(start, end);

    }

    public static int maximumMeetings(int []start, int []end) {
        int[][] meetings = new int[start.length][2];
        int meetingCount = 1;
        if(start.length <2) {
            return start.length;
        }
        for(int i = 0; i < start.length; i++) {
            meetings[i][0] = start[i];
            meetings[i][1] = end[i];
        }
        Arrays.sort(meetings, Comparator.comparingInt(a->a[1]));
        for(int i = 1, selectedMeetingIndex = 0; i < meetings.length; i++) {
            if(meetings[i][0] > meetings[selectedMeetingIndex][1]) {
                selectedMeetingIndex = i;
                meetingCount++;
            }
        }
        return meetingCount;
    }
}
