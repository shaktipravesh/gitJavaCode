package com.java.problems.zycus;

import java.util.Arrays;

public class SpiralMatrix {
    public static void main(String[] args) {
        int [][]MATRIX = { {1, 3, 5, 7}, {10, 11, 16, 20}, {23, 30, 34, 60}};
        int[] spiralMatrix = spiralMatrix(MATRIX);
        System.out.println(Arrays.toString(spiralMatrix));
    }

    public static int[] spiralMatrix(int [][]MATRIX) {
        int[] spiralMatrix = new int[MATRIX.length*MATRIX[0].length];
        int index = 0;
        int rowUp = 0, rowDown = MATRIX.length - 1, colLeft = 0, colRight = MATRIX[0].length - 1;

        Direction direction = Direction.RIGHT;
        int row = 0, col = 0;
        spiralMatrix[index++] = MATRIX[row][col];
        col++;
        spiralMatrix[index++] = MATRIX[row][col];
        while(index < spiralMatrix.length) {
            switch(direction) {
                case RIGHT:
                    if(col < colRight) {
                        col++;
                        spiralMatrix[index++] = MATRIX[row][col];
                    }
                    if(col == colRight) {
                        direction = Direction.DOWN;
                        if(rowUp < rowDown) {
                            rowUp++;
                            row++;
                            spiralMatrix[index++] = MATRIX[row][col];
                        }
                    }
                    break;
                case DOWN:
                    if(row < rowDown) {
                        row++;
                        spiralMatrix[index++] = MATRIX[row][col];
                    }
                    if(row == rowDown) {
                        direction = Direction.LEFT;
                        if(colLeft < colRight) {
                            col--;
                            colRight--;
                            spiralMatrix[index++] = MATRIX[row][col];
                        }
                    }
                    break;
                case LEFT:
                    if(col > colLeft) {
                        col--;
                        spiralMatrix[index++] = MATRIX[row][col];
                    }
                    if(col == colLeft) {
                        direction = Direction.UP;
                        if(rowUp < rowDown) {
                            rowDown--;
                            row--;
                            spiralMatrix[index++] = MATRIX[row][col];
                        }
                    }
                    break;
                case UP:
                    if(row > rowUp) {
                        row--;
                        spiralMatrix[index++] = MATRIX[row][col];
                    }
                    if(row == rowUp) {
                        direction = Direction.RIGHT;
                        if(colLeft < colRight) {
                            col++;
                            colLeft++;
                            spiralMatrix[index++] = MATRIX[row][col];
                        }
                    }
                    break;
                default: break;
            }

        }
        return spiralMatrix;
    }

    enum Direction {RIGHT, DOWN, LEFT, UP}
}
