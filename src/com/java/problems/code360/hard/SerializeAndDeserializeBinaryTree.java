package com.java.problems.code360.hard;

import java.util.ArrayList;

public class SerializeAndDeserializeBinaryTree {

    static class TreeNode {
        int data;
        TreeNode left;
        TreeNode right;
        TreeNode() {
            this.data = 0;
            this.left = null;
            this.right = null;
        }
        TreeNode(int data) {
            this.data = data;
            this.left = null;
            this.right = null;
        }
        TreeNode(int data, TreeNode left, TreeNode right) {
            this.data = data;
            this.left = left;
            this.right = right;
        }
    }

    public static String serializeTree(TreeNode root) {
        if (root == null) {
            return "";
        }
        StringBuilder sb = new StringBuilder();
        ArrayList<TreeNode> nodes = new ArrayList<TreeNode>();
        nodes.add(root);
        for(int i = 0; i < nodes.size(); i++) {
            TreeNode node = nodes.get(i);
            if(node == null) {
                sb.append("-1 ");
            } else {
                sb.append(node.data).append(" ");
                nodes.add(node.left);
                nodes.add(node.right);
            }
        }
        return new String(sb.toString());
    }

    public static TreeNode deserializeTree(String serialized) {
        if(serialized == null || serialized.equals("")) {
            return null;
        }
        TreeNode root = null;
        TreeNode node;
        boolean isLeft = true;
        String[] strNode = serialized.split(" ");
        ArrayList<TreeNode> nodes = new ArrayList<TreeNode>();
        int nodeIndex = 0;
        for(int i = 0; i < strNode.length; i++) {
            int data = Integer.parseInt(strNode[i]);
            if(data == -1) {
                if(isLeft) {
                    isLeft = false;
                } else {
                    isLeft = true;
                    nodeIndex++;
                }
            } else {
                if(root == null) {
                    root = new TreeNode(data);
                    nodes.add(root);
                    isLeft = true;
                } else {
                    node = new TreeNode(data);
                    nodes.add(node);
                    if(isLeft) {
                        nodes.get(nodeIndex).left = node;
                        isLeft = false;
                    } else {
                        nodes.get(nodeIndex).right = node;
                        nodeIndex++;
                        isLeft = true;
                    }
                }
            }
        }
        return root;
    }

    public static void main(String[] args) {
        String serialized = "1 -1 3 -1 -1";
        serialized = "1 2 3 -1 4 5 -1 -1 -1 -1 -1";
        TreeNode root = deserializeTree(serialized);
    }
}
