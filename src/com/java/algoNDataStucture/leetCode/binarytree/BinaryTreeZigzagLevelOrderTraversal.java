package com.java.algoNDataStucture.leetCode.binarytree;

import java.util.ArrayList;
import java.util.List;

public class BinaryTreeZigzagLevelOrderTraversal {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
	    List<List<Integer>> zigzagLevelOrderList = new ArrayList<List<Integer>>();
	    if(root == null) {
	    	return zigzagLevelOrderList;
	    }
	    List<TreeNode> listNode = new ArrayList<TreeNode>();
	    listNode.add(root);
	    List<Integer> zigzagLevelOrder = new ArrayList<Integer>();
	    zigzagLevelOrder.add(root.val);
	    zigzagLevelOrderList.add(zigzagLevelOrder);
	    getZigzagLevelOrder(listNode, false, zigzagLevelOrderList);
	    return zigzagLevelOrderList;
	}

	private void getZigzagLevelOrder(List<TreeNode> listNode, boolean direction, List<List<Integer>> zigzagLevelOrderList) {
		List<Integer> zigzagLevelOrder = new ArrayList<Integer>();
		for(int i = listNode.size(); i > 0; i--) {
			TreeNode iNode = listNode.get(i-1);
			if(direction) {
				if(iNode.left!= null) {
					listNode.add(iNode.left);
					zigzagLevelOrder.add(iNode.left.val);
				}
				if(iNode.right!= null) {
					listNode.add(iNode.right);
					zigzagLevelOrder.add(iNode.right.val);
				}
			} else {
				if(iNode.right!= null) {
					listNode.add(iNode.right);
					zigzagLevelOrder.add(iNode.right.val);
				}
				if(iNode.left!= null) {
					listNode.add(iNode.left);
					zigzagLevelOrder.add(iNode.left.val);
				}
			}
			listNode.remove(i-1);
		}
		if(direction) {
			direction = false;
		} else {
			direction = true;
		}
		if(listNode.size() > 0) {
			zigzagLevelOrderList.add(zigzagLevelOrder);
			getZigzagLevelOrder(listNode, direction, zigzagLevelOrderList);
		}
	}
}
