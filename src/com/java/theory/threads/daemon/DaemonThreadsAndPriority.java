package com.java.theory.threads.daemon;

import static java.lang.System.*;

public class DaemonThreadsAndPriority {
    public static void main(String[] args) {
        Thread daemon = new Thread(() -> out.println("Daemon thread"));
        daemon.setDaemon(true);

        Thread user = new Thread(() -> out.println("User thread"));

        daemon.start();
        user.start();
    }
}
