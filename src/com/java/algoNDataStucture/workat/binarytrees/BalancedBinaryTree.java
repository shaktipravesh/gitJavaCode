package com.java.algoNDataStucture.workat.binarytrees;

import java.util.ArrayList;
import java.util.List;

public class BalancedBinaryTree {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	boolean isBinaryTreeBalanced(Node root) {
	    boolean isBTree = true;
	    if(root == null) {
	    	return isBTree;
	    }
	    int leftHeight = getHeight(root.left);
	    int rightHeight = getHeight(root.right);
	    if(Diffrence(leftHeight, rightHeight) > 1) {
	    	return false;
	    } else {
	    	isBTree = isBinaryTreeBalanced(root.left) && isBinaryTreeBalanced(root.right);
	    }
	    return isBTree;
	}
	
    private int Diffrence(int leftHeight, int rightHeight) {
		if(leftHeight > rightHeight) {
			return leftHeight - rightHeight;
		} else {
			return rightHeight - leftHeight;
		}
	}

	private int getHeight(Node root) {
		if(root == null) {
			return 0;
		}
		return 1 + Math.max(getHeight(root.left), getHeight(root.right));
	}

}
