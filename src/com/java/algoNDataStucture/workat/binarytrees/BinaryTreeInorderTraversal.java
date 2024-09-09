package com.java.algoNDataStucture.workat.binarytrees;

import java.util.ArrayList;
import java.util.List;

public class BinaryTreeInorderTraversal {

	public static void main(String[] args) {
		BinaryTreeInorderTraversal binaryTreeInorderTraversal = new BinaryTreeInorderTraversal();
		binaryTreeInorderTraversal.getInorderTraversal(null);

	}

	void getInorderTraversalUtil(Node root, List<Integer> traversal) {
		if (root == null) {
			return;
		}
		if(root.left != null) {
			getInorderTraversalUtil(root.left, traversal);
		}
		traversal.add(root.data);
		if(root.right != null) {
			getInorderTraversalUtil(root.right, traversal);
		}
	}
	List<Integer> getInorderTraversal(Node root) {
		if(root == null) {
			return null;
		}
		List<Integer> traversal = new ArrayList<Integer>();
		getInorderTraversalUtil(root, traversal);
		return traversal;
	}
}
