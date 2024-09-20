package com.java.algoNDataStucture.workat.StackNQueue;

import java.util.Stack;

public class ImplementMinStack {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}

class MinStack {
	Stack<Integer> stack = new Stack<Integer>();
	Stack<Integer> minStack = new Stack<Integer>();
    void push(int x) {
    	stack.push(x);
    	if(minStack.empty() || x <= getMin()) {
    		minStack.push(x);
    	}
    }
    
    void pop() {
    	if((int)stack.peek() == getMin()) {
    		minStack.pop();
    	}
	    stack.pop();
    }
    
    int top() {
    	return (int) stack.peek();
    }
    
    int getMin() {
	    return (int) minStack.peek();
    }
}