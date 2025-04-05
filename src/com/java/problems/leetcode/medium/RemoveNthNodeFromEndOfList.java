package com.java.problems.leetcode.medium;

public class RemoveNthNodeFromEndOfList {
    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);
        System.out.println(removeNthFromEnd(head, 2));
    }
    public static ListNode removeNthFromEnd(ListNode head, int n) {
        int size = 0;
        ListNode temp = head;
        while(temp != null) {
            size++;
            temp = temp.next;
        }
        if(size < n) {
            return head;
        }

        int x = size - n;
        if(x == 0 && head != null) {
            return head.next;
        }

        temp = head;
        while(x > 1 && temp != null) {
            temp = temp.next;
            x--;
        }
        if(temp != null) {
            if(temp.next != null) {
                temp.next = temp.next.next;
            }
        }
        return head;
    }

    public static class ListNode {
        int val;
        ListNode next;
        ListNode(int val) { this.val = val; }
    }
}
