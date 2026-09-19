package com.java.problems.leetcode.medium;

import java.util.ArrayList;
import java.util.List;

public class FindASafeWalkThroughAGrid3286 {
    public boolean findSafeWalk(List<List<Integer>> grid, int health) {
        int m = grid.size();
        int n = grid.get(0).size();
        if(grid.getFirst().getFirst() == 1 && health == 0) {
            return false;
        }
        int currHealth = health;
        int[][] direction = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
        int[][] matrix = new int[grid.size()][grid.getFirst().size()];
        List<int[]> pathIndex = new ArrayList<>();
        int[] start = {0, 0, currHealth};
        matrix[0][0] = Integer.MAX_VALUE;
        currHealth -= grid.getFirst().getFirst();
        pathIndex.add(start);
        while(!pathIndex.isEmpty()) {
            int[] current = pathIndex.removeLast();
            for(int i = 0; i < 4; i++) {
                int mx = current[0] + direction[i][0];
                int nx = current[1] + direction[i][1];
                if(mx >= 0 && mx < m && nx >= 0 && nx < n) {
                    if(mx == m-1 && nx == n-1 && currHealth >= grid.get(mx).get(nx)) {
                        return true;
                    }
                    if(matrix[mx][nx] == 0 && currHealth >= grid.get(mx).get(nx)) {
                        int[] index = {mx, nx};
                        pathIndex.add(index);
                        matrix[mx][nx] = Integer.MAX_VALUE;
                        currHealth -= grid.get(mx).get(nx);
                    }
                }
            }
        }
        return false;
    }
}
