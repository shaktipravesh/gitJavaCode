package com.java.theory.threads;

class Counter {
	int count;
	public void increament() {
		count++;
	}
	
}

public class ThreadDemoMutable {

	public static void main(String[] args) throws InterruptedException {
		Counter c = new Counter();
		Runnable a =()-> {
			for(int i = 0; i < 2000; i++) {
				c.increament();
			}
		};
		
		Runnable b =()-> {
			for(int i = 0; i < 2000; i++) {
				c.increament();
			}
		};
		Thread t1 = new Thread(a);
		Thread t2 = new Thread(b);
		t1.start();
		t2.start();
		t1.join();
		t2.join();
		System.out.println(c.count);
	}

}
