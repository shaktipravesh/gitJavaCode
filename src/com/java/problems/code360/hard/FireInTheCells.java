package com.java.problems.code360.hard;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class FireInTheCells {
    public static void main(String[] args) {
/*        int N = 5;
        int M = 4;
        int X = 2;
        int Y = 1;
        int[][] mat = {{0, 1, 1, 1},{1, 0, 1, 1},{1, 1, 1, 1},{0, 1, 1, 1},{0, 0, 0, 0}};
        System.out.println(fireInTheCells(mat, N, M, X, Y));*/

//        N = 4;
//        M = 4;
//        int[][] mat = {{0, 1, 1, 1},{1, 0, 1, 1},{1, 1, 1, 1},{0, 1, 1, 0}};
//        X = 1;
//        Y = 2;
//        System.out.println(fireInTheCells(mat, N, M, X, Y));

        Scanner sc = new Scanner(System.in);
        int iTCs = sc.nextInt();
        for (int i = 0; i < iTCs; i++) {
            int N = sc.nextInt();
            int M = sc.nextInt();
            int[][] mat = new int[N][M];
            for (int j = 0; j < N; j++) {
                for (int k = 0; k < M; k++) {
                    mat[j][k] = sc.nextInt();
                }
            }
            int X = sc.nextInt();
            int Y = sc.nextInt();
            System.out.println(fireInTheCells(mat, N, M, X, Y));
        }
    }
    public static int fireInTheCells(int[][] mat, int N, int M, int X, int Y) {
        if(mat[X][Y] == 0) {
            return -1;
        }
        int count = -1;
        boolean[][] visited = new boolean[N][M];
        int[][] fireStats = new int[N][M];
        int[][] skipStats = new int[N][M];
        boolean[][] skipVisited = new boolean[N][M];
        Queue<Integer> queue = new LinkedList<>();
        int[][] directions = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (mat[i][j] == 0) {
                    queue.add(i*100 + j);
                    visited[i][j] = true;
                }
            }
        }
        while (!queue.isEmpty()) {
            int index = queue.poll();
            int x = index / 100;
            int y = index % 100;
            for(int[] direction : directions) {
                int newX = x + direction[0];
                int newY = y + direction[1];
                if(newX >= 0 && newX < N && newY >= 0 && newY < M && !visited[newX][newY]) {
                    fireStats[newX][newY] = fireStats[x][y] + 1;
                    queue.add(newX*100 + newY);
                    visited[newX][newY] = true;
                }
            }
        }
        Queue<int[]> queueSkip = new LinkedList<>();
        skipVisited[X][Y] = true;
        skipStats[X][Y] = 1;
        queueSkip.add(new int[]{X, Y});
        while (!queueSkip.isEmpty()) {
            int[] cur = queueSkip.poll();
            int x = cur[0];
            int y = cur[1];
            for (int[] direction : directions) {
                int newX = x + direction[0];
                int newY = y + direction[1];
                if(newX >= 0 && newX < N && newY >= 0 && newY < M && !skipVisited[newX][newY]) {
                    if(fireStats[newX][newY] > skipStats[x][y]) {
                        queueSkip.add(new int[]{newX, newY});
                        skipVisited[newX][newY] = true;
                        skipStats[newX][newY] = skipStats[x][y] + 1;
                    }
                } else if(newX < 0 || newX >= N || newY < 0 || newY >= M) {
                    count = skipStats[x][y];
                    return count-1;
                }
            }
        }





        return count;
    }
}
