package com.java.theory.threads;

class A extends Thread{
	public void run() {
		PrintThreadRequest printThreadRequest = new PrintThreadRequest();
		printThreadRequest.printThread("Hi A");
	}
}

class B extends Thread{
	public void run() {
		PrintThreadRequest printThreadRequest = new PrintThreadRequest();
		printThreadRequest.printThread("Hi BB");
	}
}

class PrintThreadRequest {
	void printThread(String str) {
		for(int i = 0; i < 20; i++) {
			System.out.println(str);
			try {
				Thread.sleep(3);
			} catch (InterruptedException e) {
				System.out.println(e.getMessage());
			}
		}
	}
}

public class ThreadDemo {

	public static void main(String[] args) {
		A a = new A();
		B b = new B();
		System.out.println(a.getPriority());
		
		//b.setPriority(Thread.MAX_PRIORITY);
		System.out.println(b.getPriority());
		a.start();
		b.start();
//		a.show();
//		b.show();

	}

}
