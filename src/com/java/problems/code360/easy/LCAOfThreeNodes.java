package com.java.problems.code360.easy;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class LCAOfThreeNodes {
    static class BinaryTreeNode<T> {
        T data;
        BinaryTreeNode<T> left;
        BinaryTreeNode<T> right;

        public BinaryTreeNode(T data) {
            this.data = data;
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Read the number of test cases
        int T = scanner.nextInt();
        while (T-- > 0) {
            // Read the nodes for LCA
            int node1 = scanner.nextInt();
            int node2 = scanner.nextInt();
            int node3 = scanner.nextInt();

            // Read the binary tree nodes
            Integer[] nodes = new Integer[scanner.nextInt()];
            for (int i = 0; i < nodes.length; i++) {
                int value = scanner.nextInt();
                nodes[i] = (value == -1) ? null : value; // -1 indicates null
            }

            // Build the tree
            BinaryTreeNode<Integer> root = buildTree(nodes);

            // Find and print the LCA
            BinaryTreeNode<Integer> lca = lcaOfThreeNodes(root, node1, node2, node3);
            System.out.println(lca.data);
        }

        scanner.close();
    }
    public static BinaryTreeNode<Integer> buildTree(Integer[] nodes) {
        if (nodes.length == 0 || nodes[0] == null) return null;

        BinaryTreeNode<Integer> root = new BinaryTreeNode<>(nodes[0]);
        BinaryTreeNode<Integer>[] treeNodes = new BinaryTreeNode[nodes.length];
        treeNodes[0] = root;

        for (int i = 1; i < nodes.length; i++) {
            if (nodes[i] != null) {
                treeNodes[i] = new BinaryTreeNode<>(nodes[i]);
                if (i % 2 == 1) { // Left child
                    treeNodes[(i - 1) / 2].left = treeNodes[i];
                } else { // Right child
                    treeNodes[(i - 2) / 2].right = treeNodes[i];
                }
            }
        }

        return root;
    }


    public static BinaryTreeNode<Integer> lcaOfThreeNodes(BinaryTreeNode<Integer> root, int node1, int node2, int node3) {
        // Base case
        if (root == null || root.data == node1 || root.data == node2 || root.data == node3) {
            return root;
        }

        // Recursive calls
        BinaryTreeNode<Integer> leftLCA = lcaOfThreeNodes(root.left, node1, node2, node3);
        BinaryTreeNode<Integer> rightLCA = lcaOfThreeNodes(root.right, node1, node2, node3);

        // If both left and right children returned non-null, this is the LCA
        if (leftLCA != null && rightLCA != null) {
            return root;
        }

        // Otherwise, return the non-null child
        return (leftLCA != null) ? leftLCA : rightLCA;
    }
}
