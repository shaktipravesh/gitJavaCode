package com.java.problems.leetcode.medium;

import java.util.LinkedList;
import java.util.Queue;

public class NumberOfClosedIslands1254 {
    public static void main(String[] args) {
        NumberOfClosedIslands1254 obj = new NumberOfClosedIslands1254();
        int[][] grid = {{1,1,1,1,1,1,1,0}, {1,0,0,0,0,1,1,0}, {1,0,1,0,1,1,1,0}, {1,0,0,0,0,1,0,1}, {1,1,1,1,1,1,1,0}};
        System.out.println(obj.closedIsland(grid));
    }
    public int closedIsland(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        boolean isClosed = true;
        int closedIslands = 0;
        int[][] directions = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 0) {
                    Queue<int[]> queue = new LinkedList<>();
                    queue.add(new int[]{i, j});
                    isClosed = true;
                    while (!queue.isEmpty()) {
                        int[] poll = queue.poll();
                        int x = poll[0], y = poll[1];
                        if(x == 0 || x == m - 1 || y == 0 || y == n - 1) {
                            isClosed = false;
                        }
                        grid[x][y] = -1;
                        for (int[] direction : directions) {
                            int newX = x + direction[0], newY = y + direction[1];
                            if(newX >= 0 && newY >= 0 && newX < m && newY < n && (grid[newX][newY] == 0)) {
                                queue.add(new int[]{newX, newY});
                            }
                        }
                    }
                    if (isClosed) {
                        closedIslands++;
                    }
                }
            }
        }
        return closedIslands;
    }
}
