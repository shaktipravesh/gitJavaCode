package com.java.problems;

import java.util.Arrays;

public class InplaceMatRotateByNintyClockWise {
    public static void main(String[] args) {
        //int[][] matrix = {{1, 2, 3, 4}, { 5, 6, 7, 8}, {9, 10, 11, 12}, {13, 14, 15, 16}};
        //int[][] matrix = {{1,2,3}, {4,5,6}, {7,8,9}};
        int[][] matrix = {{1, 2, 3, 4, 5}, {6, 7, 8, 9, 10}, {11, 12, 13, 14, 15}, {16, 17, 18, 19, 20}, {21, 22, 23, 24, 25}};

        Arrays.stream(matrix).toList().forEach(matRow-> {
            System.out.println();
            Arrays.stream(matRow).forEach(matCol-> System.out.print(matCol+" "));
        });
        System.out.println();
        int size = matrix.length-1;

        for(int iRow = 0; iRow < matrix.length/2; iRow++) {
            for(int iRowRotate = iRow, iColRotate = iRowRotate; iColRotate < size-iRow; iColRotate++) {
                int row = iRowRotate;
                int col = iColRotate;
                int temp = matrix[row][col];

                //top row left side one rotation
                int tempRow = row;
                row = size-col;
                col = tempRow;

                //swap(matrix, row, col, temp);
                int tempVal = matrix[row][col];
                matrix[row][col] = temp;
                temp = tempVal;

                //left side to bottom row rotation
                tempRow = row;
                row = size-col;
                col = tempRow;
                //swap(matrix, row, col, temp);
                tempVal = matrix[row][col];
                matrix[row][col] = temp;
                temp = tempVal;

                //bottom row to right side rotation
                tempRow = row;
                row = size-col;
                col = tempRow;
                //swap(matrix, row, col, temp);
                tempVal = matrix[row][col];
                matrix[row][col] = temp;
                temp = tempVal;

                //right side to top row rotation
                tempRow = row;
                row = size-col;
                col = tempRow;
                //swap(matrix, row, col, temp);
                tempVal = matrix[row][col];
                matrix[row][col] = temp;
                temp = tempVal;
            }
        }
        Arrays.stream(matrix).toList().forEach(matRow-> {
            System.out.println();
            Arrays.stream(matRow).forEach(matCol-> System.out.print(matCol+" "));
        });
    }
}