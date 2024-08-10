package com.java.algoNDataStucture.workat;

public class SquareRoot {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SquareRoot squareRoot = new SquareRoot();

		System.out.println(squareRoot.searchRoot(3460210));
		for(int i = 0; i <= 100000; i++) { System.out.println(i + ": "
		+squareRoot.searchRoot(i)); }

	}

	int volumeOfTrappedRainWater(int[] heights) {
	    // add your logic here
		int size = heights.length;
		int volumeOfTrappedRainWater = 0;
		int[] startMax = new int[size];
		int[] endMax = new int[size];
		int i =0;
		for(startMax[0] = heights[i], endMax[size-1] = heights[size-1], i = 1; i < size; i++) {
			startMax[i] = Math.max(startMax[i-1], heights[i]);
			endMax[size-i-1] = Math.max(endMax[size-i], heights[size-i-1]);
		}
		for(i = 0; i < size; i++) {
			volumeOfTrappedRainWater += Math.min(startMax[i], endMax[i]) - heights[i];
		}
		return volumeOfTrappedRainWater;
	}
	
	int searchRoot(int num) {
		long from = 1;
		long to = num;
		long iMid = 0;
		if (num == 0) {
			return 0;
		}
		while ((to - from) > 1) {
			iMid = (from + to) / 2;
			if (num == iMid * iMid) {
				return (int) iMid;
			}
			if (iMid * iMid > num) {
				to = iMid;
			} else {
				from = iMid;
			}
		}
		return (int) from;
	}
}
