package com.java.algoNDataStucture.workat.binarytrees;

import java.util.ArrayList;
import java.util.List;

public class BinaryTreeZigzagLevelOrderTraversal {

	public static void main(String[] args) {

	}
	
	int[] zigzagLevelOrderTraversal(Node root) {
	    int[] zigzagLevelOrder = null;
	    if(root == null) {
	    	return zigzagLevelOrder;
	    }
	    List<Integer> zigzagLevelOrderList = new ArrayList<Integer>();
	    List<Node> listNode = new ArrayList<Node>();
	    listNode.add(root);
	    zigzagLevelOrderList.add(root.data);
	    getZigzagLevelOrder(listNode, false, zigzagLevelOrderList);
	    System.out.println(zigzagLevelOrderList);
	    zigzagLevelOrder = zigzagLevelOrderList.stream().mapToInt(i->i).toArray();
	    return zigzagLevelOrder;
	}

	private void getZigzagLevelOrder(List<Node> listNode, boolean direction, List<Integer> zigzagLevelOrderList) {
		for(int i = listNode.size(); i > 0; i--) {
			Node iNode = listNode.get(i-1);
			if(direction) {
				if(iNode.left!= null) {
					listNode.add(iNode.left);
					zigzagLevelOrderList.add(iNode.left.data);
				}
				if(iNode.right!= null) {
					listNode.add(iNode.right);
					zigzagLevelOrderList.add(iNode.right.data);
				}
			} else {
				if(iNode.right!= null) {
					listNode.add(iNode.right);
					zigzagLevelOrderList.add(iNode.right.data);
				}
				if(iNode.left!= null) {
					listNode.add(iNode.left);
					zigzagLevelOrderList.add(iNode.left.data);
				}
			}
			listNode.remove(i-1);
		}
		if(direction) {
			direction = false;
		} else {
			direction = true;
		}
		System.out.println(zigzagLevelOrderList);
		if(listNode.size() > 0) {
			getZigzagLevelOrder(listNode, direction, zigzagLevelOrderList);
		}
	}

}
