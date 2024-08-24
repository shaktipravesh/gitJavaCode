package com.java.algoNDataStucture.workat.dp;

public class LongestIncreasingSubsequence {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		LongestIncreasingSubsequence lis = new LongestIncreasingSubsequence();
		int[] A = {10, 20, 2, 5, 3, 8, 8, 25, 6};
		lis.getLengthOfLIS(A);
	}
	
	
	int getLengthOfLIS(int[] A) {
    	// add your logic here
		int[] LISData = new int[A.length];
		LISData[0] = 1;
		LISData[1] = A[0];
		for(int i = 1; i < A.length; i++) {
			for(int j = LISData[0]; j > 0; j--) {
				if(A[i] > LISData[j]) {
					if(LISData[j+1] != 0) {
						if(A[i] < LISData[j+1]) {
							LISData[j+1] = A[i];
							break;
						}
					} else {
						LISData[j+1] = A[i];
						LISData[0]++;
						break;
					}
				} else {
					if(j==1 && LISData[j] > A[i]) {
						LISData[j] = A[i];
					}
				}
			}
		}
		return LISData[0];
	}
}
