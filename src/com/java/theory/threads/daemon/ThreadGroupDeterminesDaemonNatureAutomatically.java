package com.java.theory.threads.daemon;

import static java.lang.System.*;

public class ThreadGroupDeterminesDaemonNatureAutomatically {
    public static void main(String[] args) {
        Thread parent = new Thread(() -> {
            Thread child = new Thread(() -> out.println("Is Child Daemon " + Thread.currentThread()));
            child.start();
        });
        parent.setDaemon(true);
        parent.start();
    }
}
