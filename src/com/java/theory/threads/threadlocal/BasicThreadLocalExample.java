package com.java.theory.threads.threadlocal;

public class BasicThreadLocalExample {
    private static final ThreadLocal<Integer> threadLocal = ThreadLocal.withInitial(() -> 0);

    public static void main(String[] args) {
        Runnable runnable = () -> {
            int value = threadLocal.get();
            System.out.println(Thread.currentThread().getName() + ": Intial Value = " + threadLocal.get());
            threadLocal.set(value + 4);
            System.out.println(Thread.currentThread().getName() + ": final Value = " + threadLocal.get());

            threadLocal.remove();
        };

        Thread thread1 = new Thread(runnable, "T1");
        Thread thread2 = new Thread(runnable, "T2");
        Thread thread3 = new Thread(runnable, "T3");

        thread1.start();
        thread2.start();
        thread3.start();
    }
}
