package com.java.problems.code360.hard;

import java.util.*;


public class CarnivalWithFriends {
    public static void main(String[] args) {
        int n = 4;
        int k = 2;
        int[][] rides;
        rides = new int[][]{{2, 12}, {0, 3}, {1, 2}, {2, 4}};
        System.out.println(carnivalRides(n, k, rides));
        System.out.println(carnivalRidesAnother(n, k, rides));

    }
    public static int carnivalRidesAnother(int n, int k, int rides[][]) {
        List<Integer> g = new ArrayList<>();
        Arrays.sort(rides, (a, b) -> (a[1] == b[1] ? a[0] - b[0] : a[1] - b[1]));

        int ans = 0;
        for (int[] ride : rides) {
            int end = ride[1];
            int start = ride[0];
            boolean remove = false;
            for (int i = g.size() - 1; i >= 0; i--) {
                if (g.get(i) <= start) {
                    g.remove(i);
                    g.add(end);
                    ans++;
                    remove = true;
                    break;
                }
            }
            if (!remove && g.size() < k) {
                g.add(end);
                ans++;
            }
        }
        return ans;
    }
    public static int carnivalRides(int n, int k, int rides[][]){
        ArrayList<Rides> ridesList = new ArrayList<>();
        ArrayList<Rides> carnivalRides = new ArrayList<>();
        for (int[] its : rides) {
            Rides ride = new Rides(its[0], its[1]);
            ridesList.add(ride);
        }
        ridesList.sort(Comparator.comparingInt(a -> a.end));
        while(k > 0) {
            carnivalRides.add(ridesList.getFirst());
            for (int i = 1; i < ridesList.size(); i++) {
                if (ridesList.get(i).start >= carnivalRides.getLast().end) {
                    carnivalRides.add(ridesList.get(i));
                }
            }
            ridesList.removeAll(carnivalRides);
            k--;
        }
        return carnivalRides.size();
    }

    static class Rides {
        public int start;
        public int end;
        public Rides(int start, int end) {
            this.start = start;
            this.end = end;
        }
    }
}
