package com.java.problems.leetcode.medium;

import java.util.*;

import static java.lang.System.*;

public class SurroundedRegions130 {
    public static void main(String[] args) {
        char[][] board = {{'X','X','X','X'},{'X','O','O','X'},{'X','X','O','X'},{'X','O','X','X'}};
        SurroundedRegions130 sr = new SurroundedRegions130();
        sr.solve(board);
    }
    public void solve(char[][] board) {
        HashMap<String, List<Integer>> visited =new HashMap<>();
        int maxRow = board.length;
        int maxCol = board[0].length;
        List<List<String>> regions = new ArrayList<>();
        int[][] directions = new int[][]{{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                String key = i + "#" + j;
                if (board[i][j] == 'O' && !visited.containsKey(key)) {
                    Queue<String> queue = new LinkedList<>();
                    queue.add(key);
                    visited.put(key, new ArrayList<>(List.of(i, j)));
                    List<String> region = new ArrayList<>();
                    region.add(key);
                    while (!queue.isEmpty()) {
                        String element = queue.poll();
                        List<Integer> value = visited.get(element);
                        int row = value.get(0);
                        int col = value.get(1);
                        for (int[] direction : directions) {
                            int newRow = row + direction[0];
                            int newCol = col + direction[1];
                            String newKey = newRow + "#" + newCol;
                            if(newRow >= 0 && newRow< maxRow && newCol >= 0 && newCol< maxCol
                                    && board[newRow][newCol] == 'O' && !visited.containsKey(newKey)) {
                                queue.add(newKey);
                                visited.put(newKey, new ArrayList<>(List.of(newRow, newCol)));
                                region.add(newKey);
                            }
                        }
                    }
                    regions.add(region);
                }
            }
        }
        for (List<String> region : regions) {
            boolean surrounded = true;
            for (String key : region) {
                List<Integer> value = visited.get(key);
                int row = value.get(0);
                int col = value.get(1);
                for (int[] direction : directions) {
                    int newRow = row + direction[0];
                    int newCol = col + direction[1];
                    if (newRow < 0 || newRow >= maxRow || newCol < 0 || newCol >= maxCol) {
                        surrounded = false;
                        break;
                    }
                }
            }
            if (surrounded) {
                for (String key : region) {
                    List<Integer> value = visited.get(key);
                    int row = value.get(0);
                    int col = value.get(1);
                    board[row][col] = 'X';
                }
            }
        }
        for (char[] chars : board) {
            for (int j = 0; j < board[0].length; j++) {
                out.print(chars[j] + " ");
            }
            out.println();
        }
        out.println();
    }
}
