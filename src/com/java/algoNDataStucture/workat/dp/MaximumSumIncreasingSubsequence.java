package com.java.algoNDataStucture.workat.dp;

public class MaximumSumIncreasingSubsequence {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		MaximumSumIncreasingSubsequence maximumSumIncreasingSubsequence = new MaximumSumIncreasingSubsequence();
		int[] arr = {101, 4, 95, 103};
		maximumSumIncreasingSubsequence.maxSumSubsequence(arr);
	}

	int maxSumSubsequence(int[] arr) {
	    
		int maxSumSubsequence = arr[0];
		int[] sumSubsequence = new int[arr.length];
		sumSubsequence[0] = arr[0];
		for(int i = 1; i < arr.length; i++) {
			int smallerSumSubsequence = 0;
			for(int j = 0; j < i; j++) {
				if(arr[j] < arr[i] && smallerSumSubsequence < sumSubsequence[j]) {
					smallerSumSubsequence = sumSubsequence[j];
				}
			}
			sumSubsequence[i] = arr[i] + smallerSumSubsequence;
			if(maxSumSubsequence < sumSubsequence[i]) {
				maxSumSubsequence = sumSubsequence[i];
			}
		}
		return maxSumSubsequence;
	}
}
