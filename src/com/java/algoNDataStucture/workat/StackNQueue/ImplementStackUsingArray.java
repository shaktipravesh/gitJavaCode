package com.java.algoNDataStucture.workat.StackNQueue;

public class ImplementStackUsingArray {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}


/*

class Stack {
	int iMAX = 0; 
	int top;
	int[] a;
	public Stack (int capacity) {
		a = new int[capacity]; 
		top = -1;
		iMAX = capacity;
	}

	public boolean isEmpty() {
		if(top == -1) {
			return true;
		}
		return false;
	}
	
	public int size() {
		return top;
	}
	
	public int top() {
		return a[top--];
	}
	
	public void push(int element) {
        if (top >= iMAX) { 
            System.out.println("Stack Overflow"); 
            return; 
        } 
		a[top++] = element;
	}
	
	public void pop() {
		top--;
	}
}

*/