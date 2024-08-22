package com.java.algoNDataStucture.workat;

import java.util.Scanner;

public class FlattenMultiLevelLinkedList {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int iTCs = sc.nextInt();
		for(int i = 0; i < iTCs; i++) {
			int iNext = sc.nextInt();
			int[] aNextLength = new int[iNext];
			for(int j = 0; j < iNext; j++) {
				aNextLength[j] = sc.nextInt();
			}
			ListNode root = null;
			ListNode downNode = null;
			ListNode nextNode = null;
			for(int a = 0 ; a < iNext; a++) {
				for(int b = 0; b < aNextLength[a]; b++) {
					int data = sc.nextInt();
					ListNode node = new ListNode(data);
					if(root == null) {
						root = node;
						downNode = node;
						nextNode = node;
					} else if(b == 0){
						nextNode.next = node;
						downNode = node;
						nextNode = nextNode.next;
					} else {
						downNode.down = node;
						downNode = downNode.down;
					}
				}
			}
			FlattenMultiLevelLinkedList flattenMultiLevelLL = new FlattenMultiLevelLinkedList();
			ListNode flattenLL = flattenMultiLevelLL.flattenTheLinkedList(root);

			while(flattenLL != null) {
				System.out.print(flattenLL.data + " ");
				flattenLL = flattenLL.next;
			}
		}

	}
	
	ListNode flattenTheLinkedList(ListNode root) {
		ListNode flattenLL = null;
		return getFlattenLL(flattenLL, root);
	}
	
	private ListNode getFlattenLL(ListNode flattenLL, ListNode root) {
		if(root == null) {
			return flattenLL;
		}
		ListNode down = root.down;
		ListNode next = root.next;
		if(flattenLL == null) {
			flattenLL = root;
			root.next = null;
			root.down = null;
		} else if(flattenLL.data > root.data){
			root.next = flattenLL;
			root.down = null;
			flattenLL = root;
		} else {
			ListNode insertNodePoint = flattenLL;
			while(insertNodePoint.next != null && insertNodePoint.next.data < root.data) {
				insertNodePoint = insertNodePoint.next;
			}
			if(insertNodePoint.next == null) {
				insertNodePoint.next = root;
				root.next = null;
				root.down = null;
			} else {
				root.next = insertNodePoint.next;
				insertNodePoint.next = root;
				root.down = null;
			}
		}
		if(down != null) {
			flattenLL = getFlattenLL(flattenLL, down);
		} 
		if(next != null) {
			flattenLL = getFlattenLL(flattenLL, next);
		}
		return flattenLL;
	}
}

/*
 * class ListNode { int data; ListNode next; ListNode down;
 * 
 * ListNode(int data) { this.data = data; this.next = null; this.down = null; }
 * }
 */