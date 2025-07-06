package com.java.problems.leetcode.medium;

public class PartitionList82 {

    public static class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

    public static void main(String[] args) {
        int[] input01 = {1,4,3,2,5,2};
        int x1 = 3;
        int[] input02 = {4,3,2,5,2};
        int x2 = 3;
        int[] input03 = {3,2,5,2};
        int x3 = 3;
        int[] input04 = {1,4,3,0,5,2};
        int x4 = 2;
        ListNode head;
        ListNode result;
/*        head = new ListNode(1);
        head.next = new ListNode(4);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(2);
        head.next.next.next.next = new ListNode(5);
        head.next.next.next.next.next = new ListNode(2);
        result = partition(head, 3);*/

//        head = new ListNode(4);
//        head.next = new ListNode(3);
//        head.next.next = new ListNode(2);
//        head.next.next.next = new ListNode(5);
//        head.next.next.next.next = new ListNode(2);
//        result = partition(head, 3);

//        head = new ListNode(3);
//        head.next = new ListNode(2);
//        head.next.next = new ListNode(5);
//        head.next.next.next = new ListNode(2);
//        result = partition(head, 3);

        head = new ListNode(1);
        head.next = new ListNode(4);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(0);
        head.next.next.next.next = new ListNode(5);
        head.next.next.next.next.next = new ListNode(2);
        result = partition(head, 2);
    }
    public static ListNode partition(ListNode head, int x) {
        ListNode beforeHead = new ListNode(0); // Dummy head for nodes < x
        ListNode afterHead = new ListNode(0);  // Dummy head for nodes >= x

        ListNode before = beforeHead;
        ListNode after = afterHead;

        while (head != null) {
            if (head.val < x) {
                before.next = head;
                before = before.next;
            } else {
                after.next = head;
                after = after.next;
            }
            head = head.next;
        }

        after.next = null;           // Avoid cycle
        before.next = afterHead.next; // Connect the two lists

        return beforeHead.next;
    }
}
