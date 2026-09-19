package com.java.problems.leetcode.hard;

import java.util.*;

public class MeetingRoomsIII2402 {
    public static void main(String[] args) {
        MeetingRoomsIII2402 mr = new MeetingRoomsIII2402();
        int n = 4;
        int[][] meetings = {{18,19}, {3,12}, {17,19}, {2,13}, {7,10}};
        System.out.println(mr.mostBooked(n , meetings));
    }
    public int mostBooked(int n, int[][] meetings) {
        PriorityQueue<int[]> meetingEndTimeRoom = new PriorityQueue<>(Comparator.<int[], Integer>comparing(arr -> arr[1])
                .thenComparing(arr -> arr[0]));
        PriorityQueue<int[]> meetingsPQ = new PriorityQueue<>(Comparator.<int[], Integer>comparing(arr -> arr[0]));

        TreeMap<Integer, Integer> meetingRoomCount = new TreeMap<>();
        for(int i = 0; i < n; i++) {
            meetingEndTimeRoom.add(new int[]{0, i});
            meetingRoomCount.put(i, 0);
        }
        Arrays.stream(meetings).map(meeting -> new int[]{meeting[0], meeting[1]}).forEach(meetingsPQ::add);
        while(!meetingsPQ.isEmpty()) {
            int[] meeting = meetingsPQ.poll();
            int start = meeting[0];
            int end = meeting[1];
            PriorityQueue<int[]> meetingsRoomOptionPQ = new PriorityQueue<>(Comparator.<int[], Integer>comparing(arr -> arr[0]));
            while(!meetingsRoomOptionPQ.isEmpty()
                    && (meetingsRoomOptionPQ.peek()[1] < end || meetingsRoomOptionPQ.isEmpty())) {
                meetingsRoomOptionPQ.add(meetingsRoomOptionPQ.poll());
            }
            int[] poll = meetingsRoomOptionPQ.poll();
            int meetingEndTime;
            if (poll == null) {
                meetingEndTime = end;
            } else {
                if (poll[0] < start) meetingEndTime = end;
                else meetingEndTime = poll[0] + end - start;
            }
            meetingEndTimeRoom.add(new int[]{meetingEndTime, poll[1]});
            meetingRoomCount.put(poll[1], meetingRoomCount.getOrDefault(poll[1], 0) + 1);
            meetingsRoomOptionPQ.addAll(meetingsRoomOptionPQ);
        }
        int maxMeetingRoom  = 0;
        int maxMeeting = 0;
        for(Map.Entry<Integer, Integer> entry : meetingRoomCount.entrySet()) {
            if(maxMeeting < entry.getValue()) {
                maxMeeting = entry.getValue();
                maxMeetingRoom = entry.getKey();
            }
        }
        return maxMeetingRoom;
    }

    public void PriorityQueueImple() {
        // Example 2D array
        int[][] array2D = {{1, 5}, {2, 3}, {1, 2}, {2, 1}, {3, 4}};

        // Create a PriorityQueue with a custom comparator
        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.<int[], Integer>comparing(arr -> arr[0])
                .thenComparing(arr -> arr[1]));

        // Add elements to the PriorityQueue
        for (int[] element : array2D) {
            pq.offer(element);
        }

        // Print the sorted elements
        while (!pq.isEmpty()) {
            int[] element = pq.poll();
            System.out.println("[" + element[0] + ", " + element[1] + "]");
        }
    }
}
