package com.java.problems.code360.hard;

import java.util.Comparator;
import java.util.PriorityQueue;

public class MergeKSortedLists {
    static public class LinkedListNode<Integer> {
        int data;
        LinkedListNode<Integer> next;

        public LinkedListNode(int data) {
            this.data = data;
        }
    }
    public static LinkedListNode<Integer> mergedKLists(LinkedListNode<Integer>[] listArray) {
        LinkedListNode<Integer> mergedKList = null;
        LinkedListNode<Integer> tailMergeKLists = null;
        LinkedListNode<Integer> first = null;
        LinkedListNode<Integer> second = null;
        for(int i = 0; i < listArray.length; i++) {
            if(i == 0) {
                mergedKList = listArray[i];
            } else {
                second = listArray[i];
                first = mergedKList;
                mergedKList = null;
                while(first != null && second != null) {
                    if(first.data > second.data) {
                        if(mergedKList == null) {
                            tailMergeKLists = second;
                            mergedKList = second;
                        } else {
                            tailMergeKLists.next = second;
                            tailMergeKLists = second;
                        }
                        second = second.next;
                    } else {
                        if(mergedKList == null) {
                            tailMergeKLists = first;
                            mergedKList = first;
                        } else {
                            tailMergeKLists.next = first;
                            tailMergeKLists = first;
                        }
                        first = first.next;
                    }
                }
                if(first == null) {
                    tailMergeKLists.next = second;
                } else {
                    tailMergeKLists.next = first;
                }
            }

        }
        return mergedKList;
    }

    public static void main(String[] args) {

    }




















    public static LinkedListNode<Integer> mergeKLists(LinkedListNode<Integer>[] listArray) {
        PriorityQueue<LinkedListNode<Integer>> minHeap = new PriorityQueue<>(Comparator.comparingInt(a -> a.data));
        int k = listArray.length;
        if (k == 0) {
            return null;
        }
        for (int i = 0; i < k; i++) {
            if (listArray[i] != null) {
                minHeap.add(listArray[i]);
            }
        }

        LinkedListNode<Integer> head = null, last = null;
        while (!minHeap.isEmpty()) {
            LinkedListNode<Integer> top = minHeap.poll();
            if (top.next != null) {
                minHeap.add(top.next);
            }
            if (head == null) {
                head = top;
                last = top;
            } else {
                last.next = top;
                last = top;
            }
        }
        return head;
    }
}

