package com.java.theory.multitThreads;

public class BankAccountMain {
    public static void main(String[] args) {
        BankAccount bankAccount = new BankAccount();
        Runnable task = new Runnable() {
            @Override
            public void run() {
                bankAccount.withdraw(50);
            }
        };
        Thread thread1 = new Thread(task, "Thread 1");
        Thread thread2 = new Thread(task, "Thread 2");
        thread1.start();
        thread2.start();


    }
}
