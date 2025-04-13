package com.java.problems.leetcode.medium;

public class RotateImage48 {
    public static void main(String[] args) {
        int[][] matrix = {{1,2,3},{4,5,6},{7,8,9}};
        int[][] mat = {{5,1,9,11},{2,4,8,10},{13,3,6,7},{15,14,12,16}};
        RotateImage48 rotate = new RotateImage48();
        rotate.rotate(matrix);
        rotate.rotate(mat);
    }

    public void rotate(int[][] matrix) {
        int maxRows = matrix.length - 1;
        int minRows = 0;
        int maxCols = matrix[0].length - 1;
        int minCols = 0;
        while(minRows < maxRows && minCols < maxCols) {
            for(int col = minCols, row = minRows; col < maxCols; col++) {
                int value = matrix[row][col];
                int newRow = col;
                int newCol = maxCols;
                int temp = matrix[newRow][newCol];
                matrix[newRow][newCol] = value;
                value = temp;

                newCol = maxCols - newRow + minCols;
                newRow = maxRows;
                temp = matrix[newRow][newCol];
                matrix[newRow][newCol] = value;
                value = temp;

                newRow = newCol;
                newCol = minCols;
                temp = matrix[newRow][newCol];
                matrix[newRow][newCol] = value;
                value = temp;

                matrix[row][col] = value;
            }
            minRows++;
            maxRows--;
            minCols++;
            maxCols--;
        }
    }
}

