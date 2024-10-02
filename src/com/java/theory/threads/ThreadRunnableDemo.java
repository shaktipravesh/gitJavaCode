package com.java.theory.threads;


class AA implements Runnable{
	public void run() {
		for(int i = 0; i < 20; i++) {
			System.out.println("Hi AA");
			try {
				Thread.sleep(3);
			} catch (InterruptedException e) {
				System.out.println(e.getMessage());
				e.printStackTrace();
			}
		}
	}
}

class BB implements Runnable{
	public void run() {
		for(int i = 0; i < 20; i++) {
			System.out.println("Hi BB");
			try {
				Thread.sleep(3);
			} catch (InterruptedException e) {
				System.out.println(e.getMessage());
				e.printStackTrace();
			}
		}
	}
}


public class ThreadRunnableDemo {

	public static void main(String[] args) {
		AA a = new AA();
		BB b = new BB();
		Thread t1 = new Thread(a);
		Thread t2 = new Thread(b);
		t1.start();
		t2.start();
		/*
		 * a.run(); b.run();
		 */

	}

}
