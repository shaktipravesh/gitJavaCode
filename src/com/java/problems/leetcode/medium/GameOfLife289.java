package com.java.problems.leetcode.medium;

import java.util.ArrayList;
import java.util.List;

import static java.lang.System.*;

public class GameOfLife289 {
    public static void main(String[] args) {
        int[][] board = {{0,1,0}, {0,0,1}, {1,1,1}, {0,0,0}};

        GameOfLife289 game = new GameOfLife289();
        game.gameOfLife(board);
        out.println();
    }

    public void gameOfLife(int[][] board) {
        int m = board.length;
        int n = board[0].length;
        List<List<Integer>> change = new ArrayList<>();
        int[][] directions = new int[][]{{-1, 0}, {1, 0}, {0, -1}, {0, 1}, {-1, -1}, {1, -1}, {-1, 1}, {1, 1}};
        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                int life = 0;
                for (int[] direction : directions) {
                    int x = i + direction[0];
                    int y = j + direction[1];
                    if (x >= 0 && x < m && y >= 0 && y < n) {
                        if (board[x][y] == 1) {
                            life++;
                        }
                    }
                }
                if(((life < 2 || life > 3) && board[i][j] == 1) ||(life == 3 && board[i][j] == 0)) {
                    change.add(new ArrayList<>(List.of(i, j)));
                }
            }
        }
        for (List<Integer> grid : change) {
            if (board[grid.get(0)][grid.get(1)] == 0) {
                board[grid.get(0)][grid.get(1)] = 1;
            } else {
                board[grid.get(0)][grid.get(1)] = 0;
            }
        }

    }
}
