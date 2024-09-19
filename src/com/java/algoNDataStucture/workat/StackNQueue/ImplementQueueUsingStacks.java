package com.java.algoNDataStucture.workat.StackNQueue;

/*
class Stack {
	Stack (int capacity);
	int size();
	boolean isEmpty();
	int top();
	void push(int element);
	void pop();
}
*/
public class ImplementQueueUsingStacks {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}


class QueueUsingStack {
	Stack queueStack;
	Stack queueStackBuff;
	QueueUsingStack (int capacity) {
		queueStack = new Stack(capacity);
		queueStackBuff = new Stack(capacity);
	}

	boolean isEmpty() {
		if(queueStack.size() == 0) {
			return true;
		} else {
			return false;
		}
	}
	
	int size() {
		return queueStack.size();
	}
	
	int front() {
		int front;
		if(isEmpty()) {
			return -1;
		}
		while(!isEmpty()) {
			queueStackBuff.push(queueStack.top());
			queueStack.pop();
		}
		front = queueStackBuff.top();
		while(!queueStackBuff.isEmpty()) {
			queueStack.push(queueStackBuff.top());
			queueStackBuff.pop();
		}
		return front;
	}
	
	int back() {
		return queueStack.top();
	}
	
	void push(int element) {
		queueStack.push(element);
	}
	
	void pop() {
		if(isEmpty()) {
			return;
		}
		while(!isEmpty()) {
			queueStackBuff.push(queueStack.top());
			queueStack.pop();
		}
		queueStackBuff.pop();
		while(!queueStackBuff.isEmpty()) {
			queueStack.push(queueStackBuff.top());
			queueStackBuff.pop();
		}
	}
}