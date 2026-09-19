package com.java.problems.leetcode.easy;

public class MinimumTimeVisitingAllPoints1266 {
    public static void main(String[] args) {

    }

    public int minTimeToVisitAllPoints(int[][] points) {
        int minTimeToVisit = 0;
        for (int i = 1; i < points.length; i++) {
            minTimeToVisit += Math.max(Math.abs(points[i][0] - points[i - 1][0]), Math.abs(points[i][1] - points[i - 1][1]));
        }
        return minTimeToVisit;
    }

    public int numSpecial(int[][] mat) {

        int numSpecial = 0;
        int[][] rowCount = new int[mat.length][2];
        int[][] colCount = new int[mat[0].length][2];
        for (int i = 0; i < mat.length; i++) {
            for (int j = 0; j < mat[0].length; j++) {
                if (mat[i][j] == 1) {
                    rowCount[i][0]++;
                    rowCount[i][1] = j;
                    colCount[j][0]++;
                    colCount[j][1] = i;
                }
            }
        }
        for (int i = 0; i < rowCount.length; i++) {
            if (rowCount[i][0] == 1) {
                if(colCount[rowCount[i][1]][0] == 1) {
                    numSpecial++;
                }
            }
        }
        return numSpecial;
    }
}
