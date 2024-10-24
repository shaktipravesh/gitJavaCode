package com.java.theory.multitThreads.executorframework;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class FutureMain {
    public static void main(String[] args) {
        ExecutorService executorService = Executors.newSingleThreadExecutor();

        //When nothing to return
        Runnable runnable = ()-> System.out.println("Hello Runnable");
        Future<?> futureRunnable = executorService.submit(runnable);

        //When return required
        Callable<String> callable = ()-> "Hello Callable";
        Future<String> futureCallable = executorService.submit(callable);

        Future<?> future = executorService.submit(() -> System.out.println("Hello Shakti Pravesh"));

        if (future.isDone()) {
            System.out.println("Task is Done");
        }

        System.out.println(future.isDone());
        executorService.shutdown();
    }
}
