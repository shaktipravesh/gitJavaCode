package com.java.algoNDataStucture.workat;

import java.util.HashSet;

public class MaximumKSubstringVowels {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	int maxKSubarraySum (int[] A, int k) {
		int maxSubArraySum = 0;
		int subArraySum = 0;
		
		for(int i = 0; i < A.length; i++) {
			subArraySum += A[i];
			if(i-k >= 0){
				subArraySum -= A[i-k];
			}
			if(maxSubArraySum < subArraySum) {
				maxSubArraySum = subArraySum;
			}
		}
		return maxSubArraySum;
	}
	int[] kSubstringVowels (String s, int k) {
		// add your logic here
		int[] aVowelCount = new int[s.length() - k + 1];
		int kVowelCount = 0;
		HashSet<Character> hashSet = new HashSet<Character>();
		hashSet.add('a');
		hashSet.add('e');
		hashSet.add('i');
		hashSet.add('o');
		hashSet.add('u');
		for(int i = 0; i < s.length(); i++) {
			if(hashSet.contains(s.charAt(i))){
				kVowelCount++;
			}
			if(i-k >= 0) { 
				if(hashSet.contains(s.charAt(i-k))) {
					kVowelCount--;
				}
			}
			if((i-k +1) >=0) {
				aVowelCount[i-k+1] = kVowelCount;
			}
		}
		return aVowelCount;
	}
	
	int maxKSubstringVowels (String s, int k) {
		int maxVowelCount = 0;
		int kVowelCount = 0;
		HashSet<Character> hashSet = new HashSet<Character>();
		hashSet.add('a');
		hashSet.add('e');
		hashSet.add('i');
		hashSet.add('o');
		hashSet.add('u');
		
		for(int i = 0; i < s.length(); i++) {
			if(hashSet.contains(s.charAt(i))){
				kVowelCount++;
			}
			if(i-k >= 0 && hashSet.contains(s.charAt(i-k))){
				kVowelCount--;
			}
			if(maxVowelCount < kVowelCount) {
				maxVowelCount = kVowelCount;
			}
		}
		
		
		return maxVowelCount;
		// add your logic here
	}
}
