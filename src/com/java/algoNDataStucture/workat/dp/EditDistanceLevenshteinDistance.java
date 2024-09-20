package com.java.algoNDataStucture.workat.dp;

public class EditDistanceLevenshteinDistance {

	public static void main(String[] args) {
		EditDistanceLevenshteinDistance editDistanceLevenshteinDistance = new EditDistanceLevenshteinDistance();
		editDistanceLevenshteinDistance.minOperations("hello", "seldom");

	}

	int minOperations(String s1, String s2) {
		int[][] minOperationMatrix = new int[s1.length()+1][s2.length()+1];
		for(int i = 0; i <= s1.length(); i++) {
			minOperationMatrix[i][0] = i;
		}
		for(int i = 0; i <= s2.length(); i++) {
			minOperationMatrix[0][i] = i;
		}
		for(int i = 1; i <= s1.length(); i++) {
			for(int j = 1; j <= s2.length(); j++) {
				if(s1.charAt(i-1) == s2.charAt(j-1)) {
					minOperationMatrix[i][j] = minOperationMatrix[i-1][j-1];
				} else {
					minOperationMatrix[i][j] = Math.min(minOperationMatrix[i-1][j-1], Math.min(minOperationMatrix[i-1][j], minOperationMatrix[i][j-1])) + 1;
				}
			}
		}
		return minOperationMatrix[s1.length()][s2.length()];
	}
}
