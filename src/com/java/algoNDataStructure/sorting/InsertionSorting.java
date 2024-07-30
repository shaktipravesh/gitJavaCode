package com.java.algoNDataStructure.sorting;

import java.util.Collections;
import java.util.Scanner;

public class InsertionSorting {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr = {4, 2, 5, 3, 1};
		insertionSort(arr);
		
		
	}
	static void insertionSort (int[] arr) {
		for(int i = 1; i < arr.length; i++){
			for(int j = 0; j < i; j++){
				if(arr[j] >= arr[i]){
					int num = arr[i];
					for(int k = i; k >j; k--) {
						arr[k] = arr[k-1];
					}
					arr[j] = num;
				}
			}
		}
		System.out.println(arr);
	}

}
