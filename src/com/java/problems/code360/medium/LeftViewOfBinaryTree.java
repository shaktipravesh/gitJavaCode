package com.java.problems.code360.medium;

import java.util.ArrayList;

public class LeftViewOfBinaryTree {
    static class TreeNode<T>
    {
        T data;
        TreeNode<T> left;
        TreeNode<T> right;

        TreeNode(T data) {
            this.data = data;
            left = null;
            right = null;
        }
    };

    public static void printLeftView(TreeNode<Integer> root) {
        ArrayList<TreeNode<Integer>> parentNodeList = new ArrayList<>();
        parentNodeList.add(root);
        while (parentNodeList.size() >0) {
            ArrayList<TreeNode<Integer>> childNodeList = new ArrayList<>();
            for(int i = 0; i < parentNodeList.size(); i++) {
                TreeNode<Integer> node = parentNodeList.get(i);
                if(node.left!= null) {
                    childNodeList.add(node.left);
                }
                if(node.right!= null) {
                    childNodeList.add(node.right);
                }
                if(i == 0) {
                    System.out.print(node.data + " ");
                }
            }
            parentNodeList = childNodeList;
        }
        System.out.println();
    }
}
