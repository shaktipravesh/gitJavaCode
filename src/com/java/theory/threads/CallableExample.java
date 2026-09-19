package com.java.theory.threads;

import java.util.concurrent.*;

class CallableMessage implements Callable<String> {
    public String call() throws Exception{
        return "Hello World!";
    }
}

public class CallableExample{
    static ExecutorService executor = Executors.newFixedThreadPool(2);
    public static void main(String[] args) throws Exception{
        CallableMessage task = new CallableMessage();
        Future<String> message = executor.submit(task);
        System.out.println(message.get().toString());

    }
}