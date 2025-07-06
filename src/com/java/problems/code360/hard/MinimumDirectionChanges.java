package com.java.problems.code360.hard;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

public class MinimumDirectionChanges {
    static class Node {
        int row, col, cost;
        public Node(int row, int col, int cost) {
            this.row = row;
            this.col = col;
            this.cost = cost;
        }
    }

    public static int minDirectionChanges(char[][] grid, int n, int m) {
        int[][] dist = new int[n][m];
        for (int i = 0; i < n; i++) {
            Arrays.fill(dist[i], Integer.MAX_VALUE);
        }
        int[] dr = {-1, 1, 0, 0};
        int[] dc = {0, 0, -1, 1};
        char[] directions = {'U', 'D', 'L', 'R'};
        Deque<Node> deque = new ArrayDeque<>();
        deque.add(new Node(0, 0, 0));
        dist[0][0] = 0;
        while (!deque.isEmpty()) {
            Node node = deque.poll();
            int row = node.row, col = node.col, cost = node.cost;
            if(row == n - 1 && col == m - 1) {
                return cost;
            }
            for (int i = 0; i < 4; i++) {
                int newRow = row + dr[i];
                int newCol = col + dc[i];
                if (newRow < 0 || newRow >= n || newCol < m || newCol >= m) {
                    int newCost = cost + grid[row][col] != directions[i] ? 1 : 0;
                    if(newCost < dist[newRow][newCol]) {
                        dist[newRow][newCol] = newCost;
                        if(grid[row][col] == directions[i]) {
                            deque.addFirst(new Node(newRow, newCol, newCost));
                        } else {
                            deque.addLast(new Node(newRow, newCol, newCost));
                        }
                    }
                }
            }
        }
        return -1;
    }
}
