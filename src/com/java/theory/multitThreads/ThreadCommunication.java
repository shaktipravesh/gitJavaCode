package com.java.theory.multitThreads;

import javax.swing.plaf.TableHeaderUI;

class Producer implements Runnable {
    private final SharedResource sharedResource;

    public Producer(SharedResource sharedResource) {
        this.sharedResource = sharedResource;
    }
    public void run() {
        for (int i = 0; i < 10; i++) {
            sharedResource.produce(i);
        }
    }
}

class Consumer implements Runnable {
    private final SharedResource sharedResource;
    public Consumer(SharedResource sharedResource) {
        this.sharedResource = sharedResource;
    }
    public void run() {
        for (int i = 0; i < 10; i++) {
            int value = sharedResource.consume();;
        }
    }
}

class SharedResource {
    private int data;
    private boolean hasData;

    public synchronized void produce(int value) {
        while (hasData) {
            try {
                wait();
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }
        data = value;
        hasData = true;
        System.out.println("Produced: " + value);
        notify();
    }

    public synchronized int consume() {
        while (!hasData) {
            try {
                wait();
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }
        hasData = false;
        System.out.println("Consumed: " + data);
        notify();
        return data;
    }
}

public class ThreadCommunication {
    public static void main(String[] args) {
        SharedResource sharedResource = new SharedResource();
        Thread producer = new Thread(new Producer(sharedResource));
        Thread consumer = new Thread(new Consumer(sharedResource));
        producer.start();
        consumer.start();

    }
}
