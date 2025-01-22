package com.java.problems.code360.easy;

public class InsertionInDoublyLinkedList {
    static Node insert(int k, int val, Node head) {
        if(k < 1) {
            Node newNode = new Node(val);
            newNode.next = head;
            head.prev = newNode;
            head = newNode;
            return head;
        }
        Node kNode = head;
        int i = 0;
        for(i = 1; i < k; i++) {
            if(kNode.next == null) {
                break;
            }
            kNode = kNode.next;
        }
        Node newNode = new Node(val);

        if(kNode.next != null) {
            newNode.next = kNode.next;
            kNode.next.prev = newNode;
        }
        kNode.next = newNode;
        newNode.prev = kNode;
        return head;
    }

    static class Node<T> {
        T data;
        Node<T> next,prev;

        public Node(T data) {
            this.data = data;
        }
    }
}
