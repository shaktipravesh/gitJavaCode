package com.java.theory.multitThreads;

class Pen {
    public synchronized void writeWithPenNPaper(Paper paper) {
        System.out.println(Thread.currentThread().getName() + ": is using Pen " + this + "and trying to write");
        paper.finishWriting();
    }

    public synchronized void finishWriting() {
        System.out.println(Thread.currentThread().getName() + ": finishWriting with Pen" + this);
    }
}

class Paper {
    public synchronized void writeWithPenNPaper(Pen pen) {
        System.out.println(Thread.currentThread().getName() + ": is using Paper " + this + "and trying to write");
        pen.finishWriting();
    }

    public synchronized void finishWriting() {
        System.out.println(Thread.currentThread().getName() + ": finishWriting with Paper" + this);
    }

}

class Task1 implements Runnable {
    private Paper paper;
    private Pen pen;

    public Task1(Pen pen, Paper paper) {
        this.paper = paper;
        this.pen = pen;
    }
    public void run() {
        synchronized (paper) {
            pen.writeWithPenNPaper(paper);
        }
        //pen.writeWithPenNPaper(paper);
    }
}

class Task2 implements Runnable {
    private Paper paper;
    private Pen pen;
    public Task2(Pen pen, Paper paper) {
        this.paper = paper;
        this.pen = pen;
    }

    public void run() {
        paper.writeWithPenNPaper(pen);
    }
}
public class DeadLockExample {
    public static void main(String[] args) {
        Pen pen = new Pen();
        Paper paper = new Paper();

        Thread thread1 = new Thread( new Task1(pen, paper));
        Thread thread2 = new Thread( new Task2(pen, paper));

        thread1.start();
        thread2.start();
    }
}
