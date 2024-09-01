package com.java.algoNDataStucture.workat.hashing;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TwoSum {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	int[] twoSum(int[] A, int target) {
		int[] targetA = new int[2];
		int targetDiff = 0;
		Map<Integer, Integer> hashMap = new HashMap<Integer, Integer>();
	    for(int i = 0; i < A.length; i++) {
	    	targetDiff = target - A[i];
	    	if(hashMap.containsKey(targetDiff)) {
	    		targetA[0] = hashMap.get(targetDiff);
	    		targetA[1] = i;
	    		break;
	    	}
	    	hashMap.put(A[i], i);
	    }
	    return targetA;
	}
	
	
	List<List<Integer>> threeSum(int[] A) {
		Arrays.sort(A);
		List<List<Integer>> threeSumLists = new ArrayList<List<Integer>>();
		for(int i = 0; i < A.length; i++) {
			for(int j = i+1, k = A.length-1 ; j <k; j++, k--) {
				if(A[i] + A[j] + A[k] == 0) {
					List<Integer> threeSumList = new ArrayList<Integer>();
					threeSumList.add(i);
					threeSumList.add(j);
					threeSumList.add(k);
					threeSumLists.add(threeSumList);
				}
			}
		}
		
		return threeSumLists;
	}
}
