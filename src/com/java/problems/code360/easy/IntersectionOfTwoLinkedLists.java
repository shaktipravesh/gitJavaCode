package com.java.problems.code360.easy;

import java.util.HashSet;

public class IntersectionOfTwoLinkedLists {
    public static int findIntersection(Node firstHead, Node secondHead) {
        HashSet<Node> set = new HashSet<>();
        Node temp = firstHead;
        while (temp != null) {
            set.add(temp);
            temp = temp.next;
        }
        temp = secondHead;
        while (temp != null) {
            if (set.contains(temp)) {
                return temp.data;
            }
            temp = temp.next;
        }
        return -1;
    }

    static class Node {
        public int data;
        public Node next;

        Node()
        {
            this.data = 0;
            this.next = null;
        }
        Node(int data)
        {
            this.data = data;
            this.next = null;
        }
        Node(int data, Node next)
        {
            this.data = data;
            this.next = next;
        }
    }
}
