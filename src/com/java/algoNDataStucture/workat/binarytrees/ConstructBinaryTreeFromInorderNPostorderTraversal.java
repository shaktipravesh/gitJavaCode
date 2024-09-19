package com.java.algoNDataStucture.workat.binarytrees;

import java.util.stream.IntStream;

public class ConstructBinaryTreeFromInorderNPostorderTraversal {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		IntStream.range(1, 10).forEach(val -> System.out.println(val));
	}

	Node constructTree(int[] postorder, int[] inorder) {
    	Node root = null;
    	Node nodeIndex = null;
    	for(int i = postorder.length-1; i >= 0; i--) {
    		if(root == null) {
    			root = new Node( postorder[i]);
    			int index = getInOrderIndex(postorder[i], inorder);
    			nodeIndex = new Node(index);
    		} else {
    			int index = getInOrderIndex(postorder[i], inorder);
    			addCurrNode(postorder[i], index, root, nodeIndex);
    		}
    	}
    	return root;
	}

	private void addCurrNode(int postorder, int index, Node root, Node nodeIndex) {
		while(nodeIndex != null) {
			if(index < nodeIndex.data) {
				if(nodeIndex.left == null) {
					nodeIndex.left = new Node(index);
					root.left = new Node(postorder);
					break;
				} else {
					nodeIndex = nodeIndex.left;
					root = root.left;
				}
			} else {
				if(nodeIndex.right == null) {
					nodeIndex.right = new Node(index);
					root.right = new Node(postorder);
					break;
				} else {
					nodeIndex = nodeIndex.right;
					root = root.right;
				}
			}
		}
	}

	private int getInOrderIndex(int postorder, int[] inorder) {
		for(int index = 0; index < inorder.length; index++) {
			if(postorder == inorder[index]) {
				return index;
			}
		}
		return 0;
	}
	
}
