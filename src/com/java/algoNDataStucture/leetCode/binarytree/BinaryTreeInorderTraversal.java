package com.java.algoNDataStucture.leetCode.binarytree;

import java.util.ArrayList;
import java.util.List;

public class BinaryTreeInorderTraversal {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}


	public class TreeNode {
	 int val;
	 TreeNode left;
	 TreeNode right;
	 TreeNode() {}
	 TreeNode(int val) { this.val = val; }
	 TreeNode(int val, TreeNode left, TreeNode right) {
	     this.val = val;
	     this.left = left;
	     this.right = right;
	     }
	 }
	 
	void getInorderTraversalUtil(TreeNode root, List<Integer> traversal) {
		if (root == null) {
			return;
		}
		if(root.left != null) {
			getInorderTraversalUtil(root.left, traversal);
		}
		traversal.add(root.val);
		if(root.right != null) {
			getInorderTraversalUtil(root.right, traversal);
		}
	}
    public List<Integer> inorderTraversal(TreeNode root) {
		List<Integer> traversal = new ArrayList<Integer>();
		getInorderTraversalUtil(root, traversal);
		return traversal;
    }
}
