package com.java.theory.threads;

/*
class ALambda implements Runnable{
	public void run() {
		for(int i = 0; i < 20; i++) {
			System.out.println("Hi ALambda");
			try {
				Thread.sleep(3);
			} catch (InterruptedException e) {
				System.out.println(e.getMessage());
				e.printStackTrace();
			}
		}
	}
}
*/

class BLambda implements Runnable{
	public void run() {
		for(int i = 0; i < 20; i++) {
			System.out.println("Hi BLambda");
			try {
				Thread.sleep(3);
			} catch (InterruptedException e) {
				System.out.println(e.getMessage());
				e.printStackTrace();
			}
		}
	}
}


public class ThreadLambdaDemo {

	public static void main(String[] args) {
		Runnable a =()-> {
				for(int i = 0; i < 20; i++) {
					System.out.println("Hi ALambda");
					try {Thread.sleep(3);} catch (InterruptedException e) {};
				}
				
			};
		
		BLambda b = new BLambda();
		Thread t1 = new Thread(a);
		Thread t2 = new Thread(b);
		t1.start();
		t2.start();
	}

}
