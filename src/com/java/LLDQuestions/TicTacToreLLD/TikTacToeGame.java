package com.java.LLDQuestions.TicTacToreLLD;

import com.java.LLDQuestions.TicTacToreLLD.Model.*;

import java.util.*;

public class TikTacToeGame {
    Deque<Player> players;
    Board gameBoard;

    public TikTacToeGame() {
        initializeGame();
    }

    private void initializeGame() {
        players = new LinkedList<>();
        PlayingPieceO playingPieceO = new PlayingPieceO();
        Player playerO = new Player("PlayerO", playingPieceO);

        PlayingPieceX playingPieceX = new PlayingPieceX();
        Player playerX = new Player("PlayerX", playingPieceX);

        players.add(playerO);
        players.add(playerX);

        gameBoard = new Board(3);
    }

    public String playTicTakToe() {
        boolean noWinner = true;
        while (noWinner) {
            Player currentPlayer = players.removeFirst();
            gameBoard.printBoard();
            List<Map<Integer, Integer>> freeSpace = gameBoard.gerFreeCells();
            if(freeSpace.isEmpty()) {
                noWinner = false;
                continue;
            }

            //Read Input from Player
            System.out.println("Player: " + currentPlayer.getPlayerName() + "Enter row, col: ");
            Scanner scanner = new Scanner(System.in);
            int row = scanner.nextInt();
            int col = scanner.nextInt();

            boolean pieceAddStatus = gameBoard.addPiece(row, col, currentPlayer.playingPiece);
            if(!pieceAddStatus) {
                System.out.println("Incorrect piece, Try again.");
                players.add(currentPlayer);
                continue;
            }

            players.addLast(currentPlayer);

            boolean winner = isThereWinner(row, col, currentPlayer.playingPiece.pieceType);
            if(winner) {
                gameBoard.printBoard();
                return currentPlayer.getPlayerName();
            }
        }
        return "tie";
    }

    private boolean isThereWinner(int row, int col, PieceType pieceType) {
        boolean rowMatch = true;
        boolean colMatch = true;
        boolean diagonalMatch = true;
        boolean antiDiagonalMatch = true;
        for(int i = 0; i < gameBoard.size; i++) {
            if(gameBoard.board[row][i] == null || gameBoard.board[row][i].pieceType != pieceType) {
                rowMatch = false;
            }
        }
        for(int i = 0; i < gameBoard.size; i++) {
            if (gameBoard.board[i][col] == null || gameBoard.board[i][col].pieceType != pieceType) {
                colMatch = false;
            }
        }
        for(int i = 0, j = 0; i < gameBoard.size && j < gameBoard.size; i++, j++) {
            if (gameBoard.board[i][j] == null || gameBoard.board[i][j].pieceType != pieceType) {
                diagonalMatch = false;
            }
        }
        for(int i = 0, j = gameBoard.size-1; i < gameBoard.size && j >= 0; i++, j--) {
            if (gameBoard.board[i][j] == null || gameBoard.board[i][j].pieceType != pieceType) {
                antiDiagonalMatch = false;
            }
        }

        return rowMatch || colMatch || diagonalMatch || antiDiagonalMatch;
    }
}
