package com.java.problems.code360.medium;

public class CycleDetectionInASinglyLinkedList {

    public static boolean detectCycle(Node head) {
        Node first = head;
        Node second = head;
        boolean isCycle = false;
        do {
            if(first == null || second == null) {
                break;
            }
            first = first.next;
            if(second.next != null) {
                second = second.next.next;
            } else {
                break;
            }
            if(first == second) {
                isCycle = true;
                break;
            }
        } while(first != second);

        return isCycle;
    }

    class Node {
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
