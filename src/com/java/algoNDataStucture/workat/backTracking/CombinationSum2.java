package com.java.algoNDataStucture.workat.backTracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class CombinationSum2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int[] A = {10, 1, 2, 7, 6, 1, 5};
		int val = 8;
		CombinationSum2 combinationSum2 = new CombinationSum2();
		combinationSum2.combinationSum(A, val);
	}

	List<List<Integer>> combinationSumList = new LinkedList<List<Integer>>();
	List<List<Integer>> combinationSum(int[] A, int val) {
		combinationSumList.clear();
		Arrays.sort(A);
		int sumValue = val;
		List<Integer> sumList = new ArrayList<Integer>();
		int start = 0;
		getCombinationSum(A, start, sumList, sumValue);
		return combinationSumList;
	}


	private void getCombinationSum(int[] A, int start, List<Integer> sumList, int sumValue) {

		if(sumValue == 0) {
			if(!combinationSumList.contains(sumList)) {
				combinationSumList.add(new ArrayList<>(sumList));
			}
			return;
		} else if(start >= A.length || sumValue < 0) {
			return;
		}
		if(start < A.length) {
			sumList.add(A[start]);
			getCombinationSum (A, start +1, sumList, sumValue-A[start]);
			sumList.remove(sumList.size()-1);
			getCombinationSum(A, start+1, sumList, sumValue);  
		}
	}
}
