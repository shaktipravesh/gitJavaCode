package com.java.leetCode.binarytree;

public class DiameterOfBinaryTree {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
    public int diameterOfBinaryTree(TreeNode root) {
    	int diameter = 0;
    	if(root != null) {
    		diameter = Math.max(getHeight(root.left) + getHeight(root.right), 
    							Math.max(diameterOfBinaryTree(root.left), diameterOfBinaryTree(root.right)));
    	}
    	return diameter;
    }

    private int getHeight(TreeNode root) {
		if(root == null) {
			return 0;
		}
		return 1 + Math.max(getHeight(root.left), getHeight(root.right));
	}
}


class TreeNode {
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