package com.java.problems.leetcode.hard;

import java.util.*;

public class MaximizeDistanceBetweenPointsOnASquare3464 {
    public static void main(String[] args) {
        MaximizeDistanceBetweenPointsOnASquare3464 obj = new MaximizeDistanceBetweenPointsOnASquare3464();
        int side = 2;
        //int[][] points = {{0,2},{2,0},{2,2},{0,0}};
        int[][] points = {{0,0},{1,2},{2,0},{2,2},{2,1}};
        int k = 4;
        System.out.println(obj.maxDistance(side, points, k));
    }
    public int maxDistance(int side, int[][] points, int k) {
        int maxDistance = 0;
        TreeMap<Integer, Integer> map = new TreeMap<>();
        ArrayList<Integer> distancesList = new ArrayList<>();
        for (int i = 0; i < points.length; i++) {
            for (int j = i+1; j < points.length; j++) {
                int x1 = points[i][0];
                int y1 = points[i][1];
                int x2 = points[j][0];
                int y2 = points[j][1];
                int distance = Math.abs(x1 - x2) + Math.abs(y1 - y2);
                map.put(distance, map.getOrDefault(distance, 0) + 1);
                distancesList.add(distance);
            }
        }
        Collections.sort(distancesList);
        return distancesList.get(k-1);
    }
}
