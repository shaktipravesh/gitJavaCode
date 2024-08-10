package com.java.algoNDataStucture.workat;

public class MatrixSearch {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[][] aMatrix = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}, {10, 11, 12}};
		int key = 8;
		boolean keyExist = false;
		MatrixSearch matrixSearch = new MatrixSearch();
		keyExist = matrixSearch.searchMatrix(aMatrix, key);
		System.out.println(keyExist);

	}

	boolean searchMatrix(int[][] matrix, int key){
	    int from = 0;
		int to = matrix.length;
		int iRow = 0;
		boolean keyExist = false;
		for(; (to-from)>1;){
			int iMid = (from + to)/2;
			if(key == matrix[from][0] || key == matrix[to-1][0] || key == matrix[iMid][0]) {
				keyExist = true;
				return keyExist;
			}
			if(key > matrix[iMid][0]) {
				from = iMid;
			} else {
				to = iMid;
			}
		}
		iRow = from;
		from = 0;
		to = matrix[iRow].length;
		for(; (to - from) > 1;) {
			int iMid = (from + to)/2;
			if(key == matrix[iRow][from] || key == matrix[iRow][to -1] || key == matrix[iRow][iMid]) {
				keyExist = true;
				return keyExist;
			}
			if(key > matrix[iRow][iMid]) {
				from = iMid;
			} else {
				to = iMid;
			}
		}
		
		
		return keyExist;
	}
}
