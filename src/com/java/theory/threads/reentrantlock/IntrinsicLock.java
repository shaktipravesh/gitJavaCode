package com.java.theory.threads.reentrantlock;

import java.util.logging.Logger;

public class IntrinsicLock {
    static Logger logger = Logger.getLogger("IntrinsicLock");
    public static void main(String[] args) throws InterruptedException {
        SynchronizedMethodCounter counter = new SynchronizedMethodCounter();

        Thread t1 = new Thread(() -> {
            for (int i = 0; i < 10; i++) {
                counter.increment();
            }
        });
        Thread t2 = new Thread(() -> {
            for (int i = 0; i < 10; i++) {
                counter.increment();
            }
        });
        t1.start();
        t2.start();

        t1.join();
        t2.join();

        logger.info("Count: " + counter);
    }
}

class SynchronizedMethodCounter {
    private int counter = 0;

    public synchronized void increment() {
        counter++;
    }
}

class SynchronizedBlockCounter {
    private int counter = 0;
    public void increment() {
        synchronized (this) {
            counter++;
        }
    }
}