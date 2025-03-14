package com.java.problems.code360.hard;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class RottenOranges {
    static class Cell {
        int x, y, time;

        Cell(int x, int y, int time) {
            this.x = x;
            this.y = y;
            this.time = time;
        }
    }

    public static int minTimeToRot(int[][] grid) {
        int rows = grid.length;
        int cols = grid[0].length;
        Queue<Cell> queue = new LinkedList<>();
        int freshCount = 0;

        // Initialize the queue with all initially rotten oranges
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (grid[i][j] == 2) {
                    queue.offer(new Cell(i, j, 0));
                } else if (grid[i][j] == 1) {
                    freshCount++;
                }
            }
        }

        if (freshCount == 0) return 0; // No fresh oranges to rot

        int[][] directions = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
        int minutes = 0;

        while (!queue.isEmpty()) {
            Cell current = queue.poll();
            int x = current.x, y = current.y, time = current.time;
            minutes = time;

            for (int[] dir : directions) {
                int newX = x + dir[0];
                int newY = y + dir[1];

                if (newX >= 0 && newX < rows && newY >= 0 && newY < cols && grid[newX][newY] == 1) {
                    grid[newX][newY] = 2; // Rot the fresh orange
                    queue.offer(new Cell(newX, newY, time + 1));
                    freshCount--;
                }
            }
        }

        return freshCount == 0 ? minutes : -1; // If there are still fresh oranges left, return -1
    }

    public static void mainEfficient(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        int[][] grid = new int[n][m];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                grid[i][j] = scanner.nextInt();
            }
        }

        System.out.println(minTimeToRot(grid));
    }
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int m = in.nextInt();
        int[][] matrix = new int[n][m];
        int[][] matrixBuffer = new int[n][m];
        int[][] rottenOranges = new int[n*m][3];
        int freshCount = 0;
        int timeMax = 0;
        int size = 0;
        int[][] directions = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                matrix[i][j] = in.nextInt();
                if(matrix[i][j] == 2) {
                    rottenOranges[size][0] = i;
                    rottenOranges[size][1] = j;
                    rottenOranges[size][2] = 0;
                    size++;
                }
                if(matrix[i][j] == 1) {
                    freshCount++;
                }
            }
        }
        for(int i = 0; i < size; i++) {
            int x = rottenOranges[i][0];
            int y = rottenOranges[i][1];
            int time = rottenOranges[i][2];
            timeMax = Math.max(timeMax, time);
            for(int j = 0; j < directions.length; j++) {
                int newX = x + directions[j][0];
                int newY = y + directions[j][1];
                if(newX >= 0 && newX < n && newY >= 0 && newY < m) {
                    if(matrix[newX][newY] == 1) {
                        rottenOranges[size][0] = newX;
                        rottenOranges[size][1] = newY;
                        rottenOranges[size][2] = time+1;
                        matrix[newX][newY] = 2;
                        size++;
                        freshCount--;
                    }
                }
            }
        }
        if(freshCount == 0 ) {
            System.out.println(timeMax);
        } else {
            System.out.println(-1);
        }
    }
}
