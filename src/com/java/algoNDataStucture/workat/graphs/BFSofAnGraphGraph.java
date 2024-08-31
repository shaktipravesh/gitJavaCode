package com.java.algoNDataStucture.workat.graphs;

import java.util.ArrayList;
import java.util.Scanner;

public class BFSofAnGraphGraph {

	public static void main(String[] args) {
		BFSofAnGraphGraph bfsOfACyclicGraph = new BFSofAnGraphGraph();
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
				ArrayList<Integer> dfsList = bfsOfACyclicGraph.bfs(adjList);
				System.out.println(dfsList);
			}
		}

	}
	
    ArrayList<Integer> bfs(ArrayList<Integer>[] adjList) {
    	ArrayList<Integer> bfsList = new ArrayList<Integer>();
    	int start = 0;
    	bfsList.add(start);
    	for(int i = 0; i < bfsList.size(); i++) {
    		int iValue = bfsList.get(i);
    		for(int j = 0; j < adjList[iValue].size(); j++) {
    			if(!bfsList.contains(adjList[iValue].get(j))) {
    				bfsList.add(adjList[iValue].get(j));
    			}
    		}
    	}
    	return bfsList;
    }

}
