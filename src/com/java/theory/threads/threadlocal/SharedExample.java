package com.java.theory.threads.threadlocal;

public class SharedExample {
    private String userName;

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public void printUser() {
        System.out.println(Thread.currentThread().getName() + " : " + userName);
    }

    public static void main(String[] args) {
        SharedExample sharedExample = new SharedExample();

        Thread t1 = new Thread(() -> {
            sharedExample.setUserName("John");
            sharedExample.printUser();
        });
        Thread t2 = new Thread(() -> {
            sharedExample.setUserName("Jane");
            sharedExample.printUser();
        });

        t1.start();
        t2.start();


    }
}
