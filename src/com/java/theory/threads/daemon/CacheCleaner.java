package com.java.theory.threads.daemon;

import static java.lang.System.*;

public class CacheCleaner extends Thread {
    public CacheCleaner() {
        setDaemon(true);
    }

    @Override
    public void run() {
        while (true) {
            out.println("Cleaning cache...");
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                e.printStackTrace();
                Thread.currentThread().interrupt();
            }
        }
    }

    public static void main(String[] args) {
        new CacheCleaner().start();
        out.println("Main thread completed");
    }
}
