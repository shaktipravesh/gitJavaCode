package com.java.problems.leetcode.hard;

import java.util.ArrayList;
import java.util.Arrays;

public class MergeKSortedLists23 {
    public static void main(String[] args) {
        ListNode[] lists = new ListNode[3];
        System.out.println(mergeKLists(lists));
    }
    private static ListNode mergeKLists(ListNode[] lists) {
        ListNode mergedList = null;
        int minAtStart;
        int minIndex = 0;
        ListNode curr = null;
        ListNode nullNode = null;
        ListNode minNode;
        ArrayList<ListNode> listNodes = new ArrayList<>(Arrays.stream(lists).toList());
        while( !listNodes.isEmpty()) {
            minAtStart = Integer.MAX_VALUE;
            minNode = listNodes.getFirst();
            for(int i = 0; i < listNodes.size(); i++){
                if(listNodes.get(i) != null) {
                    if(minAtStart > listNodes.get(i).val) {
                        minAtStart = listNodes.get(i).val;
                        minNode = listNodes.get(i);
                        minIndex = i;
                    }
                } else {
                    nullNode = listNodes.get(i);
                }
            }
            if(minAtStart != Integer.MAX_VALUE) {
                ListNode newNode = new ListNode(minAtStart);
                if(minNode != null) {
                    listNodes.set(minIndex, minNode.next);
                }
                if(mergedList == null) {
                    mergedList = newNode;
                    curr = newNode;
                } else {
                    curr.next = newNode;
                    curr = curr.next;
                }
                listNodes.remove(nullNode);
            } else {
                break;
            }
        }
        return mergedList;
    }

    private static class ListNode {
        int val;
        ListNode next;
        ListNode(int val) { this.val = val; }
    }

}
