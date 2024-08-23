package com.java.algoNDataStucture.workat.dp;

public class ClimbStairs {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ClimbStairs climbStairs = new ClimbStairs();
		climbStairs.climbStairs(45);
	}

	int climbStairs(int n) {
	    // add you logic here
		int[] distinctWays = new int[n+1];
		distinctWays[0] = 1;
		distinctWays[1] = 1;
		
		for(int i = 2; i <= n; i++) {
			distinctWays[i] = distinctWays[i-1] + distinctWays[i-2];
		}
		
		/*
		if(n < 2) {
			return 1;
		}
		distinctWays[n] = distinctWaysclimbStairs(distinctWays, n);
		*/
		return distinctWays[n];
	}

	private int distinctWaysclimbStairs(int[] distinctWays, int n) {
		// TODO Auto-generated method stub
		if(distinctWays[n] != 0) {
			return distinctWays[n];
		}
		return distinctWaysclimbStairs(distinctWays, n-2) + distinctWaysclimbStairs(distinctWays, n -1);
	}
	

}
