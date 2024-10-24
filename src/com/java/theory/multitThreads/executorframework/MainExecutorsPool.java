package com.java.theory.multitThreads.executorframework;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.TimeUnit;

import static java.util.concurrent.Executors.newFixedThreadPool;

public class MainExecutorsPool {
    public static void main(String[] args) {
        long startTime = System.currentTimeMillis();
        ExecutorService executorService = newFixedThreadPool(5);
        for (int i = 0; i < 10; i++) {
            int finalI = i;
            executorService.submit(()-> System.out.println(finalI +": " +factorial(finalI)));
        }
        executorService.shutdown();
        try {
            executorService.awaitTermination(10, TimeUnit.SECONDS);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
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
