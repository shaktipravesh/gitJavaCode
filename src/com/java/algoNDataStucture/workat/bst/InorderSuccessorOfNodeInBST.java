package com.java.algoNDataStucture.workat.bst;

public class InorderSuccessorOfNodeInBST {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	Node findSuccessor(Node root, Node p) {
		Node successorNode = null;
		successorNode = findSuccessorNode(successorNode, root, p);
		return successorNode;
	}

	private Node findSuccessorNode(Node successorNode, Node root, Node p) {
		if(root.left != null) {
			successorNode = findSuccessorNode(successorNode, root.left, p);
		}
		if(successorNode == null && root.data > p.data) {
			successorNode = root;
		} else if (successorNode != null && root.data > p.data && successorNode.data > root.data) {
			successorNode = root;
		}
		if(root.right != null) {
			successorNode = findSuccessorNode(successorNode, root.right, p);
		}
		return successorNode;
	}

	Node findPredecessor(Node root, Node p) {
		Node predecessorNode = null;
		predecessorNode = findPredecessorNode(predecessorNode, root, p);
		return predecessorNode;
	}

	private Node findPredecessorNode(Node predecessorNode, Node root, Node p) {
		if(root.right != null) {
			predecessorNode = findPredecessorNode(predecessorNode, root.right, p);
		}
		if(predecessorNode == null && root.data < p.data) {
			predecessorNode = root;
		} else if (predecessorNode != null && root.data < p.data && predecessorNode.data < root.data) {
			predecessorNode = root;
		}
		if(root.left != null) {
			predecessorNode = findPredecessorNode(predecessorNode, root.left, p);
		}
		return predecessorNode;
	}
	
	
	Node removeFromBst(Node root, int key) {
		Node removeNodeRoot = findParentNode(root, key);
		
		return root;
	}

	private Node findParentNode(Node root, int key) {
		if(root != null) {
			return root;
		}
		return null;
	}
}


class Node {
	public Node left;
	public Node right;
	public int data;

	public Node(int data) {
		this.data = data;
	}
}