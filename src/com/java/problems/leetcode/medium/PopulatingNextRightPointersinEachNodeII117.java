package com.java.problems.leetcode.medium;

import java.util.ArrayList;

public class PopulatingNextRightPointersinEachNodeII117 {
    public static void main(String[] args) {
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.right.right = new Node(7);
        connect(root);

    }
    public static Node connect(Node root) {
        Node head = null;
        Node childHead = null;
        Node cur = root;
        ArrayList<Node> nodes = new ArrayList<>();
        nodes.add(root);
        while (!nodes.isEmpty()) {
            ArrayList<Node> newNodes = new ArrayList<>();
            Node curChildHead = null;
            for (Node node : nodes) {
                if(head == null){
                    head = node;
                    cur = node;
                    childHead = cur;
                    curChildHead = cur;
                } else if(curChildHead == null) {
                    assert childHead != null;
                    childHead.left = node;
                    childHead = node;
                    curChildHead = node;
                    cur = node;
                }
                else {
                    cur.next = node;
                    cur = cur.next;
                }
                if (node != null && node.left != null) {
                    newNodes.add(node.left);
                }
                if (node != null && node.right != null) {
                    newNodes.add(node.right);
                }
            }
            nodes = newNodes;
        }
        return head;
    }

    static class Node {
        public int val;
        public Node left;
        public Node right;
        public Node next;

        public Node() {}

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, Node _left, Node _right, Node _next) {
            val = _val;
            left = _left;
            right = _right;
            next = _next;
        }
    }
}
