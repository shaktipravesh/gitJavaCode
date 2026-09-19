package com.java.problems.leetcode.hard;

import java.util.HashMap;

import static java.lang.System.*;

public class FindMinimumAreaCoverAllOnesII3197 {
    public static void main(String[] args) {
        FindMinimumAreaCoverAllOnesII3197 finder = new FindMinimumAreaCoverAllOnesII3197();
        int[][] grid = {{1,0,1},{1,1,1}};
        out.println(finder.minimumSum(grid));
        int[][] grid1 = {{1,0,1,0},{0,1,0,1}};
        out.println(finder.minimumSum(grid1));
        int[][] grid2 = {{0,0,0},{0,0,0},{0,0,1},{1,1,0}};
        out.println(finder.minimumSum(grid2));

    }

    public int minimumSum(int[][] grid) {
        int minAreaSum;
        int iMinArea = 0;
        int jMinArea = 0;
        int kMinArea = 0;

        minAreaSum = minimumArea(0, grid.length, 0, grid[0].length, grid);
        int startCol = 0;
        int endCol = grid[0].length -1;
        for (int iStart = 0, iEnd = 0; iEnd < grid.length; iEnd++) {
            iMinArea = minimumArea(iStart, iEnd, startCol, endCol, grid);
            for (int jStart = iEnd + 1, jEnd = iEnd + 1; jEnd < grid.length; jEnd++) {
                int kStart = jEnd + 1;
                int kEnd = grid.length - 1;
                jMinArea = minimumArea(jStart, jEnd, startCol, endCol, grid);
                kMinArea = minimumArea(kStart, kEnd, startCol, endCol, grid);
                minAreaSum = Math.min(minAreaSum, iMinArea + jMinArea + kMinArea);
            }
        }

        int startRow = 0;
        int endRow = grid.length -1;
        for (int iStart = 0, iEnd = 0; iEnd < grid[0].length; iEnd++) {
            iMinArea = minimumArea(startRow, endRow, iStart, iEnd, grid);
            for (int jStart = iEnd + 1, jEnd = iEnd + 1; jEnd < grid[0].length; jEnd++) {
                int kStart = jEnd + 1;
                int kEnd = grid[0].length - 1;
                jMinArea = minimumArea(startRow, endRow, jStart, jEnd, grid);
                kMinArea = minimumArea(startRow, endRow, kStart, kEnd, grid);
                minAreaSum = Math.min(minAreaSum, iMinArea + jMinArea + kMinArea);
            }
        }

        for (int iStart = 0, iEnd = 0; iEnd < grid.length; iEnd++) {
            int jStart = iEnd + 1;
            int jEnd = grid.length - 1;
            for(int k = 1; k < grid[0].length; k++) {
                iMinArea = minimumArea(iStart, iEnd, 0, k-1, grid);
                jMinArea = minimumArea(jStart, jEnd, 0, k-1, grid);
                kMinArea = minimumArea(0, grid.length, k, grid[0].length, grid);
                minAreaSum = Math.min(minAreaSum, iMinArea + jMinArea + kMinArea);
            }
            for(int k = grid[0].length - 2; k >= 0; k--) {
                iMinArea = minimumArea(iStart, iEnd, k+1, grid[0].length, grid);
                jMinArea = minimumArea(jStart, jEnd, k+1, grid[0].length, grid);
                kMinArea = minimumArea(0, grid.length, 0, k, grid);
                minAreaSum = Math.min(minAreaSum, iMinArea + jMinArea + kMinArea);
            }
        }

        for (int iStart = 0, iEnd = 0; iEnd < grid[0].length; iEnd++) {
            int jStart = iEnd + 1;
            int jEnd = grid[0].length - 1;
            for(int k = 1; k < grid.length; k++) {
                iMinArea = minimumArea( 0, k-1, iStart, iEnd, grid);
                jMinArea = minimumArea( 0, k-1, jStart, jEnd, grid);
                kMinArea = minimumArea(k, grid.length - 1, 0, grid[0].length-1, grid);
                minAreaSum = Math.min(minAreaSum, iMinArea + jMinArea + kMinArea);
            }
            for(int k = grid.length - 2; k >= 0; k--) {
                iMinArea = minimumArea( k + 1, grid.length - 1, iStart, iEnd, grid);
                jMinArea = minimumArea( k + 1, grid.length - 1, jStart, jEnd, grid);
                kMinArea = minimumArea(0, k, 0, grid[0].length-1, grid);
                minAreaSum = Math.min(minAreaSum, iMinArea + jMinArea + kMinArea);
            }
        }
        return minAreaSum;
    }

    public int minimumArea(int startRow, int endRow, int startCol, int endCol, int[][] grid) {
        int minRow = Integer.MAX_VALUE;
        int maxRow = Integer.MIN_VALUE;
        int minCol = Integer.MAX_VALUE;
        int maxCol = Integer.MIN_VALUE;
        for(int row = startRow; row <= endRow && row < grid.length; row++) {
            for (int col = startCol; col <= endCol && col < grid[0].length; col++){
                if(grid[row][col] == 1) {
                    minRow = Math.min(minRow, row);
                    minCol = Math.min(minCol, col);
                    maxRow = Math.max(maxRow, row);
                    maxCol = Math.max(maxCol, col);
                }
            }
        }
        return maxRow == Integer.MIN_VALUE? 0 : (maxRow - minRow + 1)*(maxCol - minCol + 1);
    }
}
