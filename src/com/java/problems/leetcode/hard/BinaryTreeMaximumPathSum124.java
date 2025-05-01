package com.java.problems.leetcode.hard;

import static java.lang.System.*;

public class BinaryTreeMaximumPathSum124 {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(4);
        root.right = new TreeNode(8);
        root.left.left = new TreeNode(11);
        root.right.left = new TreeNode(13);
        root.right.right = new TreeNode(4);
        root.left.left.left = new TreeNode(7);
        root.left.left.right = new TreeNode(2);
        root.right.right.right = new TreeNode(1);
        BinaryTreeMaximumPathSum124 bt = new BinaryTreeMaximumPathSum124();
        out.println(bt.maxPathSum(root));
    }

    int maxSum = Integer.MIN_VALUE;
    public int maxPathSum(TreeNode root) {
        if (root == null) return 0;
        maxPathSum(root.left);
        maxPathSum(root.right);
        int left = root.left != null ? (Math.max(root.left.val, 0)) : 0;
        int right = root.right != null ? (Math.max(root.right.val, 0)) : 0;
        maxSum = Math.max(maxSum, root.val + left + right);
        root.val += Math.max(left, right);
        return Math.max(root.val, maxSum);
    }

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int val) { this.val = val; }
    }
}
