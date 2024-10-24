package com.java.theory.multitThreads.executorframework;

public class MainThreadArray {
    public static void main(String[] args) {
        long startTime = System.currentTimeMillis();
        Thread[] threads = new Thread[10];
        for (int i = 0; i < 10; i++) {
            int finalI = i;
            threads[i] = new Thread(() -> System.out.println(finalI +": " +factorial(finalI)));
            threads[i].start();
        }

        for(Thread thread : threads) {
            try {
                thread.join();
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }

        System.out.println("Total time: " + (System.currentTimeMillis() - startTime));
    }

    private static long factorial(int i) {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        long result = 1;
        for (int j = 1; j <= i; j++) {
            result *= j;
        }
        return result;
    }
}
