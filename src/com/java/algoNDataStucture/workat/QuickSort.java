package com.java.algoNDataStucture.workat;

public class QuickSort {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int[] arr = {9, 8, 10, 7,1,5};
		//int[] arr = {8, 2, 4, 7, 1, 3, 9, 6, 5};
		QuickSort qs = new QuickSort();
		qs.quickSort(arr, 0, arr.length-1);
		System.out.println(arr);
	}
	
	void quickSort(int[] arr, int start, int end){
		if(start < end) {
			int pivot = quickPartition(arr, start, end);
			if(pivot > start) {
				quickSort(arr, start, pivot-1);
			}
			if(pivot < end) {
				quickSort(arr, pivot + 1, end);
			}
		}
	}
	
	int quickPartition(int[] arr, int start, int end) {
		int pivot = start;
		for(int i = start; i <= end; i++) {
			if(arr[i] < arr[end]) {
				//swap
				swap(arr, i, pivot);
				pivot++;
			}
		}
		swap(arr, pivot, end);
		
		return pivot;
	}
	void swap(int[] arr, int from, int to){
		int iTemp = arr[from];
		arr[from] = arr[to];
		arr[to] = iTemp;
	}

}
