package com.java.theory.multitThreads;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class FairnessLockExample {
    private final Lock lock = new ReentrantLock(true);

    private void accessResource() {
        lock.lock();
        try {
            System.out.println(Thread.currentThread().getName() + " accessing resource");
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        } finally {
            lock.unlock();
            System.out.println(Thread.currentThread().getName() + " released resource");
        }
    }

    public static void main(String[] args) {
        FairnessLockExample example = new FairnessLockExample();

        Runnable runnable = example::accessResource;

        Thread thread1 = new Thread(runnable, "Fair Thread 1");
        Thread thread2 = new Thread(runnable, "Fair Thread 2");
        Thread thread3 = new Thread(runnable, "Fair Thread 3");
        Thread thread4 = new Thread(runnable, "Fair Thread 4");

        thread1.start();
        try {
            Thread.sleep(50);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        thread2.start();
        try {
            Thread.sleep(50);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        thread3.start();
        try {
            Thread.sleep(50);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        thread4.start();

    }
}
