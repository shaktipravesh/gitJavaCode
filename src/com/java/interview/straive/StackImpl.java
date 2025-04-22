package com.java.interview.straive;

public class StackImpl {
    private final int[] arr;
    int top;
    int capacity;

    StackImpl(int capacity) {
        arr = new int[capacity];
        this.capacity = capacity;
        int top = -1;
    }

    public void push(int num) {
        if(top == capacity-1) {
            System.out.println("Stack is full");
            return;
        } else {
            top++;
            arr[top] = num;
        }
    }
    public int peek() {
        if(top>= 0) {
            return arr[top];
        } else {
            System.out.println("Stack is Empty");
        }
        return -1;
    }

    public int pop() {
        if(top >= 0) {
            int res = arr[top];
            top--;
            return res;
        } else {
            System.out.println("Stack is empty");
        }
        return -1;
    }

    public boolean isEmpty() {
        return top == -1;
    }

    public boolean isFull() {
        return top == capacity - 1;
    }

}
