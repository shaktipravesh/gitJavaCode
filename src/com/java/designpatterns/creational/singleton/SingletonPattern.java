package com.java.designpatterns.creational.singleton;

public class SingletonPattern {

	public static void main(String[] args) {
		Singleton.getInstance();
	}

}

class Singleton {

	private static Singleton instance;
	private Singleton() {
		System.out.println("Singleton is Instantiated.");
	}

	public static synchronized void getInstance() {
		if(instance == null) {
			instance = new Singleton();
		}
	}
	
	public static void doSomeThing() {
		System.out.println("Some is done.");
	}
}