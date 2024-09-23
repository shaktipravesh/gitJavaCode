package com.java.algoNDataStucture.workat.graphs;

import java.util.ArrayList;

public class DetectCycleInDirectedGraph {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	boolean isCyclic(ArrayList<Integer>[] adjList) {
		int V = adjList.length;
		boolean[] visited = new boolean[V];
		boolean[] recStack = new boolean[V];
		for (int i = 0; i < V; i++) {
			if (!visited[i] && isCyclicUtil(adjList, i, visited, recStack)) {
				return true;
			}
		}

		return false;
	}
	private static boolean isCyclicUtil(ArrayList<Integer>[] adj, int u, boolean[] visited, boolean[] recStack) {

		if (!visited[u]) {
			visited[u] = true;
			recStack[u] = true;

			for (int x : adj[u]) {
				if (!visited[x] && isCyclicUtil(adj, x, visited, recStack)) {
					return true;
				} else if (recStack[x]) {
					return true;
				}
			}
		}
		recStack[u] = false;
		return false;
	}
}
