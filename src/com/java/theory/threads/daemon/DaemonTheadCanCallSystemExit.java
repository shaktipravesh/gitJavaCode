package com.java.theory.threads.daemon;

import static java.lang.System.*;

public class DaemonTheadCanCallSystemExit {

    public static void main(String[] args) {
        MyDaemonSystemExit daemon = new MyDaemonSystemExit();
        daemon.setDaemon(true);
        daemon.start();

        out.println("Daemon exiting.");
    }
}

class MyDaemonSystemExit extends Thread {
    @Override
    public void run() {
        out.println("MyDaemonSystemExit is running");
        exit(0);
    }

}