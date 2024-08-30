package com.java.algoNDataStucture.workat.backTracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Subsets {

	public static void main(String[] args) {
		int[] A = {3, 1, 3, 5};
		int iTCs = 0; 
		Scanner sc = new Scanner(System.in);
		Subsets subsets = new Subsets();
		System.out.println(subsets.subsets(A));
		iTCs = sc.nextInt();
		for(int i = 0; i < iTCs; i++) {
			int size = sc.nextInt();
			int[] array = new int[size];
			for(int j = 0; j < size; j++) {
				array[j] = sc.nextInt();
			}
			
			System.out.println(subsets.subsets(array));
		}
	}

	void getSubsets(int[] A, int start, List<Integer> currSubset, List<List<Integer>> allSubsets) {
		if (start == A.length) {
			if(!allSubsets.contains(currSubset)) {
				allSubsets.add(new ArrayList(currSubset));
			}
			return;
		}
		int newStart = start + 1;
		getSubsets(A, newStart, currSubset, allSubsets);
		currSubset.add(A[start]);
		getSubsets(A, newStart, currSubset, allSubsets);
		currSubset.remove(currSubset.size() - 1);
	}
	List<List<Integer>> subsets(int[] A) {
		Arrays.sort(A);
		List<List<Integer>> allSubsets = new ArrayList<>();
		List<Integer> currSubset = new ArrayList<>();
		getSubsets(A, 0, currSubset, allSubsets);
		return allSubsets;
	}
	
	/*
	List<List<Integer>> subsets(int[] A) {
		List<List<Integer>> subSets = new ArrayList<List<Integer>>();
		Arrays.sort(A);
		List<Integer> nullSet = new ArrayList<Integer>();
		nullSet.add(null);
		subSets.add(nullSet);
		
		for(int i = 0; i < A.length; i++) {
			List<Integer> firstSet = new ArrayList<Integer>();
			firstSet.add(A[i]);
			subSets.add(firstSet);
			for(int j = i; j < A.length; j++) {

				for(int k = j+1; k < A.length; k++) {
					List<Integer> subSet = new ArrayList<Integer>();
					subSet.add(A[i]);
					for(int m = j+1; m <= k; m++) {
						subSet.add(A[m]);
					}
					subSets.add(subSet);
				}
				
			}
		}
		return subSets;
	}
	*/
	
}
