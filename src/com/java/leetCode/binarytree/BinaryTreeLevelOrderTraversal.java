package com.java.leetCode.binarytree;

import java.util.ArrayList;
import java.util.List;

import com.java.leetCode.binarytree.BinaryTreeInorderTraversal.TreeNode;

public class BinaryTreeLevelOrderTraversal {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	public List<List<Integer>> levelOrder(TreeNode root) {

		List<List<Integer>> levelOrderValLists = new ArrayList<List<Integer>>();
		if(root == null) {
			return levelOrderValLists;
		}
		List<TreeNode> levelNode = new ArrayList<TreeNode>();
		levelNode.add(root);
		
		getLevelOrderValue(levelNode, levelOrderValLists);
		
		return levelOrderValLists;
	}

    private void getLevelOrderValue(List<TreeNode> levelNode, List<List<Integer>> levelOrderValLists) {
    	List<Integer> levelValList = new ArrayList<Integer>();
    	List<TreeNode> levelChildNode = new ArrayList<TreeNode>();
    	for(int i =0; i < levelNode.size(); i++) {
    		levelValList.add(levelNode.get(i).val);
    		if(levelNode.get(i).left != null) {
    			levelChildNode.add(levelNode.get(i).left);
    		}
    		if(levelNode.get(i).right != null) {
    			levelChildNode.add(levelNode.get(i).right);
    		}
		}
    	if(levelValList.size() > 0) {
    		levelOrderValLists.add(levelValList);
    	}
    	if(levelChildNode.size() > 0) {
    		getLevelOrderValue(levelChildNode, levelOrderValLists);
    	}
		
	}
	public List<List<Integer>> levelOrderMLE(TreeNode root) {
    	if(root == null) {
    		return null;
    	}
    	List<List<Integer>> levelOrderValLists = new ArrayList<List<Integer>>();
    	List<List<TreeNode>> levelOrderNodeLists = new ArrayList<List<TreeNode>>();
    	List<Integer> valLevelOrder = new ArrayList<Integer>();
    	List<TreeNode> nodeLevelOrder = new ArrayList<TreeNode>();
    	nodeLevelOrder.add(root);
    	levelOrderNodeLists.add(nodeLevelOrder);
    	valLevelOrder.add(root.val);
    	levelOrderValLists.add(valLevelOrder);
    	while(levelOrderNodeLists.size()> 0) {
    		List<TreeNode> currNodeLevel = levelOrderNodeLists.getLast();
    		List<TreeNode> childNodeLevel = new ArrayList<TreeNode>();
    		List<Integer> childValLevel = new ArrayList<Integer>();
    		for(int j = 0; j < currNodeLevel.size(); j++) {
    			if(currNodeLevel.get(j).left != null) {
    				childNodeLevel.add(currNodeLevel.get(j).left);
    				childValLevel.add(currNodeLevel.get(j).left.val);
    			}
    			if(currNodeLevel.get(j).right != null) {
    				childNodeLevel.add(currNodeLevel.get(j).right);
    				childValLevel.add(currNodeLevel.get(j).right.val);
    			}
    		}
    		levelOrderNodeLists.removeLast();
    		levelOrderNodeLists.add(childNodeLevel);
    		levelOrderValLists.add(childValLevel);
    	}
    	
    	return levelOrderValLists;
    }
    
}
