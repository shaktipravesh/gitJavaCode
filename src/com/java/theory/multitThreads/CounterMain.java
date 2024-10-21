package com.java.theory.multitThreads;

public class CounterMain {
    public static void main(String[] args) {
        Counter counter = new Counter();
        CounterThread counterThread1 = new CounterThread(counter);
        CounterThread counterThread2 = new CounterThread(counter);
        counterThread1.start();
        counterThread2.start();
        try {
            counterThread1.join();
            counterThread2.join();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        System.out.println(counter.getCount());

    }
}
