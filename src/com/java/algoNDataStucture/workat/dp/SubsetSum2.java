package com.java.algoNDataStucture.workat.dp;

public class SubsetSum2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	int subsetSum(int[] A, int target) {
	    int targetMeet = 0;
	    int[][] valueMatrix = new int[A.length][target+1];
		for(int i = 0; i <= target; i++) {
			if(A[0] <= i) {
				valueMatrix[0][i] = A[0];
			}
		}
		for(int i = 1; i < A.length; i++) {
			for(int j = 1; j <= target; j++) {
				if(A[i] <= j) {
					valueMatrix[i][j] = Math.max(A[i] + valueMatrix[i-1][j-A[i]], valueMatrix[i-1][j]);
				} else {
					valueMatrix[i][j] =  valueMatrix[i-1][j];
				}
				if(valueMatrix[i][j] == target) {
					return 1;
				}
			}
		}
	    return targetMeet;
	}
}
