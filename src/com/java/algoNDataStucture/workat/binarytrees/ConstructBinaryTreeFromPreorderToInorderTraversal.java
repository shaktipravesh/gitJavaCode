package com.java.algoNDataStucture.workat.binarytrees;

public class ConstructBinaryTreeFromPreorderToInorderTraversal {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	Node constructTree(int[] preorder, int[] inorder) {
    	Node root = null;
    	Node nodeIndex = null;
    	for(int i = 0; i < preorder.length; i++) {
    		if(root == null) {
    			root = new Node( preorder[i]);
    			int index = getInOrderIndex(preorder[i], inorder);
    			nodeIndex = new Node(index);
    		} else {
    			int index = getInOrderIndex(preorder[i], inorder);
    			addCurrNode(preorder[i], index, root, nodeIndex);
    		}
    	}
    	return root;
	}

	private void addCurrNode(int preorder, int index, Node root, Node nodeIndex) {
		while(nodeIndex != null) {
			if(index < nodeIndex.data) {
				if(nodeIndex.left == null) {
					nodeIndex.left = new Node(index);
					root.left = new Node(preorder);
					break;
				} else {
					nodeIndex = nodeIndex.left;
					root = root.left;
				}
			} else {
				if(nodeIndex.right == null) {
					nodeIndex.right = new Node(index);
					root.right = new Node(preorder);
					break;
				} else {
					nodeIndex = nodeIndex.right;
					root = root.right;
				}
			}
		}
	}

	private int getInOrderIndex(int preorder, int[] inorder) {
		for(int index = 0; index < inorder.length; index++) {
			if(preorder == inorder[index]) {
				return index;
			}
		}
		return 0;
	}
}
