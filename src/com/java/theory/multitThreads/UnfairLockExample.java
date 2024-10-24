package com.java.theory.multitThreads;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class UnfairLockExample {
    private final Lock unfairLock = new ReentrantLock();

    private void accessResource() {
        unfairLock.lock();
        try {
            System.out.println(Thread.currentThread().getName() + " accessing resource");
            Thread.sleep(500);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        } finally {
            unfairLock.unlock();
            System.out.println(Thread.currentThread().getName() + " released resource");
        }
    }

    public static void main(String[] args) {
        UnfairLockExample example = new UnfairLockExample();

        Runnable runnable = example::accessResource;

        Thread thread1 = new Thread(runnable, "Thread 1");
        Thread thread2 = new Thread(runnable, "Thread 2");
        Thread thread3 = new Thread(runnable, "Thread 3");
        Thread thread4 = new Thread(runnable, "Thread 4");
        thread1.start();
        thread2.start();
        thread3.start();
        thread4.start();

    }
}
