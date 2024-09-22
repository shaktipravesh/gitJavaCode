package com.java.algoNDataStucture.workat.dp;

public class MaximumPathSumInMatrix {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[][] M= 	{{12, 22,  5,  0, 20, 18},
					{ 0,  2,  5, 25, 18, 17},
					{12, 10, 5,  4,  2,  1},
					{ 3,  8,  2, 20, 10,  8}};
		MaximumPathSumInMatrix matrixPathSumInMatrix = new MaximumPathSumInMatrix();
		matrixPathSumInMatrix.findMaxPath(M);
	}

	
	int findMaxPath(int[][] M) {
		int maxPath = 0;
		int length = M.length;
	    for(int i = 1; i < M.length; i++) {
			for(int j = 0; j < M[i].length; j++) {
				if(j > 0 && j < M[i].length-1) {
					M[i][j] = Math.max(M[i-1][j-1], Math.max(M[i-1][j], M[i-1][j+1])) + M[i][j];
				} else if(j == 0 && j < M[i].length-1) {
					M[i][j] = Math.max(M[i-1][j], M[i-1][j+1]) + M[i][j];
				} else if(j > 0 && j < M[i].length) {
					M[i][j] = Math.max(M[i-1][j-1], M[i-1][j]) + M[i][j];
				} else {
					M[i][j] = M[i-1][j] + M[i][j];
				}
			}
		}
	    for(int i = 0; i < M[0].length; i++) {
	    	if(maxPath < M[length-1][i]) {
	    		maxPath = M[length-1][i];
	    	}
	    }
	    return maxPath;
	}
}
