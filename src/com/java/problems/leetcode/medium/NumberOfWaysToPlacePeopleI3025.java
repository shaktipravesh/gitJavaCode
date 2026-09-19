package com.java.problems.leetcode.medium;

public class NumberOfWaysToPlacePeopleI3025 {
    public static void main(String[] args) {

    }
    public int numberOfPairs(int[][] points) {
        if (points.length == 0) return 0;
        int numberOfPairs = 0;
        int size = points.length;
        for (int i = 0; i < size; i++) {
            for (int j = i + 1; j < size; j++) {
                if((points[i][0] <= points[j][0] && points[i][1] >= points[j][1])
                || (points[j][0] <= points[i][0] && points[j][1] >= points[i][1])) {
                    boolean isInArea = true;
                    for(int k = 0; k < size; k++) {
                        if(k != i && k != j) {
                            if(((points[k][0] >= points[i][0] && points[k][0] <= points[j][0])
                                    ||(points[k][0] >= points[j][0] && points[k][0] <= points[i][0])) &&
                                    ((points[k][1] >= points[i][1] && points[k][1] <= points[j][1])
                                            ||(points[k][1] >= points[j][1] && points[k][1] <= points[i][1])))
                            {
                                isInArea = false;
                            }
                        }
                    }
                    if(isInArea){
                        numberOfPairs++;
                    }
                }
            }
        }
        return numberOfPairs;
    }
}
