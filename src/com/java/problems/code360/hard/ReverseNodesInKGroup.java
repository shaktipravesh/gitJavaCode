package com.java.problems.code360.hard;

public class ReverseNodesInKGroup {
    public static void main(String[] args) {
        int[] nodeInput = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, -1};
        int n = 3;
        int[] b = {2, 3, 4};
//        int[] nodeInput = { 5, 7, 8, 2, 4, -1};
//        int n = 3;
//        int[] b = {1, 0, 2};

        Node head = null;
        Node tail = null;
        for(int i = 0; i < nodeInput.length; i++) {
            Node newNode;
            if(nodeInput[i] != -1) {
                newNode = new Node(nodeInput[i]);
                if(head == null) {
                    head = newNode;
                    tail = newNode;
                } else {
                    tail.next = newNode;
                    tail = newNode;
                }
            }
            else {
                break;
            }
        }
        Node result = getListAfterReverseOperation(head, n, b);
        while(result != null) {
            System.out.print(result.data + " ");
        }
        System.out.println();

    }
    public static Node getListAfterReverseOperation(Node head, int n, int b[]) {
        Node result = head;
        Node input = head;
        Node tail = null;
        for (int i = 0; i < n && input != null; i++) {
            int reverseCt = b[i];
            if (reverseCt == 0) {
                continue;
            }
            Node start = null;
            Node middle = null;
            Node end = null;
            for (int j = 0; j < reverseCt && input != null; j++) {
                if(end == null) {
                    end = input;
                    middle = input;
                    start = input;
                    input = input.next;
                    end.next = null;
                } else {
                    start = input;
                    input = input.next;
                    start.next = middle;
                    middle = start;
                }
            }
            if(i == 0) {
                result = start;
                tail = end;
            } else {
                tail.next = start;
                tail = end;
            }
        }
        if(input != null && tail != null) {
            tail.next = input;
        }

        return result;
    }

    static class Node
    {
        int data;
        Node next;
        Node(int data)
        {
            this.data = data;
            this.next = null;
        }
    };
}
