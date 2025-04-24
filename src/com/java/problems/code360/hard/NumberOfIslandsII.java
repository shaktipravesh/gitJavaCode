package com.java.problems.code360.hard;

import java.util.ArrayList;
import java.util.Scanner;

public class NumberOfIslandsII {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int iTCs = sc.nextInt();
        for (int i = 0; i < iTCs; i++) {
            int n = sc.nextInt();
            int m = sc.nextInt();
            int qCount = sc.nextInt();
            int[][] q = new int[qCount][2];
            for (int j = 0; j < qCount; j++) {
                q[j][0] = sc.nextInt();
                q[j][1] = sc.nextInt();
            }
            int[] islands = numOfIslandsII(n, m, q);
            for(int island : islands) {
                System.out.print(island + " ");
            }
            System.out.println();

        }
    }
    public static int[] numOfIslandsII(int n, int m, int[][] q) {
        int[] islands = new int[q.length];
        int[][] Ocean = new int[n][m];
        int iSlandCounter = 1;
        ArrayList<Integer> number = new ArrayList<>();
        int[][] directions = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
        for(int i = 0; i < q.length; i++) {
            int X = q[i][0];
            int Y = q[i][1];
            boolean isNewIsland = true;
            number.clear();
            int iMin = Integer.MAX_VALUE;
            for(int[] direction : directions) {
                int x = X + direction[0];
                int y = Y + direction[1];
                if (x >= 0 && x < n && y >= 0 && y < m && Ocean[x][y] != 0) {
                    if(!number.contains(Ocean[x][y])) {
                        number.add(Ocean[x][y]);
                    }
                    iMin = Math.min(iMin, Ocean[x][y]);
                    isNewIsland = false;
                }
            }
            if(i > 0) {
                if(isNewIsland) {
                    islands[i] =  islands[i - 1] + 1;
                    iSlandCounter++;
                    Ocean[X][Y] =  iSlandCounter;
                } else {
                    islands[i] = islands[i - 1] - number.size() + 1;
                    Ocean[X][Y] =  iMin;
                    if(number.size() > 1) {
                        mergeIslands(Ocean, number, iMin, directions, X, Y);
                    }
                }
            } else {
                islands[i] = 1;
                iSlandCounter = 1;
                Ocean[X][Y] =  1;
            }
        }
        return islands;
    }

    private static void mergeIslands(int[][] ocean, ArrayList<Integer> number, int iMin, int[][] directions, int x, int y) {
        for(int[] direction : directions) {
            int newX = x + direction[0];
            int newY = y + direction[1];
            if(newX >= 0 && newX < ocean.length && newY >=  0 && newY < ocean[0].length && ocean[newX][newY] != 0) {
                if( ocean[newX][newY] != iMin) {
                    ocean[newX][newY] = iMin;
                    mergeIslands(ocean, number, iMin, directions, newX, newY);
                }
            }
        }
    }
}
