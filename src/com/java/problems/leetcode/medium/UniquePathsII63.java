package com.java.problems.leetcode.medium;

import java.util.LinkedList;
import java.util.Queue;

public class UniquePathsII63 {
    public static void main(String[] args) {
        int[][] obstacleGrid = {{0,0,0},{0,1,0},{0,0,0}};
        UniquePathsII63 uniquePathsII63 = new UniquePathsII63();
        System.out.println(uniquePathsII63.uniquePathsWithObstacles(obstacleGrid));
    }
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;
        int[][] dp = new int[m][n];
        Queue<int[]> queue = new LinkedList<>();
        if(obstacleGrid[0][0] != 1 && obstacleGrid[m-1][n-1] != 1){
            queue.offer(new int[]{0, 0});
            dp[0][0] = 1;
        }
        obstacleGrid[0][0] = 1;
        while (!queue.isEmpty()) {
            int[] cur = queue.poll();
            int x = cur[0];
            int y = cur[1];
            if(x+1 < m){
                if(obstacleGrid[x+1][y] != 1) {
                    queue.offer(new int[]{x + 1, y});
                    obstacleGrid[x+1][y] = 1;
                }
                dp[x+1][y] += dp[x][y];
            }
            if(y+1 < n){
                if(obstacleGrid[x][y+1] != 1) {
                    queue.offer(new int[]{x, y + 1});
                    obstacleGrid[x][y+1] = 1;
                }
                dp[x][y+1] += dp[x][y];
            }

        }
        return dp[m-1][n-1];
    }
}
