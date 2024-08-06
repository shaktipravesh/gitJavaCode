package com.java.algoNDataStucture;

public class RowColumnZero {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[][] matrix = {{1, 2, 3, 4},{5, 0, 7, 8}};
		RowColumnZero solution = new RowColumnZero();
		solution.rotateMatrix(matrix);
		System.out.println(matrix);
		
	}

	int[][] rotateMatrix(int[][] matrix){
		int[][] myMatrix = new int[matrix[0].length][matrix.length];
		for(int i = 0; i < matrix.length; i++) {
			for(int j = 0; j < matrix[0].length; j++) {
				myMatrix[j][i] = matrix[matrix.length - i -1][j];
			}
		}
		
		return myMatrix;
	}
	void setRowColumnZeroes(int[][] matrix){
		int[][] myMatrix = new int[matrix.length][matrix[0].length];
		for(int i = 0; i < matrix.length; i++) {
			for(int j = 0; j < matrix[0].length; j++) {
				if(matrix[i][j] == 0) {
					for(int k = 0; k < matrix[0].length; k++) {
						myMatrix[i][k] = -1;
					}
					for(int k = 0; k < matrix.length; k++) {
						myMatrix[k][j] = -1;
					}
				}
			}
		}
		for(int i = 0; i < matrix.length; i++) {
			for(int j = 0; j < matrix[0].length; j++) {
				if(myMatrix[i][j] == -1) {
					matrix[i][j] = 0;
				}
			}
		}
	}
}
