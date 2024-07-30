package com.java.algoNDataStucture;

public class BinarySearchTree {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}

class BST {
	static class Node {
		int num;
		Node left, right;
	}
	
	static Node newNode(int key) {
		Node temp = new Node();
		temp.num = key;
		temp.left = temp.right = null;
		return temp;
	}
	
	static Node insertNode(Node node, int key) {
		if(node == null) {
			return newNode(key);
		}
		
		if(key < node.num) {
			insertNode(node.left, key) ;
		} else if(key > node.num) {
			insertNode(node.right, key);
		}
		return node;
	}
	
	static Node deleteNode(Node root, int key) {
		if(root == null) {
			return root;
		}
		
		if(key < root.num) {
			deleteNode(root.left, key);
		} else if(key > root.num) {
			deleteNode(root.right, key);
		} else {
			if(root.left == null) {
				Node temp = root.right;
				return temp;
			} else if(root.right == null) {
				Node temp = root.left;
				return temp;
			}
			
			Node temp = minValueNode(root.right);
			
			root.num = temp.num;
			root.right = deleteNode(root.right, temp.num);
		}
		return root;
	}

	private static Node minValueNode(Node right) {
		// TODO Auto-generated method stub
		if(right.left == null) {
			return right;
		} else {
			return right.left;
		}
	}
	
	
	
}