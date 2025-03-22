package com.java.problems.leetcode.medium;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

import static java.lang.System.*;

public class MinimumPathSum64 {
    public static void main(String[] args) {
        int[][] grid = {{1,3,1},{1,5,1},{4,2,1}};
        MinimumPathSum64 msp = new MinimumPathSum64();
        out.println(msp.minPathSum(grid));
    }
    public int minPathSum(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        boolean[][] visited = new boolean[m][n];
        visited[0][0] = true;
        int[][] dp = new int[m][n];
        Arrays.stream(dp).forEach(row -> Arrays.fill(row, Integer.MAX_VALUE));
        dp[0][0] = grid[0][0];
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{0, 0});
        while (!queue.isEmpty()) {
            int[] poll = queue.poll();
            int x = poll[0], y = poll[1];
            if (x == m - 1 && y == n - 1) {
                return dp[x][y];
            }
            if(x + 1 < m) {
                if(!visited[x+1][y]) {
                    visited[x+1][y] = true;
                    queue.offer(new int[]{x + 1, y});
                }
                dp[x+1][y] = Math.min(dp[x+1][y], dp[x][y] + grid[x + 1][y]);
            }
            if(y + 1 < n) {
                if(!visited[x][y+1]) {
                    visited[x][y+1] = true;
                    queue.offer(new int[]{x, y + 1});
                }
                dp[x][y+1] = Math.min(dp[x][y+1], dp[x][y] + grid[x][y+1]);
            }
        }
        return dp[m-1][n-1];
    }
}
