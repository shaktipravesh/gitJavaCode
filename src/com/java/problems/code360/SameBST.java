package com.java.problems.code360;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;

public class SameBST {
    class TreeNode<T> {
        T data;
        TreeNode<T> left;
        TreeNode<T> right;

        public TreeNode(T data) {
            this.data = data;
        }
    }

    public static void main(String[] args) {
        TreeNode<Integer> root1 = null;
        TreeNode<Integer> root2 = null;
        int[] num1 = {8, 5, 10, 2, 6, -1, -1, -1, -1, -1, 7, -1, -1};
        int[] num2 = {10, 5, -1, -1, 2, 8, -1, -1, 6, -1, -1};
        TreeNode<Integer>[] node1 = new TreeNode[num1.length];
        TreeNode<Integer>[] node2 = new TreeNode[num2.length];

        Boolean isSameBST = checkBSTs(root1, root2);
    }

    public static Boolean checkBSTs(TreeNode<Integer> root1, TreeNode<Integer> root2) {

        Boolean isSameBST = false;
        if(root1 == null && root2 == null) {
            isSameBST = true;
        } else if (root1 != null && root2 != null) {
            HashMap<Integer, Integer> nodeMap = new HashMap<>();
            Queue<TreeNode> queue = new LinkedList<>();
            queue.add(root1);
            while(!queue.isEmpty()) {
                TreeNode node = queue.poll();
                if(nodeMap.containsKey(node.data)) {
                    nodeMap.put((Integer) node.data, nodeMap.get(node.data)+1);
                } else {
                    nodeMap.put((Integer) node.data, 1);
                }
                if(node.left != null) {
                    queue.add(node.left);
                }
                if(node.right != null) {
                    queue.add(node.right);
                }
            }
            queue.add(root2);
            while(!queue.isEmpty()) {
                TreeNode node = queue.poll();
                if(nodeMap.containsKey(node.data)) {
                    if(nodeMap.get(node.data) == 1) {
                        nodeMap.remove(node.data);
                    } else {
                        nodeMap.put((Integer) node.data, nodeMap.get(node.data)-1);
                    }
                } else {
                    isSameBST = false;
                    break;
                }
            }
            if(queue.isEmpty()) {
                isSameBST = true;
            }
        }
        return isSameBST;
    }


}
