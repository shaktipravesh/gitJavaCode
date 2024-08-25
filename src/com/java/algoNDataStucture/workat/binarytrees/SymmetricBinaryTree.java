package com.java.algoNDataStucture.workat.binarytrees;

public class SymmetricBinaryTree {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	boolean isSymmetric(Node root) {
		boolean isSymmetric = getSymmetricity(root.left, root.right);
		return isSymmetric;
	    
	}

	private boolean getSymmetricity(Node left, Node right) {
		if(left == null && right == null) {
			return true;
		}
		
		if((left == null && right != null) || (left != null && right == null)) {
			return false;
		}
		
		if(left != null && right != null && left.data != right.data) {
			return false;
		}
		
		return getSymmetricity(left.left, right.right) && getSymmetricity(left.right, right.left);
	}
}


/* This is the Node class definition

class Node {
	public Node left;
	public Node right;
	public int data;

	public Node(int data) {
		this.data = data;
	}
}
*/
