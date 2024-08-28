package com.java.algoNDataStucture.workat.StackNQueue;

public class ImplementQueueUsingArray {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}


class Queue {
	
	int[] queue;
	int front = 0, rear = -1, capacity, currentSize;
	
	Queue (int capacity) {
		this.capacity = capacity;
		queue = new int[capacity];
		front = -1;
		rear = -1;
		currentSize = 0;
	}

	boolean isEmpty() {
		return currentSize == 0;
	}
	
	int size() {
		return currentSize;
	}
	
	int front() {
		if(front < 0) {
			return front;
		}
		return queue[front];
	}
	
	int back() {
		if(rear < 0) {
			return rear;
		}
		return queue[rear];
	}
	
	void push(int element) {
		rear++;
		if(rear == capacity) {
			rear--;
			return;
		}
		queue[rear] = element;
		if(front < 0) {
			front = 0;
		}
		currentSize++;
	}
	
	void pop() {
		for(int i =0; rear > 0 && i < rear; i++) {
			queue[i] = queue[i+1];
		}
		queue[rear] = 0;
		currentSize--;
		rear--;
		if(rear < 0) {
			front = rear;
		}
		
	}
}