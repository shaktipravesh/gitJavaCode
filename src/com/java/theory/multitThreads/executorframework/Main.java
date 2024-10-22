package com.java.theory.multitThreads.executorframework;

public class Main {
    public static void main(String[] args) {
        long startTime = System.currentTimeMillis();
        for (int i = 0; i < 10; i++) {
            System.out.println(factorial(i));
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
