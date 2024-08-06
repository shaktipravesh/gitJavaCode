package com.java.algoNDataStucture;

public class PascalTraingle {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Solution solution = new Solution();
		solution.pascalTriangleRow(5);
		System.out.println(solution.pascalTriangleRow(5));
	}

}


class Solution {
	int[][] pascalTriangle = new int[30][30];
	
	int[] pascalTriangleRow(int rowNo) {
		return pascalTriangle[rowNo-1];
		
	}

	public Solution() {
		super();
		for(int i = 0; i < 30; i++) {
			pascalTriangle[i][0] = 1;
		}
		for(int i = 1; i < 30; i++) {
			for(int j = 1; j < i; j++) {
				pascalTriangle[i][j] = pascalTriangle[i-1][j-1] + pascalTriangle[i-1][j];
			}
		}
	}

}