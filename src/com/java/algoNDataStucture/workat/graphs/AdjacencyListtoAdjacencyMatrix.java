package com.java.algoNDataStucture.workat.graphs;

import java.util.ArrayList;

public class AdjacencyListtoAdjacencyMatrix {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

    int[][] adjListToMatrix(int n, ArrayList<Integer>[] adjList) {
        // add your logic here
		int[][] adjMatrix = new int[n][n];
		for(int i = 0; i < adjList.length; i++) {
			for(int j = 0; j < adjList[i].size(); j++) {
				adjMatrix[i][adjList[i].get(j)] = 1;
			}
		}
		
		return adjMatrix;
    }
}
