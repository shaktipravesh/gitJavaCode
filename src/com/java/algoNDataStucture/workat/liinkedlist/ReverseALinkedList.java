package com.java.algoNDataStucture.workat.liinkedlist;

import java.util.Scanner;

class ListNode {
	int data;
	ListNode next;

	ListNode (int data) {
 		this.data = data;
 	}
}

public class ReverseALinkedList {

	public static void main(String[] args) {
		ReverseALinkedList reverseALinkedList = new ReverseALinkedList();
		try (Scanner sc = new Scanner(System.in)) {
			int iTCs = sc.nextInt();
			for(int j= 0; j < iTCs; j++) {
				int nodes = sc.nextInt();
				ListNode head = null;
				ListNode nextNode = null;

				for(int i = 0; i < nodes; i++) {
					ListNode newNode = new ListNode(sc.nextInt());
					if(head == null) {
						head = newNode;
						nextNode = newNode;
					} else {
						nextNode.next = newNode;
						nextNode = newNode;
					}
					
				}
				head = reverseALinkedList.reverseLinkedList(head);
			}
		}
	}
	
	ListNode reverseLinkedList (ListNode head) {
		ListNode reverseHead = head;
		reverseHead = getReverseLinkedList(reverseHead);
		
		return reverseHead;
		
	}

	private ListNode getReverseLinkedList(ListNode head) {
		if(head.next == null) {
			return head;
		}
		
		ListNode reverseHead = head.next;
		ListNode reversedHead = head.next;
		if(reversedHead.next != null) {
			reversedHead = getReverseLinkedList(reverseHead);
		}
		reverseHead.next = head;
		head.next = null;
		return reversedHead;
	}
}
