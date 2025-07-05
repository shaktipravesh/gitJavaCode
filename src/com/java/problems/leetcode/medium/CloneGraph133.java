package com.java.problems.leetcode.medium;

import java.util.*;

public class CloneGraph133 {
    public static void main(String[] args) {
        Node node1 = new Node(1);
        Node node2 = new Node(2);
        Node node3 = new Node(3);
        Node node4 = new Node(4);
        node1.neighbors.add(node2);
        node1.neighbors.add(node4);
        node2.neighbors.add(node3);
        node2.neighbors.add(node1);
        node3.neighbors.add(node4);
        node3.neighbors.add(node2);
        node4.neighbors.add(node3);
        node4.neighbors.add(node1);

        CloneGraph133 cg = new CloneGraph133();
        cg.cloneGraph(node1);

    }
    private final Map<Node, Node> visited = new HashMap<>();
    public Node cloneGraph(Node node) {
        if (node == null) return null;

        // If already cloned, return the clone
        if (visited.containsKey(node)) {
            return visited.get(node);
        }

        // Create a clone for the current node
        Node clone = new Node(node.val);
        visited.put(node, clone);

        // Recursively clone neighbors
        for (Node neighbor : node.neighbors) {
            clone.neighbors.add(cloneGraph(neighbor));
        }
        return clone;
    }

    static class Node {
        public int val;
        public List<Node> neighbors;
        public Node(int _val) {
            val = _val;
            neighbors = new ArrayList<Node>();
        }
    }
}
