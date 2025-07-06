package com.java.problems.code360.medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class GameOfLife {
    public static ArrayList<ArrayList<Integer>> gameOfLife(ArrayList<ArrayList<Integer>> board, int n, int m) {
        int[][] basicBoard = new int[n][m];
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < m; j++) {
                basicBoard[i][j] = board.get(i).get(j);
            }
        }
        List<List<Integer>> change = new ArrayList<>();
        int[][] directions = new int[][]{{-1, 0}, {1, 0}, {0, -1}, {0, 1}, {-1, -1}, {1, -1}, {-1, 1}, {1, 1}};
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < m; j++) {
                int life = 0;
                for (int[] direction : directions) {
                    int x = i + direction[0];
                    int y = j + direction[1];
                    if (x >= 0 && x < n && y >= 0 && y < m) {
                        if (basicBoard[x][y] == 1) {
                            life++;
                        }
                    }
                }
                if(((life < 2 || life > 3) && basicBoard[i][j] == 1) ||(life == 3 && basicBoard[i][j] == 0)) {
                    List<Integer> changegrid = new ArrayList<>();
                    changegrid.add(i);
                    changegrid.add(j);
                    change.add(changegrid);
                }
            }
        }
        for (List<Integer> grid : change) {
            if (basicBoard[grid.get(0)][grid.get(1)] == 0) {
                basicBoard[grid.get(0)][grid.get(1)] = 1;
            } else {
                basicBoard[grid.get(0)][grid.get(1)] = 0;
            }
        }
        ArrayList<ArrayList<Integer>> result = Arrays.stream(basicBoard).map(row -> Arrays.stream(row).boxed().collect(Collectors.toCollection(ArrayList::new))).collect(Collectors.toCollection(ArrayList::new));
        return result;
    }
}
