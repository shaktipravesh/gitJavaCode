package com.java.theory.multitThreads;



public class MyThread extends Thread {
    public void run() {
        System.out.println();
    }

    public static void main(String[] args) {
        MyThread t1 = new MyThread();
        System.out.println(t1.getState());
        t1.start();
        System.out.println(t1.getState());
        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println(Thread.currentThread().getState());
        System.out.println(t1.getState());
    }
}
