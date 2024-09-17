package com.java.algoNDataStucture.workat.dp;

public class CollectJewels {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	int getMaxValue (JewelStone[] stones, int capacity) {
		int maxValue = 0;
		int[][] valueMatrix = new int[stones.length][capacity+1];
		for(int i = 0; i <= capacity; i++) {
			if(stones[0].weight <= i) {
				valueMatrix[0][i] = stones[0].value;
			}
		}
		for(int i = 1; i < stones.length; i++) {
			for(int j = 1; j <= capacity; j++) {
				if(stones[i].weight <= j) {
					valueMatrix[i][j] = Math.max(stones[i].value + valueMatrix[i-1][j-stones[i].weight], valueMatrix[i-1][j]);
				} else {
					valueMatrix[i][j] =  valueMatrix[i-1][j];
				}
			}
		}
		maxValue = valueMatrix[stones.length-1][capacity];
		return maxValue;
	}
}

class JewelStone {
    int weight, value;
    JewelStone(int weight, int value) {
        this.weight = weight;
        this.value = value;
    }
}