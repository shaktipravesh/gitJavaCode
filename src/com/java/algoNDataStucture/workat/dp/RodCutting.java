package com.java.algoNDataStucture.workat.dp;

public class RodCutting {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	int maximumProfit(int n, int[] prices) {
	    int maxProfit = 0;
	    for(int i = 0; i < n; i++) {
	    	maxProfit = Math.max(maxProfit, getMaxProfit(i, prices));
	    }
	    return maxProfit;
	}

	private int getMaxProfit(int n, int[] prices) {
		int[][] profitMatrix = new int[n+1][n+1];
		for(int i = 1; i <=n; i++) {
			for(int j = 1; j <=n; j++) {
				if(j < i) {
					profitMatrix[i][j] = profitMatrix[i-1][j]; 
				} else {
					profitMatrix[i][j] = Math.max(profitMatrix[i][j-i] + prices[i-1], profitMatrix[i-1][j]);
				}
			}
		}
		return profitMatrix[n][n];
	}
}
