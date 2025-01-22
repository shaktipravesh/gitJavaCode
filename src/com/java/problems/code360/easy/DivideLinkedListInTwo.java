package com.java.problems.code360.easy;

import com.java.problems.code360.medium.RearrangeOddAndEvenPlaces;

public class DivideLinkedListInTwo {
    public static void main(String[] args) {

    }

    public static Pair divideList(Node head) {
        Boolean isEven = false;
        Node oddNode = null;
        Node evenNode = null;
        Node oddNodeResult = null;
        Node evenNodeResult = null;
        Node traversalNode = head;
        while(traversalNode != null) {
            if(isEven) {
                if(evenNode == null) {
                    evenNode = traversalNode;
                    evenNodeResult = evenNode;
                } else {
                    evenNode.next = traversalNode;
                    evenNode = evenNode.next;
                }
                isEven = false;
            } else {
                if(oddNode == null) {
                    oddNode = traversalNode;
                    oddNodeResult = oddNode;
                }else {
                    oddNode.next = traversalNode;
                    oddNode = oddNode.next;
                }
                isEven = true;
            }
            traversalNode = traversalNode.next;
        }
        if(oddNode != null) {
            oddNode.next = null;
        };
        if(evenNode != null) {
            evenNode.next = null;
        }
        return new Pair(oddNodeResult, evenNodeResult);
    }

    class Node {
        int data;
        Node next;

        Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    static class Pair {
        Node first;
        Node second;

        Pair(Node first, Node second) {
            this.first = first;
            this.second = second;
        }
    }
}
