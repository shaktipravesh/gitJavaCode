package com.java.problems.leetcode.medium;

import java.util.HashMap;
import java.util.LinkedHashMap;

public class RemoveDuplicatesFromSortedListII82 {
    class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

    public ListNode deleteDuplicates(ListNode head) {
        if (head == null || head.next == null) return head;
        HashMap<Integer, Integer> map = new LinkedHashMap<>();
        for (ListNode cur = head; cur != null; cur = cur.next) {
            map.put(cur.val, map.getOrDefault(cur.val, 0) + 1);
        }
        ListNode result = null;
        ListNode prev = null;
        for (ListNode cur = head; cur != null; cur = cur.next) {
            if (map.get(cur.val) == 1) {
                if(result == null) {
                    result = cur;
                    prev = cur;
                } else {
                    prev.next = cur;
                    prev = cur;
                }
            }
        }
        if(prev != null) {
            prev.next = null;
        }
        return result;
    }
}

