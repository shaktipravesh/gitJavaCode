package com.java8.features;

interface Phone {
	void call();
	default void message() {
		System.out.println("Phone Message default");
	}
}

class Android implements Phone {

	@Override
	public void call() {
		System.out.println("Android Phone calling");
	}
	
}

public class DemoInterface {

	public static void main(String[] args) {
		Phone p = new Android();
		p.call();
		p.message();
	}
}
