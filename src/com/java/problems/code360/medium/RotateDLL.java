package com.java.problems.code360.medium;

public class RotateDLL {

    public static void main(String[] args) {
        int[] inputArr = {4, 3, 9, 1, 7, 8};
        DLLNode head = null;
        DLLNode tail = null;
        for (int i = 0; i < inputArr.length; i++) {
            DLLNode newNode = new DLLNode(inputArr[i]);
            if (head == null) {
                head = newNode;
                tail = newNode;
            } else {
                tail.next = newNode;
                newNode.prev = tail;
                tail = newNode;
            }
        }
        DLLNode result = rotateDLL(head, 4);
        System.out.println(result);
    }
    public static DLLNode rotateDLL(DLLNode head, int k)
    {
        if(k < 1) {
            return head;
        }
        DLLNode input = head;
        DLLNode newHead = null;
        DLLNode endNode = null;
        int i = 0;
        while(input != null) {
            if(i == k && newHead == null) {
                newHead = input;
            } else {
                i++;
            }
            endNode = input;
            input = input.next;

        }
        if(newHead != null) {
            newHead.prev.next = null;
            endNode.next = head;
            head.prev = endNode;
            newHead.prev = null;
        }
        return newHead;
    }

    static class DLLNode {
        int data;
        DLLNode next, prev;

        DLLNode(int data) {
            this.data = data;
            this.next = null;
            this.prev = null;
        }
    }
}
