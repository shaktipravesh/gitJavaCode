package com.java.algoNDataStucture.workat.StackNQueue;

import java.util.List;

public class ImplementQueueUsingLinkedList {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}

class QueueLinkedList {
	ListNode front;
	ListNode rear;
	int size;
	int totalSize;
	QueueLinkedList (int capacity) {
		this.front = null;
		this.rear = null;
		size = 0;
		totalSize = capacity;
	}

	boolean isEmpty() {
		return front == null;
	}
	
	int size() {
		return size;
	}
	
	int front() {
		if(front != null) {
			return front.data;
		} else {
			return -1;
		}
	}
	
	int back() {
		if(rear != null) {
			return rear.data;
		} else {
			return -1;
		}
	}
	
	void push(int element) {
		size++;
		if(size > totalSize) {
			return;
		}
		ListNode newNode = new ListNode(element);
		if(rear != null) {
			rear.next = newNode;
		}
		rear = newNode;
		if(front == null) {
			front = rear;
		}
		
	}
	
	void pop() {
		if(front != null) {
			front = front.next;
			size--;
		}
		if(front == null) {
			rear = null;
		}
	}
}