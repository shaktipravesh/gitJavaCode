package com.java.algoNDataStucture.workat;

public class SearchRotatedSortedArray {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] rotatedSortedArray = {4, 5, 6, 7, 0, 1, 2};//{3, 4, 5, 6, 7, 8, 9, 10, 1, 2};//{4, 5, 6, 7, 1, 2, 3};
		SearchRotatedSortedArray searchRotatedSortedArray = new SearchRotatedSortedArray();
		System.out.println(searchRotatedSortedArray.getElementIndex(rotatedSortedArray, 6));
		
		int[] array = {-1, -1, -1, 1, 1, 1, 2};
		int Number = 1;
		System.out.println(searchRotatedSortedArray.getNextGreaterElement(array, Number));
	}

	int getNextGreaterElement (int[] arr, int key) {
		// add your logic here
		
		if(key < arr[0]) {
			return arr[0];
		}
		if(key >= arr[arr.length-1]) {
			return arr[arr.length-1];
		}
		
		int from = 0, to = arr.length-1; 
		int iMid = 0;
		while( from != to) {
			iMid = (from + to) / 2;
			if(arr[iMid] == key || iMid == from) {
				break;
			}
			if(arr[iMid] > key) {
				to = iMid;
			} else {
				from = iMid;
			}
		}
		while(arr[iMid] <= key) {
			iMid++;
		}
		return arr[iMid];
	}
	
	int getElementIndex(int[] array, int target) {
	    // add your logic here
		int index = -1;
		int rotationIndex = 0;
		int from =0, to = array.length - 1, iMid = 0;
		while(from != to) {
			iMid = (from + to) / 2;
			if(iMid == from) {
				rotationIndex = iMid;
				break;
			}
			if(array[iMid] > array[to]) {
				from = iMid;
			} else {
				to = iMid;
			}
		}
		
		if(target <= array[array.length -1]) {
			from = rotationIndex;
			to = array.length-1;
		} else {
			from = 0; 
			to = rotationIndex;
		}
		
		while( from != to) {
			iMid = (from + to) / 2;
			if(array[iMid] == target) {
				index = iMid; 
				break;
			}
			if(iMid == from) {
				if(array[to] == target) {
					index = to;
				}
				break;
			}
			if(array[iMid] > target) {
				to = iMid;
			} else {
				from = iMid;
			}
		}
		
		return index;
	}
}
