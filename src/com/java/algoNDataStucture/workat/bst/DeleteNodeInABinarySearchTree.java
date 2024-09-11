package com.java.algoNDataStucture.workat.bst;

public class DeleteNodeInABinarySearchTree {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	Node removeFromBst(Node root, int key) {
		if(root == null) {
			return root;
		}
		Node newRoot = null;
		Node keyNode = getKeyNode(root, key);
		System.out.println(keyNode.data);
		return newRoot;
	}

	private Node getKeyNode(Node root, int key) {
	    if (root == null) {
			return null;
		}
		if (root.data > key) {
			root.left = removeFromBst(root.left, key);
			return root;
		} 
		if (root.data < key) {
			root.right = removeFromBst(root.right, key);
			return root;
		}
		if (root.left == null) {
			return root.right;
		} 
		if (root.right == null) {
			return root.left;
		}
		Node currNode = root.left;
		while (currNode.right != null) {
			currNode = currNode.right;
		}
		currNode.right = root.right;
		return root.left;
		
		/*
		Node currNode = root.right;
		while (currNode.left != null) {
			currNode = currNode.left;
		}
		currNode.left = root.left;
		return root.right;
		
		*/
	}

}
