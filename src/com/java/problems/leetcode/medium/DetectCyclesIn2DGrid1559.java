package com.java.problems.leetcode.medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Stack;

public class DetectCyclesIn2DGrid1559 {
    /*public static void main(String[] args) {
        DetectCyclesIn2DGrid1559 d = new DetectCyclesIn2DGrid1559();
//        char[][] grid = {{'f','a','a','c','b'},{'e','a','a','e','c'},{'c','f','b','b','b'},{'c','e','a','b','e'},{'f','e','f','b','f'}};
        char[][] grid = {{'c','a','d'},{'a','a','a'},{'a','a','d'},{'a','c','d'},{'a','b','c'}};
        System.out.println(d.containsCycle(grid));
    }
    public boolean containsCycle(char[][] grid) {
        char[][] visited = new char[grid.length][grid[0].length];
        int[][] visitedLen = new int[grid.length][grid[0].length];
        Arrays.stream(visited).forEach(row -> Arrays.fill(row, '.'));
        ArrayList<ArrayList<Integer>> coordinate = new ArrayList<>();

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (visited[i][j] == '.') {
                    ArrayList<Integer> newCoordinate = new ArrayList<>();
                    newCoordinate.add(i);
                    newCoordinate.add(j);
                    newCoordinate.add(1);
                    char c = grid[i][j];
                    coordinate.add(newCoordinate);
                    visited[i][j] = grid[i][j];
                    visitedLen[i][j] = 1;
                    if(detectCycle(coordinate, grid, visited, visitedLen))
                        return true;
                }
            }
        }
        return false;
    }

    private boolean detectCycle(Stack<ArrayList<Integer>> coordinate, char[][] grid, char[][] visited, int[]... visitedLen) {
        int[][] directions = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
        int xSize = grid.length;
        int ySize = grid[0].length;
        while (!coordinate.isEmpty()) {
            ArrayList<Integer> currCoordinate = coordinate.pop();
            int x = currCoordinate.get(0);
            int y = currCoordinate.get(1);
            int len = currCoordinate.get(2);
            char c = grid[x][y];
            for (int[] direction : directions) {
                int newX = x + direction[0];
                int newY = y + direction[1];
                if(newX >= 0 && newX < xSize && newY >= 0 && newY < ySize) {
                    if ((visited[newX][newY] == '.') && grid[newX][newY] == c) {
                        ArrayList<Integer> nextCoordinate = new ArrayList<>();
                        nextCoordinate.add(newX);
                        nextCoordinate.add(newY);
                        nextCoordinate.add(len + 1);
                        coordinate.push(nextCoordinate);
                        visitedLen[newX][newY] = len + 1;
                        visited[newX][newY] = grid[newX][newY];
                        return detectCycle(coordinate, grid, visited, visitedLen);
                    } else if (visited[newX][newY] == c && visitedLen[newX][newY] <= len-3) {
                        return true;
                    }
                }
            }
        }
        return false;
    }*/
}
