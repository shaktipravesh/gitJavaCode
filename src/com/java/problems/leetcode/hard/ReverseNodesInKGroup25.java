package com.java.problems.leetcode.hard;

public class ReverseNodesInKGroup25 {
    /**
     * Definition for singly-linked list.
     * public class ListNode {
     *     int val;
     *     ListNode next;
     *     ListNode() {}
     *     ListNode(int val) { this.val = val; }
     *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
     * }
     */

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);

        ListNode newHead = reverseKGroup(head, 3);
        System.out.println(newHead);

    }
    public static ListNode reverseKGroup(ListNode head, int k) {
        if (head == null || head.next == null) return head;
        ListNode newHead = head;
        int count = 0;
        ListNode tail = newHead;
        ListNode startNode = head;
        ListNode endNode = head;
        while(tail != null) {
            int size;
            for(size = 0; size < k && tail != null; size++) {
                tail = tail.next;
            }
            if(size == k) {
                ListNode reverseNode = reverseKSize(startNode, k);
                if(count == 0) {
                    newHead = reverseNode;
                } else {
                    endNode.next = reverseNode;
                }
                startNode.next = tail;
                count++;
                endNode = startNode;
                startNode = tail;
            }

        }
        return newHead;
    }

    private static ListNode reverseKSize(ListNode newHead, int k) {
        ListNode currNode = newHead.next;
        ListNode prevNode = newHead;
        ListNode nextNode;
        prevNode.next = null;
        for(int i = 1; i < k; i++) {
            nextNode = currNode.next;
            currNode.next = prevNode;
            prevNode = currNode;
            currNode = nextNode;
        }
        return prevNode;

    }

    public static class ListNode {
        int val;
        ListNode next;
        ListNode(int val) { this.val = val; }
    }
}
