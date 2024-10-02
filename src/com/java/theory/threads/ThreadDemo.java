package com.java.theory.threads;

class A extends Thread{
	public void run() {
		for(int i = 0; i < 20; i++) {
			System.out.println("Hi A");
			try {
				Thread.sleep(3);
			} catch (InterruptedException e) {
				System.out.println(e.getMessage());
				e.printStackTrace();
			}
		}
	}
}

class B extends Thread{
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
