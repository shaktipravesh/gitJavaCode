package com.java.theory.multitThreads;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

public class CompleteAbleFuture {
    public static void main(String[] args) {

        CompletableFuture<String> completableFuture = CompletableFuture.supplyAsync(()->{
            try {
                Thread.sleep(5000);
                System.out.println("Worker");
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            return "Hello World";
        });
        String str = null;
        try {
            str = completableFuture.get();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        } catch (ExecutionException e) {
            throw new RuntimeException(e);
        }
        System.out.println(str);
        str = completableFuture.getNow("Nonono");
        System.out.println(str);
        System.out.println("Main");

        CompletableFuture<String> completableFuture1 = CompletableFuture.supplyAsync(()->{
            try {
                Thread.sleep(5000);
                System.out.println("Worker1");
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            return "Hello World1";
        });

        CompletableFuture<String> completableFuture2 = CompletableFuture.supplyAsync(()->{
            try {
                Thread.sleep(5000);
                System.out.println("Worker2");
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            return "Hello World2";
        });

        CompletableFuture completableFutureCombined = CompletableFuture.allOf(completableFuture1, completableFuture2);
        completableFutureCombined.join();
        System.out.println("Main completed");

    }
}
