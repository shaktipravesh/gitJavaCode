package com.java.theory.multitThreads;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class ReEntrantExample {
    private final Lock lock = new ReentrantLock();

    public void outerMethod() {
        try {
            lock.lockInterruptibly();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        lock.lock();
        try {
            System.out.println(Thread.currentThread().getName() + " Outer Method");
            innerMethod();
        } finally {
            lock.unlock();
        }
    }

    private void innerMethod() {
        lock.lock();
        try {
            System.out.println("Inside inner method");
        } finally {
            lock.unlock();
        }
    }

    public static void main(String[] args) {
        ReEntrantExample example = new ReEntrantExample();
        example.outerMethod();
    }
}
