package com.java.theory.threads.reentrantlock;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import java.util.logging.Logger;

import static java.lang.Thread.sleep;

public class StarvationExample {
    Logger logger = Logger.getLogger("StarvationExample");
    public synchronized void criticalSection() {
        logger.info(Thread.currentThread().getName() +  " critical section entered");
        try{
            sleep(5000);
        } catch (Exception e) {
            Thread.currentThread().interrupt();
        }
        logger.info(Thread.currentThread().getName() +  " critical section exited");
    }

    public void deadlockPrevention() {
        Lock lock = new ReentrantLock();
        boolean locked = false;
        try {
            locked = lock.tryLock(1000, TimeUnit.SECONDS);
            if(locked) {
                logger.info(Thread.currentThread().getName() +  " lock acquired");
            } else {
                logger.info(Thread.currentThread().getName() +  " lock not acquired");
            }
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        } finally {
            lock.unlock();
        }
    }

    public void lockDowngrading() {
        Lock lock = new ReentrantLock();
        lock.lock(); //First lock
        try {
            logger.info(Thread.currentThread().getName() +  " lock acquired");
            //critical section
            lock.lock();
            try {
                logger.info(Thread.currentThread().getName() +  " lock acquired");
            } finally {
                lock.unlock();
            }
        } finally {
            lock.unlock();
        }
    }

    public void conditionVariableReentrantLock() {
        Lock lock = new ReentrantLock();
        Condition condition = lock.newCondition();
        //Producer Thread
        new Thread(() -> {
            lock.lock();
            try {
                condition.signal();
                logger.info(Thread.currentThread().getName() +  " lock acquired");
            } finally {
                lock.unlock();
            }
        }).start();

        new Thread(() -> {
            lock.lock();
            try {
                condition.await();
                logger.info(Thread.currentThread().getName() +  " lock acquired");
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            } finally {
                lock.unlock();
            }
        }).start();
    }

    public static void main(String[] args) {
        StarvationExample starvationExample = new StarvationExample();

        Runnable runnable = starvationExample::criticalSection;

        for(int i = 0; i < 10; i++){
            Thread thread = new Thread(runnable);
            thread.start();
        }
    }
}
