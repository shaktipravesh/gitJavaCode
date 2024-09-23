package com.java.algoNDataStucture.workat.graphs;

import java.util.ArrayList;
import java.util.Scanner;

public class DetectCycleInUndirectedGraph {

	public static void main(String[] args) {
		DetectCycleInUndirectedGraph detectCycleInUndirectedGraph = new DetectCycleInUndirectedGraph();
		try (Scanner sc = new Scanner(System.in)) {
			int iTCs = sc.nextInt();
			for(int i = 0; i < iTCs; i++) {
				int iNodes = sc.nextInt();
				ArrayList<Integer>[] adjList = new ArrayList[iNodes];
				for(int j = 0; j < iNodes; j++) {
					int iLink = sc.nextInt();
					ArrayList<Integer> linkedNodes = new ArrayList<Integer>();
					for(int k = 0; k < iLink; k++) {
						linkedNodes.add(sc.nextInt());
					}
					adjList[j] = linkedNodes;
				}
				detectCycleInUndirectedGraph.isCyclic(adjList);
			}
		}

	}

    boolean isCyclic(ArrayList<Integer>[] adjList) {
        int V = adjList.length;
		boolean[] visited = new boolean[V]; 
		for (int u = 0; u < V; u++) { 
			if (!visited[u]) { 
				if (isCyclicUtil(u, adjList, visited, -1))
				return true;
			}
		}
		return false;
    }
       
	static boolean isCyclicUtil(int v, ArrayList<Integer>[] adjList, boolean[] visited, int parent) {
		visited[v] = true;
		for (int i : adjList[v]) {
			if (!visited[i]) {
				if (isCyclicUtil(i, adjList, visited, v))
					return true;
			} else if (i != parent)
				return true;
		}
		return false;
	}
}
