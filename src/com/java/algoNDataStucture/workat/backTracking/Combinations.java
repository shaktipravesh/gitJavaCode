package com.java.algoNDataStucture.workat.backTracking;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Combinations {

	public static void main(String[] args) {
		int n = 4;
		int k = 2;
		Combinations combinations = new Combinations();
		combinations.combinations(n, k);
		System.out.println(combinations.combinations(n, k));

	}

	
	public void combinationsUtil(int curr, int n, int k, List<List<Integer>> result, List<Integer> current) {
		if (k == 0) {
			result.add(new ArrayList<>(current));
		}

		for (int i = curr; i <= n; i++) {
			current.add(i);
			combinationsUtil(i + 1, n, k - 1, result, current);
			current.remove(current.size() - 1);
		}
	}

	List<List<Integer>> combinations(int n, int k) {
	    // add your logic here
		List<List<Integer>> result = new ArrayList<List<Integer>>();
		List<Integer> current = new ArrayList<Integer>();
		combinationsUtil(1, n, k, result, current);
		return result;
	}
	
	
	List<List<Integer>> combinationsMy(int n, int k) {
		List<List<Integer>> combinationSumList = new LinkedList<List<Integer>>();
		List<Integer> combination = new ArrayList<Integer>();
		int start = 1;
		int end = n;
		int combinationSize = k;
		getCombination(start, end, combinationSumList, combination, combinationSize);
		return combinationSumList;
	}
	private void getCombination(int start, int end, List<List<Integer>> combinationSumList, List<Integer> combination, int combinationSize) {
		if(combination.size() == combinationSize) {
			combinationSumList.add(new ArrayList<>(combination));
			return;
		}
		
		for (int i = start; i <= end; i++) {
			combination.add(i);
			getCombination(i+1, end, combinationSumList, combination, combinationSize);
			combination.remove(combination.size() - 1);
		}
		
		combination.add(start); getCombination(start+1, end, combinationSumList,
		combination, combinationSize); combination.remove(combination.size()-1);
		getCombination(start+1, end, combinationSumList, combination,
		combinationSize);
		
	}
	
	private void getCombination1(int start, int end, List<List<Integer>> combinationSumList, List<Integer> combination, int combinationSize) {
		if(combination.size() == combinationSize) {
			combinationSumList.add(new ArrayList<>(combination));
			return;
		}
		
		for (int i = start; i <= end; i++) {
			combination.add(i);
			getCombination(i+1, end, combinationSumList, combination, combinationSize);
			combination.remove(combination.size() - 1);
		}		
	}
}
