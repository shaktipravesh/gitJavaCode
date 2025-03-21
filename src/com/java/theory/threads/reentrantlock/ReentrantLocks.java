package com.java.theory.threads.reentrantlock;

import java.util.concurrent.locks.ReentrantLock;
import java.util.concurrent.locks.Lock;

import static java.lang.System.*;

public class ReentrantLocks {
    private final Lock lock = new ReentrantLock();
    private int counter = 0;

    public void increment() {
        lock.lock();
        try{
            counter++;
            out.println(Thread.currentThread().getName()  + ": " + counter);
        } finally {
            lock.unlock();
        }
    }

    public int getCounter() {
        lock.lock();
        try {
            return counter;
        } finally {
            lock.unlock();
        }
    }

    public static void main(String[] args) throws InterruptedException {
        ReentrantLocks lock = new ReentrantLocks();
        Runnable runnable = () -> {
            for (int i = 0; i < 10; i++) {
                lock.increment();
            }
        };
        Thread thread1 = new Thread(runnable);
        Thread thread2 = new Thread(runnable);
        thread1.start();
        thread2.start();
        thread1.join();
        thread2.join();
        out.println("Final Counter: " + lock.getCounter());
    }
}
