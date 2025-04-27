package com.java.problems.leetcode.medium;

import java.util.HashMap;

public class CopyListWithRandomPointer138 {

    public static class Node {
        int val;
        Node next;
        Node random;

        public Node(int val) {
            this.val = val;
            this.next = null;
            this.random = null;
        }
    }

    public Node copyRandomList(Node head) {
        HashMap<Node, Node> map = new HashMap<>();
        Node copyList = null;
        Node currNode = null;
        Node rootHead = head;
        while (rootHead != null) {
            Node tempNode;
            Node random;
            if(map.containsKey(rootHead)) {
                tempNode = map.get(rootHead);
            } else {
                tempNode = new Node(rootHead.val);
                map.put(rootHead, tempNode);
            }
            if(copyList == null) {
                copyList = tempNode;
                currNode = tempNode;
            } else {
                currNode.next = tempNode;
                currNode = currNode.next;
            }

            if(rootHead.random != null) {
                if (map.containsKey(rootHead.random)) {
                    random = map.get(rootHead.random);
                } else {
                    random = new Node(rootHead.random.val);
                    map.put(rootHead.random, random);
                }
                currNode.random = random;
            }
            rootHead = rootHead.next;

        }
        return copyList;
    }
}
