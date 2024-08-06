package com.java.algoNDataStucture;

import java.util.Map;
import java.util.Map.Entry;
import java.util.TreeMap;

public class MapOverlappingIntervals {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[][] intervals = {{1, 2}, {2, 3}, {1, 4}, {1, 3}, {5, 6}};
		MapOverlappingIntervals mapOverlappingIntervals = new MapOverlappingIntervals();
		mapOverlappingIntervals.mergeIntervals(intervals);

	}

	int[][] mergeIntervals(int[][] intervals) {
	    // add your logic here
		int[][] uniqueTempIntervals;
		int iNum = 30;
		int isqrt = (int) Math.sqrt(iNum);
		TreeMap<Integer, Integer> treeMap = new TreeMap<Integer, Integer>();
		for(int i = 0; i < intervals.length; i++) {
			//treeMap.put(intervals[i][0], intervals[i][1]);
			if(treeMap.containsKey(intervals[i][0])) {
				int iValue = treeMap.get(intervals[i][0]);
				if(iValue < intervals[i][1]) {
					treeMap.put(intervals[i][0], intervals[i][1]);
				}
			} else {
				treeMap.put(intervals[i][0], intervals[i][1]);
			}
		}
		uniqueTempIntervals = new int[treeMap.size()][2];
		int i = 0;
		for(Entry<Integer, Integer> entry : treeMap.entrySet()) 
	    {
	      Integer key = entry.getKey();
	      Integer value = entry.getValue();
	      if(i == 0) {
	    	  uniqueTempIntervals[i][0] = key;
	    	  uniqueTempIntervals[i++][1] = value;
	      } else {
	    	  if(key <= uniqueTempIntervals[i-1][1]) {
	    		  if(value > uniqueTempIntervals[i-1][1]) {
	    			  uniqueTempIntervals[i-1][1] = value;
	    		  }
	    	  } else {
	    		  uniqueTempIntervals[i][0] = key;
	    		  uniqueTempIntervals[i][1] = value;
		    	  i++;
	    	  }
	      }
		}
		int[][] uniqueIntervals = new int[i][2];
		for(int j = 0; j < i; j++) {
			uniqueIntervals[j][0] = uniqueTempIntervals[j][0];
			uniqueIntervals[j][1] = uniqueTempIntervals[j][1];
		}
		
		return uniqueIntervals;
	}
}
