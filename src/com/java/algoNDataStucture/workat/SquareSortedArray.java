package com.java.algoNDataStucture.workat;

import java.util.Arrays;

public class SquareSortedArray {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr = {6, -8, 3, -1, 4};
		SquareSortedArray sqsa = new SquareSortedArray();
		sqsa.getSquareSortedArray(arr);
		System.out.println(arr);
	}

	int[] getSquareSortedArray (int[] arr) {
		// add your logic here
		
		for(int i = 0; i < arr.length; i++){
			arr[i] = arr[i]*arr[i];
		}
		Arrays.sort(arr);
		return arr;
	}
}
