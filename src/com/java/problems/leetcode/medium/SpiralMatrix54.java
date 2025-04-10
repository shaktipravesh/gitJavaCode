package com.java.problems.leetcode.medium;

import java.util.ArrayList;
import java.util.List;

public class SpiralMatrix54 {
    public static void main(String[] args) {
        int[][] matrix = {{1,2,3, 4},{5,6, 7, 8},{9, 10, 11, 12}};
        SpiralMatrix54 sm = new SpiralMatrix54();
        List<Integer> result = sm.spiralOrder(matrix);
        System.out.println(result);
    }

    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> res = new ArrayList<>();
        int[][] directions = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
        int[][] limit = {{1, 0, 0, 0}, {0, 0, 0, -1}, {0, 0, -1, 0}, {0, 1, 0, 0}};
        int index = 0;
        int maxRows = matrix.length;
        int minRows = 0;
        int maxCols = matrix[0].length;
        int minCols = 0;
        int row = 0;
        int col = -1;
        while(minRows <= maxRows && minCols <= maxCols) {
            int newRow = row + directions[index][0];
            int newCol = col + directions[index][1];
            if(newRow >= minRows && newCol >= minCols && newRow < maxRows && newCol < maxCols) {
                res.add(matrix[newRow][newCol]);
                row = newRow;
                col = newCol;
            } else {
                minRows += limit[index][0];
                minCols += limit[index][1];
                maxRows += limit[index][2];
                maxCols += limit[index][3];
                index = (index + 1) % directions.length;
            }
        }
        return res;
//        for (int row = minRows, col = minCols; res.size() < rowsLimit*colsLimit;) {
//            res.add(matrix[row][col]);
//            int rowTemp = row + directions[index][0];
//            int colTemp = row + directions[index][1];
//            if(rowTemp < 0 || colTemp < 0 || rowTemp >= maxRows || colTemp >= maxCols) {
//                minRows += limit[index][0];
//                minCols += limit[index][1];
//                maxRows += limit[index][2];
//                maxCols += limit[index][3];
//                index = (index + 1) % 4;
//            }
//        }
    }
}
