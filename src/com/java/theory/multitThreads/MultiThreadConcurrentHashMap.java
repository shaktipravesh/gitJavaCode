package com.java.theory.multitThreads;

import java.util.HashMap;
import java.util.concurrent.ConcurrentHashMap;

public class MultiThreadConcurrentHashMap {
    public static void main(String[] args) {
        //basicHashMap();
        concurrentHashMap();

    }

    public static void concurrentHashMap() {
        ConcurrentHashMap<String, Integer> map = new ConcurrentHashMap<>();

        Runnable writerTask = () -> {
            for (int i = 0; i < 100; i++) {
                map.put("Key" + i, i);
                System.out.println(Thread.currentThread().getName() + "ConcurrentHashMap added: Key " + i);
            }
        };

        Runnable readerTask = () -> {
            for (int i = 0; i < 100; i++) {
                System.out.println(Thread.currentThread().getName() + "ConcurrentHashMap read: " + map.get("Key " + i));
            }
        };

        Thread thread1 = new Thread(writerTask);
        Thread thread2 = new Thread(readerTask);

        thread1.start();
        thread2.start();
    }
    public static void basicHashMap() {
        HashMap<String, Integer> map = new HashMap<>();

        Runnable writerTask = () -> {
            for (int i = 0; i < 10; i++) {
                map.put("Key" + i, i);
                System.out.println(Thread.currentThread().getName() + "HashMap added: Key " + i);
            }
        };

        Runnable readerTask = () -> {
            for (int i = 0; i < 10; i++) {
                System.out.println(Thread.currentThread().getName() + "HashMap read: " + map.get("Key " + i));
            }
        };

        Thread thread1 = new Thread(writerTask);
        Thread thread2 = new Thread(readerTask);

        thread1.start();
        thread2.start();
    }
}
