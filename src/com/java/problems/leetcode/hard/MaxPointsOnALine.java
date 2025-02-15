package com.java.problems.leetcode.hard;

import java.util.HashMap;

public class MaxPointsOnALine {
    public static void main(String[] args) {
        int[][] points = {{1,1},{2,2},{3,3}};
        maxPoints(points);
    }
    public static int maxPoints(int[][] points) {
        if(points == null || points.length <= 2) return points.length;
        int maxPoints = 0;

        for(int i = 0; i < points.length; i++) {
            int localMaxPoints = 0;
            int duplcatePoints = 1;
            HashMap<String, Integer> slopeMap = new HashMap<>();
            for(int j = i+1; j < points.length; j++) {
                if(points[i][0] == points[j][0] && points[i][1] == points[j][1]) {
                    duplcatePoints++;
                    continue;
                }
                String slope = getSlope(points[i], points[j]);
                slopeMap.put(slope, slopeMap.getOrDefault(slope, 0) + 1);
                localMaxPoints = Math.max(localMaxPoints, slopeMap.get(slope));
            }
            maxPoints = Math.max(maxPoints, localMaxPoints+duplcatePoints);
        }
        return maxPoints;

    }

    private static String getSlope(int[] pointI, int[] pointJ) {
        int x = pointI[0] - pointJ[0];
        int y = pointI[1] - pointJ[1];
        int gcd = getGCD(x, y);
        return x/gcd +"/" + y/gcd;
    }

    private static int getGCD(int x, int y) {
        if(y == 0) return x;
        return getGCD(y, x % y);
    }
}
