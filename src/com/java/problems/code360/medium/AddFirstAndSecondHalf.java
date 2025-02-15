package com.java.problems.code360.medium;

import java.util.Stack;

public class AddFirstAndSecondHalf {
    public static void main(String[] args) {
        Node head = new Node(0);
        head.next = new Node(0);
        head.next.next = new Node(0);
        head.next.next.next = new Node(0);
        addFirstAndSecondHalf(head);
    }
    public static Node addFirstAndSecondHalf(Node head) {
        Node first =head;
        Node second = head;
        Node result = null;
        Stack<Node> firstHalfStack = new Stack<>();
        Stack<Node> secondHalfStack = new Stack<>();
        while(first != null) {
            if(second != null) {
                firstHalfStack.push(first);
                second = second.next;
                if(second != null) {
                    second = second.next;
                }
            } else {
                secondHalfStack.push(first);
            }
            first = first.next;
        }
        int quotient = 0;
        int sum = 0;
        while(!secondHalfStack.isEmpty()) {
            first = firstHalfStack.pop();
            second = secondHalfStack.pop();
            sum = quotient + first.data + second.data;
            quotient = sum/10;
            Node currentNode = new Node(sum%10);
            currentNode.next = result;
            result = currentNode;
        }
        if(!firstHalfStack.isEmpty()) {
            first = firstHalfStack.pop();
            sum = quotient + first.data;
            quotient = sum/10;
            Node currentNode = new Node(sum%10);
            currentNode.next = result;
            result = currentNode;
        }
        if(quotient != 0) {
            Node currentNode = new Node(quotient);
            currentNode.next = result;
            result = currentNode;
        }
        while(result.data == 0 && result.next != null) {
        	result = result.next;
        }
        return result;

    }

    static class Node {
        int data;
        Node next;

        public Node(int data) {
            this.data = data;
        }
    }
}

