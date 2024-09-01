package com.java.algoNDataStucture.workat.hashing;

import java.util.Arrays;

public class ImplementCountingSort {

	public static void main(String[] args) {
		int[] arr = {2,5,3,0,2,3,0,3};
		ImplementCountingSort  implementCountingSort = new ImplementCountingSort();
		implementCountingSort.countingSort(arr);
		System.out.println(arr);

		
	}

	void countingSort (int[] arr) {
		int iMax = Arrays.stream(arr).max().getAsInt();
		int[] countArray = new int[iMax+1];
		int[] outputArray = new int[arr.length];
		for(int i = 0; i < arr.length; i++) {
			countArray[arr[i]]++;
		}
		for(int i = 1; i < countArray.length; i++) {
			countArray[i] += countArray[i-1];
		}
		
		for(int i = arr.length-1; i >=0; i--) {
			outputArray[countArray[arr[i]]-1] = arr[i];
			countArray[arr[i]]--;
		}
		System.out.println(outputArray);
	}
	
	void countingSortWorkAt (int[] arr) {
		int[] output = new int[arr.length + 1];
		int maximum = Integer.MIN_VALUE;
		for(int i = 0; i < arr.length; i++) {
			maximum = Math.max(maximum, Math.abs(arr[i]));
		}
		int[] count = new int[2 * maximum + 2];
		for(int i = 0; i < arr.length; i++) {
			arr[i] += maximum;
		}
		for(int i = 0; i < arr.length; i++) {
			count[arr[i]]++;
		}
		for(int i = 1; i <= 2 * maximum + 1; i++) {
			count[i] += count[i - 1];
		}
		for(int i = 0; i < arr.length; i++) {
			output[count[arr[i]] - 1] = arr[i];
			count[arr[i]]--;
		}
		for(int i = 0; i < arr.length; i++) {
			arr[i] = output[i] - maximum;
		}
	}
}
