package com.java.interview.straive;

public class QueueImpl {
    private final int[] arr;
    int start;
    int end;
    int capacity;

    public QueueImpl(int capacity) {
        this.capacity = capacity;
        arr = new int[capacity];
        start = -1;
        end = 0;
    }

    public void enqueue(int num) {
        if(end == capacity -1) {
            System.out.println("Queue is full");
        } else {
            start++;
            arr[start] = num;
        }
    }

    public int dequeue() {
        if (start == -1) {
            System.out.println("Queue is empty");
            return -1;
        } else {
            int res = arr[end];
            end++;
            return res;
        }
    }

    public int peek() {
        if(start == -1) {
            System.out.println("Queue is empty");
            return -1;
        } else {
            return arr[end];
        }
    }


}
