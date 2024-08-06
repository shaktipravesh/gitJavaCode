package com.java.algoNDataStucture.workat;

public class MatrixPaths {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	int getNumPaths(int rows, int columns) {
		int[][] aMatrix = new int[rows + 1][columns + 1];
		aMatrix[0][1] = 1;
		for(int i = 1; i <= rows; i++){
			for(int j = 1; j <=columns; j++){
				aMatrix[i][j] = aMatrix[i-1][j] + aMatrix[i][j-1];
			}
		}
		return aMatrix[rows][columns];
	}
}
