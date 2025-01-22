package com.java.problems.code360.medium;

public class RearrangeOddAndEvenPlaces {
    public static void main(String[] args) {

    }

    public static Node oddEvenList(Node head) {
        if(head == null) {
            return head;
        }
        Boolean isEven = false;
        Node oddNode = null;
        Node evenNode = null;
        Node traversalNode = head;
        while(traversalNode != null) {
            if(isEven) {
                if(evenNode == null) {
                    evenNode = traversalNode;
                } else {
                    evenNode.next = traversalNode;
                    evenNode = evenNode.next;
                }
                isEven = false;
            } else {
                if(oddNode == null) {
                    oddNode = traversalNode;
                }else {
                    oddNode.next = traversalNode;
                    oddNode = oddNode.next;
                }
            }
            traversalNode = traversalNode.next;
        }
        return head;
    }

    class Node
    {
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
    }

}
