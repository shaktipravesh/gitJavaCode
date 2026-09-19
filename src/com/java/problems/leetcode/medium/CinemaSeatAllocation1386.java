package com.java.problems.leetcode.medium;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashSet;

public class CinemaSeatAllocation1386 {
    public static void main(String[] args) {
        CinemaSeatAllocation1386 c = new CinemaSeatAllocation1386();
//        int n = 2;
//        int[][] reservedSeats = {{1,6}, {1,8}, {1,3}, {2,3}, {1,10},{1,2}, {1,5}, {2,2}, {2,4}, {2,10}, {1,7}, {2,5}};
//        int n = 4;
//        int[][] reservedSeats = {{1,2}, {1,3}, {1,8}, {2,6}, {3,1}, {3,10}};
        int n = 5;
        int[][] reservedSeats = {{4,7},{4,1},{3,1},{5,9},{4,4},{3,7},{1,3},{5,5},{1,6},{1,8},{3,9},{2,9},{1,4},{1,9},{1,10}};
        System.out.println(c.maxNumberOfFamilies(n, reservedSeats));
    }
    public int maxNumberOfFamilies(int n, int[][] reservedSeats) {
        int maxNumberOfFamilies = 0;
        Arrays.sort(reservedSeats, (x, y) -> {
            if (x[0] != y[0]) {
                return Integer.compare(x[0], y[0]);
            }
            return Integer.compare(x[1], y[1]);
        });
        HashSet<Integer> rowUtilised = new HashSet<>();
        int prevRow = 0;
        int firstSet = 0;
        int secondSet = 0;
        int thirdSet = 0;
        for (int i = 0; i < reservedSeats.length; i++) {
            int[] reservedSeat = reservedSeats[i];
            if(prevRow != reservedSeat[0]) {
                if(firstSet == 1 || thirdSet == 1) {
                    secondSet = 0;
                }
                maxNumberOfFamilies += firstSet + secondSet + thirdSet;
                prevRow = reservedSeat[0];
                rowUtilised.add(reservedSeat[0]);
                firstSet = 1;
                secondSet = 1;
                thirdSet = 1;
            }
            if(reservedSeat[1] > 1 && reservedSeat[1] < 6) {
                firstSet = 0;
            }
            if((reservedSeat[1] > 3 && reservedSeat[1] < 8)) {
                secondSet = 0;
            }
            if((reservedSeat[1] > 5 && reservedSeat[1] < 10)) {
                thirdSet = 0;
            }
        }
        if(firstSet == 1 || thirdSet == 1) {
            secondSet = 0;
        }
        maxNumberOfFamilies +=  firstSet + secondSet + thirdSet;;
        maxNumberOfFamilies += (n-rowUtilised.size()) * 2;
        return maxNumberOfFamilies;
    }
}
