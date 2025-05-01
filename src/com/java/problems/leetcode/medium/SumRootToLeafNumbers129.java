package com.java.problems.leetcode.medium;

import java.util.ArrayList;

public class SumRootToLeafNumbers129 {
    public static int sumNumbers(TreeNode root) {
        if (root == null) return 0;
        int sum = 0;
        ArrayList<TreeNode> nodes = new ArrayList<>();
        nodes.add(root);
        ArrayList<TreeNode> children;
        while (!nodes.isEmpty()) {
            children = new ArrayList<>();
            for (TreeNode node : nodes) {
                if(node.left == null && node.right == null) {
                    sum += node.val;
                    continue;
                }
                if(node.left != null) {
                    node.left.val = node.val*10 + node.left.val;
                    children.add(node.left);
                }
                if(node.right != null) {
                    node.right.val = node.val*10 + node.right.val;
                    children.add(node.right);
                }
            }
            nodes = children;
        }
        return sum;
    }

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
    }
}
