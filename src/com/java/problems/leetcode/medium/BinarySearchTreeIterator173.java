package com.java.problems.leetcode.medium;

import java.util.LinkedList;
import java.util.Queue;

import static java.lang.System.*;

public class BinarySearchTreeIterator173 {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(7);
        root.left = new TreeNode(3);
        root.right = new TreeNode(15);
        root.right.left = new TreeNode(9);
        root.right.right = new TreeNode(20);
        BinarySearchTreeIterator173 iter = new BinarySearchTreeIterator173();
        iter.BSTIterator(root);
        out.println(iter.next());
        out.println(iter.next());
        out.println(iter.hasNext());
        out.println(iter.next());
        out.println(iter.hasNext());
        out.println(iter.next());
        out.println(iter.hasNext());
        out.println(iter.next());
        out.println(iter.hasNext());
    }
    Queue<TreeNode> treeNodeLinkedList = new LinkedList<>();
    public void BSTIterator(TreeNode root) {
        getInOrderNode(root);
    }

    public int next() {
        return treeNodeLinkedList.isEmpty() ? -1 : treeNodeLinkedList.poll().val;
    }

    private void getInOrderNode(TreeNode bstRoot) {
        if (bstRoot == null) {
            return;
        }
        getInOrderNode(bstRoot.left);
        treeNodeLinkedList.add(bstRoot);
        getInOrderNode(bstRoot.right);
    }

    public boolean hasNext() {
        return !treeNodeLinkedList.isEmpty();
    }

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int val) { this.val = val; }
    }
}
