package com.java.problems.code360.easy;

public class DeletionInCircularLinkedList {
    public static Node<Integer> deleteNode(Node<Integer> head, int key) {
        boolean isCycle = false;
        boolean isKey = false;
        Node first = head;
        Node second = head;
        Node keyNode = null;
        if(head == null) {
            return head;
        }
        do {
            if(first != null) {
                first = first.next;
            }
            if(second!= null && second.next != null) {
                second = second.next.next;
            }
            if(first == second) {
                isCycle = true;
                break;
            }
        } while(first != second);
        if(!isCycle) {
            return head;
        }
        keyNode = head;
        do{
            if((int)keyNode.next.data == key) {
                isKey = true;
                break;
            }
            keyNode = keyNode.next;
        } while(keyNode != head);
        if(head.data == key) {
            head = head.next;
            if(head.next == head) {
                head = null;
            }
        }
        if(isKey) {
            keyNode.next = keyNode.next.next;
        }
        return head;
    }

    class Node<T> {
        T data;
        Node<T> next;

        public Node(T data) {
            this.data = data;
        }
    }
}
