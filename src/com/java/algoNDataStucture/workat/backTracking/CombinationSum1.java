package com.java.algoNDataStucture.workat.backTracking;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class CombinationSum1 {


	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] A = {1, 2};
		int val = 4;
		CombinationSum1 combinationSum1 = new CombinationSum1();
		combinationSum1.combinationSum(A, val);

	}

	List<List<Integer>> combinationSumList = new LinkedList<List<Integer>>();
	List<List<Integer>> combinationSum(int[] A, int val) {
		combinationSumList.clear();
		int sumValue = val;
		List<Integer> sumList = new ArrayList<Integer>();
		int start = 0;
		getCombinationSum(A, start, sumList, sumValue);
		return combinationSumList;
	}


	private void getCombinationSum(int[] A, int start, List<Integer> sumList, int sumValue) {

		if(sumValue == 0) {
			combinationSumList.add(new ArrayList<>(sumList));
			return;
		} else if(start >= A.length || sumValue < 0) {
			return;
		}
		if(start < A.length) {
			sumList.add(A[start]);
			getCombinationSum (A, start, sumList, sumValue-A[start]);
			sumList.remove(sumList.size()-1);
			getCombinationSum(A, start+1, sumList, sumValue);  
		}
	}
	
	
	
	void findAllCombinations (int[] A, int target, int index, List<List<Integer>> result, List<Integer> current) {
		if (target == 0) {
			result.add(new ArrayList<>(current));
			return;
		}
		if (index == A.length || target < 0 ) {
			return;
		}
		current.add(A[index]);
		findAllCombinations (A, target - A[index], index, result, current);
		current.remove(current.size()-1);
		findAllCombinations(A, target, index+1, result, current);      
	}
	
	List<List<Integer>> combinationSumAproach(int[] A, int val) {
		List<List<Integer>> result = new ArrayList<List<Integer>>();
		List<Integer> current = new ArrayList<Integer>();
		findAllCombinations(A, val, 0, result, current);
		return result;
	}
	
}
