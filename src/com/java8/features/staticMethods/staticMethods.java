package com.java8.features.staticMethods;

interface A {
	static public void nameA() {
		System.out.println("hello A");
	}
	
	static public void name() {
		System.out.println("hello name A");
	}
	
}


interface B {
	static public void nameB() {
		System.out.println("hello B");
	}
	
	static public void name() {
		System.out.println("hello name B");
	}
}


public class staticMethods implements A, B{

	public static void main(String[] args) {
		staticMethods staticMethods = new staticMethods();
		//staticMethods.nameA();
		staticMethods.toString();
		A.nameA();
		B.nameB();
		
		//same name can be there no need to override
		A.name();
		B.name();
	}


}
