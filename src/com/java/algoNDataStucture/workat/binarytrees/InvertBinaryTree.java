package com.java.algoNDataStucture.workat.binarytrees;

public class InvertBinaryTree {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	void invertTree(Node root) {
    	if(root == null) {
    		return;
    	}
    	Node temp = root.left;
    	root.left = root.right;
    	root.right = temp;
    	invertTree(root.left);
    	invertTree(root.right);
	}
}
