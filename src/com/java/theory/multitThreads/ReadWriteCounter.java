package com.java.theory.multitThreads;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class ReadWriteCounter {
    private int counter = 0;
    private final ReadWriteLock lock = new ReentrantReadWriteLock();
    private final Lock readLock = lock.readLock();
    private final Lock writeLock = lock.writeLock();

    public void increment() {
        writeLock.lock();
        try {
            counter++;
            Thread.sleep(50);
        } catch (Exception e) {
            throw new RuntimeException(e);
        } finally {
            writeLock.unlock();
        }
    }

    public int getCounter() {
        readLock.lock();
        try {
            return counter;
        } catch (Exception e) {
            throw new RuntimeException(e);
        } finally {
            readLock.unlock();
        }
    }

    public static void main(String[] args) throws InterruptedException {
        ReadWriteCounter rwc = new ReadWriteCounter();
        Runnable readTask = new Runnable() {
            public void run() {
                for (int i = 0; i < 100; i++) {
                    System.out.println(Thread.currentThread().getName() + ": " + rwc.getCounter()  );
                }
            }
        };

        Runnable writeTask = new Runnable() {
            public void run() {
                for (int i = 0; i < 100; i++) {
                    rwc.increment();
                    System.out.println(Thread.currentThread().getName() + ": incremented"  );
                }
            }
        };

        Thread writerThread = new Thread(writeTask);
        Thread readerThread1 = new Thread(readTask);
        Thread readerThread2 = new Thread(readTask);

        writerThread.start();
        readerThread1.start();
        readerThread2.start();

        writerThread.join();
        readerThread1.join();
        readerThread2.join();

        System.out.println("Final counter: " + rwc.getCounter());



    }
}
