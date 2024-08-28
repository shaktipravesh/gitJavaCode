package com.java.algoNDataStucture.workat.StackNQueue;

import java.security.DrbgParameters.Capability;

public class ImplementStackUsingLinkedList {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}

class ListNode {
	int data;
	ListNode next;
	
	ListNode(int data) {
		this.data = data;
		this.next = null;
	}
}

class Stack {

	ListNode top;
	int size;
	int totalSize;
	public Stack (int capacity) {
		this.top = null;
		size = 0;
		totalSize = capacity;
	}

	public boolean isEmpty() {
		return top == null;
	}
	
	public int size() {
		return size;
	}
	
	public int top() {
		if (top != null) {
			return top.data;
		} else {
			return -1;
		}
	}
	
	public void push(int element) {
		size++;
		if(size == totalSize) {
			return;
		}
		ListNode listNode = new ListNode(element);
		listNode.next = top;
		top = listNode;
	}
	
	public void pop() {
		if(top == null) {
			return;
		}
		top = top.next;
		size--;
	}
}