package com.java.algoNDataStucture.workat.StackNQueue;

public class ImplementStackUsingQueues {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}


class StackUsingQueue {
	Queue stackQueue;
	Queue stackQueueBuff;
	public StackUsingQueue (int capacity) {
		stackQueue = new Queue(capacity);
		stackQueueBuff = new Queue(capacity);
	}

	public boolean isEmpty() {
		return stackQueue.isEmpty();
	}
	
	public int size() {
		return stackQueue.size();
	}
	
	public int top() {
		int top = -1;
		if(isEmpty()) {
			return -1;
		}
		while(!isEmpty()) {
			top = stackQueue.front();
			stackQueueBuff.push(top);
			stackQueue.pop();
		}
		while(!stackQueueBuff.isEmpty()) {
			stackQueue.push(stackQueueBuff.front());
			stackQueueBuff.pop();
		}
		return top;
	}
	
	public void push(int element) {
		stackQueue.push(element);
	}
	
	public void pop() {
		if(isEmpty()) {
			return;
		}
		while(!isEmpty()) {
			stackQueueBuff.push(stackQueue.front());
			stackQueue.pop();
		}
		while(!stackQueueBuff.isEmpty()) {
			if(stackQueueBuff.size() > 1 ) {
				stackQueue.push(stackQueueBuff.front());
			}
			stackQueueBuff.pop();
		}
	}
}