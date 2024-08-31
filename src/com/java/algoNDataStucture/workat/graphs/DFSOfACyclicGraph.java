package com.java.algoNDataStucture.workat.graphs;

import java.util.ArrayList;
import java.util.Scanner;

public class DFSOfACyclicGraph {

	public static void main(String[] args) {
		DFSOfACyclicGraph dfsOfACyclicGraph = new DFSOfACyclicGraph();
		try (Scanner sc = new Scanner(System.in)) {
			int iTCs = sc.nextInt();
			for(int i = 0; i < iTCs; i++) {
				int iNodes = sc.nextInt();
				ArrayList<Integer>[] adjList = new ArrayList[iNodes];
				for(int j = 0; j < iNodes; j++) {
					int iConnect = sc.nextInt();
					ArrayList<Integer> connetedNodes = new ArrayList<Integer>();
					for(int k = 0; k < iConnect; k++) {
						connetedNodes.add(sc.nextInt());
					}
					adjList[j].addAll(connetedNodes);
				}
				ArrayList<Integer> dfsList = dfsOfACyclicGraph.dfs(adjList);
				System.out.println(dfsList);
			}
		}

	}
	

	ArrayList<Integer> dfs(ArrayList<Integer>[] adjList) {
    	ArrayList<Integer> dfsList = new ArrayList<Integer>();
    	int start = 0;
    	getDFSList(adjList, start, dfsList);
    	return dfsList;
    }

	private void getDFSList(ArrayList<Integer>[] adjList, int start, ArrayList<Integer> dfsList) {
		if(!dfsList.contains(start)) {
			dfsList.add(start);
			for(int i = 0; i < adjList[start].size(); i++) {
				getDFSList(adjList, adjList[start].get(i), dfsList);
			}
		}
		
	}
}
