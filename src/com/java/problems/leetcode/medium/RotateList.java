package com.java.problems.leetcode.medium;

public class RotateList {

    public static class ListNode {
        int val;
        ListNode next;
        ListNode(int val) { this.val = val; }
    }

    public static void main(String[] args) {
        RotateList rotateList = new RotateList();
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        ListNode result = rotateList.rotateRight(head, 2);
        System.out.println(result.val);

    }

    public ListNode rotateRight(ListNode head, int k) {
        if(head == null || head.next == null || k == 0 ) return head;
        ListNode result;
        ListNode cur = head;
        ListNode prev = null;
        int size = 0;
        while(cur != null) {
            size++;
            cur = cur.next;
        }
        cur = head;
        k %= size;
        if(k == 0) {
            return head;
        }
        k = size - k;
        for(int i = 1; i <= k; i++) {
            prev = cur;
            cur = cur.next;
        }

        if(prev != null) {
            prev.next = null;
        }
        result = cur;
        while(cur != null && cur.next != null) {
            cur = cur.next;
        }
        if(cur != null) {
            cur.next = head;
        }
        return result;
    }
}
