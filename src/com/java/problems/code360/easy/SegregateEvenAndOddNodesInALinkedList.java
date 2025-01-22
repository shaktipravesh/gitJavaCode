package com.java.problems.code360.easy;

public class SegregateEvenAndOddNodesInALinkedList {
    public static void main(String[] args) {
        int[] input = {1, 15, 15, 13, 7, 0, 15, 8, 15, 5, 6, 3, 17, 18, 16, 9, 19, 10, -1};
        Node head = null;
        Node tail = null;
        for(int i = 0; i < input.length; i++) {
            Node node = new Node(input[i]);
            if(head == null) {
                head = node;
                tail = node;
            } else {
                tail.next = node;
                tail = node;
            }
        }
        Node result = segregateEvenOdd(head);
    }

    public static Node segregateEvenOdd(Node head)
    {
        if(head == null) {
            return head;
        }
        Node odd = null;
        Node even = null;
        Node oddTail = null;
        Node evenTail = null;
        Node input = head;
        while (input != null) {
            if(input.data % 2 == 0) {
                if(even == null) {
                    even = input;
                    evenTail = input;
                } else {
                    evenTail.next = input;
                    evenTail = input;
                }
            } else {
                if(odd == null) {
                    odd = input;
                    oddTail = input;
                } else {
                    oddTail.next = input;
                    oddTail = input;
                }
            }
            input = input.next;
        }
        if(even != null) {
            evenTail.next = odd;
            oddTail.next = null;
            return even;
        } else {
            oddTail.next = null;
            return odd;
        }
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
