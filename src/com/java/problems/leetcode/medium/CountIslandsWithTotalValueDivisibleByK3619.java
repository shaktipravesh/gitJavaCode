package com.java.problems.leetcode.medium;

import java.util.LinkedList;
import java.util.Queue;

public class CountIslandsWithTotalValueDivisibleByK3619 {
    public static void main(String[] args) {
        CountIslandsWithTotalValueDivisibleByK3619 c = new CountIslandsWithTotalValueDivisibleByK3619();
        int[][] grid = {{16,0}, {0,0}, {0,0}, {0,3}, {9,10}};
        System.out.println(c.countIslands(grid, 13));
    }
    public int countIslands(int[][] grid, int k) {
        int islandVolume = 0;
        int divisibleByKCt = 0;
        int[][] directions = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
        for(int i = 0; i < grid.length; i++) {
            for(int j = 0; j < grid[0].length; j++) {
                islandVolume = 0;
                Queue<int[]> queue = new LinkedList<>();
                if(grid[i][j] > 0) {
                    queue.add(new int[]{i, j});
                    while(!queue.isEmpty()) {
                        int[] curr = queue.poll();
                        int x = curr[0], cy = curr[1];
                        if(grid[x][cy] > 0) {
                            islandVolume += grid[x][cy];
                            for(int[] direction : directions) {
                                if(x+direction[0] >= 0 && cy + direction[1] >= 0 && x+direction[0] < grid.length && cy+direction[1] < grid[0].length && grid[x+direction[0]][cy+direction[1]] > 0) {
                                    queue.add(new int[]{x+direction[0], cy+direction[1]});
                                }
                            }
                            grid[x][cy] = -1;
                        }
                    }
                }
                if(islandVolume > 0 && islandVolume % k == 0) {
                    divisibleByKCt++;
                }
            }
        }
        return divisibleByKCt;
    }
}
