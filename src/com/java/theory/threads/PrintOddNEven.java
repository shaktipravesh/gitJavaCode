package com.java.theory.threads;

import static java.lang.System.*;

public class PrintOddNEven {
    int counter = 0;
    int limit = 20;

    public static void main(String[] args) {
        PrintOddNEven printOddNEven = new PrintOddNEven();
        Thread t1 = new Thread(() -> {
            try {
                printOddNEven.printOdd();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        });
        Thread t2 = new Thread(() -> {
            try {
                printOddNEven.printEven();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        });
        t1.start();
        t2.start();
    }

    public synchronized void printEven() throws InterruptedException {
        while (counter < limit) {
            if(counter % 2 == 0) {
                counter++;
                out.println(Thread.currentThread().getName() + ": " + counter);
                notifyAll();
            } else {
                wait();
            }
        }
    }

    public synchronized void printOdd() throws InterruptedException {
        while (counter < limit) {
            if(counter % 2 == 1) {
                counter++;
                out.println(Thread.currentThread().getName() + ": " + counter);
                notifyAll();
            } else {
                wait();
            }
        }
    }
}
