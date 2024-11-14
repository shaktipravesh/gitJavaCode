package com.java.LLDQuestions.TicTacToreLLD.Model;

import org.w3c.dom.ls.LSOutput;

import java.util.*;

public class Board {
    public int size;
    public PlayingPiece[][] board;

    public Board(int size) {
        this.size = size;
        board = new PlayingPiece[size][size];
    }

    public boolean addPiece(int row, int col, PlayingPiece piece) {
        if(board[row][col] != null) {
            return false;
        }
        board[row][col] = piece;
        return true;
    }

    public List<Map<Integer, Integer>> gerFreeCells() {
        List<Map<Integer, Integer>> freeCells = new ArrayList<>();
        for(int i = 0; i < size; i++) {
            for(int j = 0; j < size; j++) {
                if(board[i][j] == null) {
                    Map<Integer, Integer> freeCell = new HashMap<>();
                    freeCell.put(i, j);
                    freeCells.add(freeCell);
                }
            }
        }
        return freeCells;
    }

    public void printBoard() {
        Arrays.stream(board).toList().forEach(row-> {
            Arrays.stream(row).toList().forEach(value -> {
                if(value == null)
                    System.out.print(value + " ");
                else
                    System.out.print(value.pieceType + " ");
            });
            System.out.println();
        });
    }
}
