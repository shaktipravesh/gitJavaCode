package com.java.theory.multitThreads;

public class World extends Thread{
	public void run() {
		for (int i = 0; i < 1000; i++) {
			System.out.println("Hello Shakti Pravesh");
		}
	}

}


class WorldImpl implements Runnable{
	public void run() {
		for (int i = 0; i < 1000; i++) {
			System.out.println("Hello Runnable Shakti Pravesh");
		}
	}

}