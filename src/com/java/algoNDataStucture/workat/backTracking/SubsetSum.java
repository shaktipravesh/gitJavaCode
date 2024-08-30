package com.java.algoNDataStucture.workat.backTracking;

public class SubsetSum {

	public static void main(String[] args) {
		int[] arr = {1, 3, 4, 9, 2};
		SubsetSum subsetSum = new SubsetSum();
		System.out.println(subsetSum.hasValidSubset(arr, 13));

	}

	boolean hasValidSubset(int[] A, int target) {
		boolean validSubset = false;
		int subsetSum = 0;
		int start = 0;
		validSubset = checkValidSubset(A, start, subsetSum, target);
		return validSubset;
	}

	private boolean checkValidSubset(int[] A, int start, int subsetSum, int target) {
		if(subsetSum == target) {
			return true;
		}
		if(start < A.length) {
			return checkValidSubset(A, start+1, subsetSum, target) ||checkValidSubset(A, start+1, subsetSum + A[start], target);
		}
		return false;
	}
}
