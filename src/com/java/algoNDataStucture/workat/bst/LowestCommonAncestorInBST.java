package com.java.algoNDataStucture.workat.bst;

public class LowestCommonAncestorInBST {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	Node lowestCommonAncestor(Node root, Node p, Node q) {
		Node commonAncestor = root;
		if(!checkPresence(root, p) || !checkPresence(root, q)) {
			return root;
		}
		while(commonAncestor != null) {
		   if(commonAncestor.data == p.data || commonAncestor.data == q.data) {
			   break;
		   }
		   if(commonAncestor.data > p.data && commonAncestor.data > q.data) {
			   commonAncestor = commonAncestor.left;
		   } else if(commonAncestor.data < p.data && commonAncestor.data < q.data) {
			   commonAncestor = commonAncestor.right;
		   } else {
			   break;
		   }
		}
		return commonAncestor;
	}

	private boolean checkPresence(Node root, Node p) {
		if(root == null) {
			return false;
		}
		
		while(root != null) {
			if(root.data == p.data) {
				return true;
			}
			if(root.data > p.data) {
				root = root.left;
			} else {
				root = root.right;
			}
		}
		return false;
	}
}
