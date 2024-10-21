package com.java.theory.multitThreads;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class BankAccount {
    private int balance = 100;

    private final Lock lock = new ReentrantLock();

    public void withdraw(int amount) {
        System.out.println(Thread.currentThread().getName() + " attempting to lock " + amount);
        try {

            if(lock.tryLock(1000, TimeUnit.MILLISECONDS)) {
                if(balance >= amount) {
                    System.out.println(Thread.currentThread().getName() + ": withdrawing " + amount + " from bank");
                    try {
                        Thread.sleep(3000);
                        balance -= amount;
                        System.out.println(Thread.currentThread().getName() + ": withdrawn " + amount + " from bank");
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    } finally {
                        lock.unlock();
                    }

                } else {
                    System.out.println(Thread.currentThread().getName() + ": insufficient balance ");
                }
            } else {
                System.out.println(Thread.currentThread().getName() + ": lock couldn't acquired");
            }
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
        if(Thread.currentThread().isInterrupted()) {
            System.out.println("Thread is interrupted");
        }
    }

    //public synchronized void withdraw(int amount) {
    /*
    public void withdraw(int amount) {
        System.out.println(Thread.currentThread().getName() + ": withdrawing " + amount + " from bank"  );
        if(balance >= amount) {
            System.out.println(Thread.currentThread().getName() + ": withdrawing " + amount + " from bank");
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            balance -= amount;
        } else {
            System.out.println(Thread.currentThread().getName() + ": insufficient balance ");
        }
    }
    */
}

