package com.java8.features.defaultMethods;

interface A {
	default public void nameA() {
		System.out.println("hello A");
	}
	
	default public void name() {
		System.out.println("hello name A");
	}
}


interface B {
	default public void nameB() {
		System.out.println("hello B");
	}
	
	default public void name() {
		System.out.println("hello name B");
	}
}

public class defaultMethods implements A, B {

	public static void main(String[] args) {
		defaultMethods defaultMethods = new defaultMethods();
		defaultMethods.nameA();
		defaultMethods.nameB();
		defaultMethods.name();

	}

	@Override
	public void name() {
		// TODO Auto-generated method stub
		A.super.name();
		B.super.name();
	}

}
