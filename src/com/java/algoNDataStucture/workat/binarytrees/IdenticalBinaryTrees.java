package com.java.algoNDataStucture.workat.binarytrees;

public class IdenticalBinaryTrees {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}


	boolean areIdenticalTrees(Node root1, Node root2) {
	    // add logic here
		boolean identicalTrees = true;
		identicalTrees = getIdenticity(root1, root2);
		return identicalTrees;
	}


	private boolean getIdenticity(Node root1, Node root2) {
		if(root1 == null && root2 == null) {
			return true;
		}
		
		if((root1 == null && root2 != null) || (root1 != null && root2 == null)) {
			return false;
		}
		
		if(root1 != null && root2 != null && root1.data != root2.data) {
			return false;
		}
		
		return getIdenticity(root1.left, root2.left) && getIdenticity(root1.right, root2.right);
	}
}

/* This is the Node class definition */

class Node {
	public Node left;
	public Node right;
	public int data;

	public Node(int data) {
		this.data = data;
	}
}


