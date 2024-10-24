package com.java.theory.multitThreads;

public class MultiThreadMain {

	public static void main(String[] args) {
		World world = new World();
		world.start();
		
		WorldImpl worldImpl = new WorldImpl();
		worldImpl.run();
		//Thread t1 = new Thread(worldImpl);
		//t1.start();
		
		for (int i = 0; i < 1000; i++) {
			System.out.println("Hello World");
		}
		

	}

}
