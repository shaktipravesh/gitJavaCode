package com.java.problems;

import java.util.Arrays;

public class IdenticalTwins {

	public static void main(String[] args) {
		int[] arr = {1, 2, 2, 3};
		int identicalTwins = 0;
		identicalTwins = getIdenticalTwinsCount(arr);
		System.out.println(identicalTwins);

	}

	static int getIdenticalTwinsCount (int[] arr) {
		int identicalTwins = 0;
		Arrays.sort(arr);
		for(int i =0; i < (arr.length - 1); i++) {
			for(int j = i+1; arr[i] == arr[j] && j < arr.length; j++){
				identicalTwins++;
			}
		}
		return identicalTwins;
	}
	
}

