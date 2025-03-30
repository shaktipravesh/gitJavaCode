package com.java.theory.threads.singleton;

import static java.lang.System.*;

public class ThreadSafeSingleton {
    private volatile static ThreadSafeSingleton instance;
    private ThreadSafeSingleton() {}

    public static ThreadSafeSingleton getInstance() {
        if (instance == null) {
            synchronized (ThreadSafeSingleton.class) {
                if (instance == null) {
                    instance = new ThreadSafeSingleton();
                }
            }
        }
        return instance;
    }

    public static void main(String[] args) {
        ThreadSafeSingleton singleton = ThreadSafeSingleton.getInstance();
        out.println(singleton);
    }
}
