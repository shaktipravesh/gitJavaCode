package com.java.algoNDataStucture.workat.graphs;

import java.util.ArrayList;

public class DFSofAnGraphGraph {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

    ArrayList<Integer> dfs(ArrayList<Integer>[] adjList) {
    	ArrayList<Integer> inOrderList = new ArrayList<Integer>();
    	int iNode = 0;
    	boolean[] isVisited = new boolean[adjList.length];
    	getInOrderedList(inOrderList, iNode, adjList);
    	getInOrderedList(inOrderList, iNode, adjList, isVisited);
    	return inOrderList;
    }

	private void getInOrderedList(ArrayList<Integer> inOrderList, int iNode, ArrayList<Integer>[] adjList) {

		inOrderList.add(iNode);
		for(int i = 0; i < adjList[iNode].size(); i++) {
			int currNode = adjList[iNode].get(i);
			if(!inOrderList.contains(currNode)) {
				getInOrderedList(inOrderList, currNode, adjList);
			}
		}
	}
	
	private void getInOrderedList(ArrayList<Integer> inOrderList, int iNode, ArrayList<Integer>[] adjList, boolean[] isVisited) {

		inOrderList.add(iNode);
		isVisited[iNode] = true;
		for(int i = 0; i < adjList[iNode].size(); i++) {
			int currNode = adjList[iNode].get(i);
			if(isVisited[currNode] == false) {
				getInOrderedList(inOrderList, currNode, adjList, isVisited);
			}
		}
	}
}
