package com.java.algoNDataStucture.workat.graphs;

import java.util.ArrayList;

public class EdgestoAdjacencyList {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

    ArrayList<Integer>[] edgesToAdjList(int n, int[][] edges) {
        // add logic here
		ArrayList<Integer>[] adjList = new ArrayList[n];
		for(int i = 0; i < n; i++) {
			adjList[i] = new ArrayList<Integer>();
		}
		
		for(int i = 0; i < edges.length; i++) {
			adjList[edges[i][0]].add(edges[i][1]);
			if (edges[i][0] == edges[i][1]) {
				continue;
			}
			adjList[edges[i][1]].add(edges[i][0]);
		}
		
		return adjList;
    }
}
