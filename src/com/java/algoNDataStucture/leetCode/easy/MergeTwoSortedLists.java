package com.java.algoNDataStucture.leetCode.easy;

public class MergeTwoSortedLists {
    public static void main(String[] args) {
        ListNode list1 = new ListNode(1);
        list1.next = new ListNode(2);
        list1.next.next = new ListNode(4);
        ListNode list2 = new ListNode(1);
        list2.next = new ListNode(3);
        list2.next.next = new ListNode(4);
        ListNode mergedSortedList = mergeTwoLists(list1, list2);

        while(mergedSortedList != null) {
            System.out.print(mergedSortedList.val + ", ");
            mergedSortedList = mergedSortedList.next;
        }
        System.out.println();
    }

    public static ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode mergedSortedList;
        ListNode mergedListTemp;
        if (list1 == null) {
            mergedSortedList = list2;
        } else if (list2 == null) {
            mergedSortedList = list1;
        } else {
            if (list1.val < list2.val) {
                mergedSortedList = list1;
                list1 = list1.next;
            } else {
                mergedSortedList = list2;
                list2 = list2.next;
            }
            mergedListTemp = mergedSortedList;
            while (list1 != null && list2 != null) {
                if(list1.val < list2.val) {
                    mergedListTemp.next = list1;
                    list1 = list1.next;
                } else {
                    mergedListTemp.next = list2;
                    list2 = list2.next;
                }
                mergedListTemp = mergedListTemp.next;
            }
            if (list1 == null) {
                mergedListTemp.next = list2;
            } else {
                mergedListTemp.next = list1;
            }
        }
        return mergedSortedList;
    }

    private static class ListNode {
      int val;
      ListNode next;
      ListNode() {}
      ListNode(int val) { this.val = val; }
      ListNode(int val, ListNode next) { this.val = val; this.next = next; }
  }
}
