package com.java.problems.leetcode.medium;

import java.util.LinkedList;
import java.util.Queue;
import java.util.TreeSet;

public class KthSmallestElementInABST230 {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(1);
        root.right = new TreeNode(4);
        root.left.right = new TreeNode(2);
        KthSmallestElementInABST230 kthSmallest = new KthSmallestElementInABST230();
        System.out.println(kthSmallest.kthSmallest(root, 1));
    }
    public int kthSmallest(TreeNode root, int k) {
        TreeSet<Integer> set = new TreeSet<>();
        set.add(root.val);
        Queue<TreeNode> nodes = new LinkedList<>();
        nodes.add(root);
        while (!nodes.isEmpty()) {
            TreeNode node = nodes.poll();
            if (set.size() >= k && set.getLast() > node.val) {
                set.removeLast();
            }
            if(set.size() < k) {
                set.add(node.val);
            }
            if(node.left != null) {
                nodes.add(node.left);
            }
            if(node.right != null) {
                nodes.add(node.right);
            }
        }
        return set.last();
    }
    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int val) { this.val = val; }
    }
}
