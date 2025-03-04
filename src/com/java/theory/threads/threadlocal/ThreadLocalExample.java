package com.java.theory.threads.threadlocal;

public class ThreadLocalExample {
    private static ThreadLocal<String> userName = new ThreadLocal<>();

    public void setUserName(String userName) {
        this.userName.set(userName);
    }

    public void printUser() {
        System.out.println(Thread.currentThread().getName() + " : " + this.userName.get());
    }

    public static void main(String[] args) {
        ThreadLocalExample threadLocalExample = new ThreadLocalExample();

        Thread t1 = new Thread(() -> {
            threadLocalExample.setUserName("John");
            threadLocalExample.printUser();
        });
        Thread t2 = new Thread(() -> {
            threadLocalExample.setUserName("Jane");
            threadLocalExample.printUser();
        });

        t1.start();
        t2.start();


    }
}
