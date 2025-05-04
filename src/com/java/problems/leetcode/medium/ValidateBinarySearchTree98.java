package com.java.problems.leetcode.medium;

import static java.lang.System.*;

public class ValidateBinarySearchTree98 {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(1);
        root.right = new TreeNode(5);
        root.left.left = new TreeNode(0);
        root.left.right = new TreeNode(2);
        root.right.left = new TreeNode(4);
        root.right.right = new TreeNode(6);
        root.left.right.right = new TreeNode(3);
        ValidateBinarySearchTree98 obj = new ValidateBinarySearchTree98();
        out.println(obj.isValidBST(root));
    }

    public boolean isValidBST(TreeNode root) {
        return isValidNode(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }

    private boolean isValidNode(TreeNode root, long minValue, long maxValue) {
        if (root == null) return true;
        if (root.val < minValue || root.val > maxValue) return false;
        return isValidNode(root.left, minValue, root.val) && isValidNode(root.right, root.val, maxValue);

    }

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int val) { this.val = val; }
    }
}
