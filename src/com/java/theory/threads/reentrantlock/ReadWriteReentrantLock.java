package com.java.theory.threads.reentrantlock;

import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;
import java.util.logging.Logger;

import static java.lang.Thread.*;

public class ReadWriteReentrantLock {
    Logger logger = Logger.getLogger("StarvationExample");
    private final ReadWriteLock lock = new ReentrantReadWriteLock();
    private int counter = 0;

    public void readCounter() {
        lock.readLock().lock();
        try {
            logger.info(new StringBuilder().append(currentThread().getName()).append(":Read  ").append(counter).toString());
        } finally {
            lock.readLock().unlock();
        }
    }

    public void writeCounter() {
        lock.writeLock().lock();
        try {
            logger.info(new StringBuilder().append(currentThread().getName()).append(": Write ").append(counter).toString());
            counter++;
        } finally {
            lock.writeLock().unlock();
        }
    }

    public static void main(String[] args) {
        ReadWriteReentrantLock lock = new ReadWriteReentrantLock();
        Runnable runnableReader = () -> {
            for (int i = 0; i < 10; i++) {
                lock.writeCounter();
            }
        };

        Runnable runnableWriter = () -> {
            for (int i = 0; i < 10; i++) {
                lock.readCounter();
            }
        };

        Thread threadReader1 = new Thread(runnableReader);
        Thread threadReader2 = new Thread(runnableReader);
        Thread threadWriter1 = new Thread(runnableWriter);
        threadReader1.start();
        threadReader2.start();
        threadWriter1.start();

    }
}
