package com.java.theory.threads.daemon;

import static java.lang.System.*;

public class DaemonDoesNotExecuteFinally {
    public static void main(String[] args) {
        MyDaemon myDaemon = new MyDaemon();
        myDaemon.setDaemon(true);
        myDaemon.start();
        myDaemon.interrupt();
    }
}

class MyDaemon extends Thread {
    @Override
    public void run() throws RuntimeException {
        try {
            out.println("MyDaemon is running");
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            out.println("MyDaemon is interrupted");
            throw new RuntimeException(e);
        } finally {
            out.println("MyDaemon is finally exiting");
        }
    }
}