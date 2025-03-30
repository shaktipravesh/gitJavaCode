package com.java.theory.threads.executerservice;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingDeque;

import static java.lang.System.*;

public class ExecuteProducerConsumer {
    public static void main(String[] args) {
        LinkedBlockingDeque<Integer> queue = new LinkedBlockingDeque<>();
        ExecutorService executorService = Executors.newCachedThreadPool();
        executorService.execute(()-> {
            try {
                for (int i = 0; i < 10; i++) {
                    queue.offer(i);
                }
            } catch (Exception e) {
                Thread.currentThread().interrupt();
            }
        });
        executorService.execute(()-> {
            try {
                for (int i = 0; i < 10; i++) {
                    out.println(queue.poll());
                }
            } catch (Exception e) {
                Thread.currentThread().interrupt();
            }
        });
        executorService.shutdown();
    }
}
