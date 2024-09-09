package com.java.algoNDataStucture.workat;

class ListNode {
	int data; 
	ListNode next;
	ListNode down;
	public ListNode(int data) {
		this.data = data;
		this.next = null;
		// TODO Auto-generated constructor stub
	}
}

public class MergeSortLinkedList {

	public static void main(String[] args) {
		int[] num = {1, 6, 9, 4, 3, 5, 2, 8, 10, 7};
		ListNode head = null;
		ListNode newNode = null;
		for(int i = 0; i < num.length; i++) {
			ListNode nextNode = new ListNode(num[i]);
			if(head == null) {
				head = nextNode;
				newNode = nextNode;
			} else {
				newNode.next = nextNode;
				newNode = newNode.next;
			}
		}
		MergeSortLinkedList mergeSortLinkedList = new MergeSortLinkedList();
		mergeSortLinkedList.mergeSort(head);
		System.out.println(head);

	}
	
	ListNode mergeSort(ListNode head) {
		// add your logic here
		
		if(head == null || head.next == null) {
			return head;
		}
		
		ListNode middleNode = getMiddleNode(head);
		
		head = mergeSort(head);
		middleNode = mergeSort(middleNode);
		
		head = mergeSortedListNode(head, middleNode);
		
		return head;
	}
	
	private ListNode mergeSortedListNode(ListNode left, ListNode middleNode) {
		// TODO Auto-generated method stub
		ListNode head = middleNode; 
		ListNode mergedHead = middleNode; 
		if(left.data <= middleNode.data) {
			head = left;
			mergedHead = left;
			left = left.next;
		} else {
			middleNode = middleNode.next;
		}
		while(left != null && middleNode != null) {
			if(left.data <= middleNode.data) {
				head.next = left;
				left = left.next;
			} else {
				head.next = middleNode;
				middleNode = middleNode.next;
			}
			head = head.next;
		}
		
		if(left != null) {
			head.next = left;
		}
		if(middleNode != null) {
			head.next = middleNode;
		}
		left = head;
		return mergedHead;
	}

	ListNode getMiddleNode(ListNode head) {
		ListNode left = head;
		ListNode right = head;
		ListNode middleNode = head;
		while(right.next != null && right.next.next != null) {
			left = left.next;
			right = right.next.next;
		}
		middleNode= left.next;
		left.next = null;
		return middleNode;
	}
}
