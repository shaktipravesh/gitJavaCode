package com.java.algoNDataStucture.workat.graphs;

import java.util.ArrayList;

public class AdjacencyMatrixtoAdjacencyList {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[][] matrix = {{0, 1, 1, 1,},{1, 0, 0, 0}, {1, 0, 0, 1}, {1, 0, 1, 0}};
		AdjacencyMatrixtoAdjacencyList adjacencyList = new AdjacencyMatrixtoAdjacencyList();
		adjacencyList.matrixToAdjList(4, matrix);

	}

    ArrayList<Integer>[] matrixToAdjList(int n, int[][] matrix) {
        // add your logic here
		ArrayList<Integer>[] adjList = new ArrayList[n];
		for(int i = 0; i < n; i++) {
			adjList[i] = new ArrayList<Integer>();
			for(int j = 0; j < n; j++) {
				if(matrix[i][j] == 1) {
					adjList[i].add(j);
				}
			}
		}
		return adjList;
    }
}
