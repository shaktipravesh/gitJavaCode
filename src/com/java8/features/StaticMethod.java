package com.java8.features;


interface staticInterfaceA {
	public static void sayHallo() {
		System.out.println("hello A");
	}
	
	default void sayBye() {
		System.out.println("Bye default");
	}
}

public class StaticMethod implements staticInterfaceA{

	public static void sayHallo() {
		System.out.println("hello AM");
	}
	
	/*
	 * void sayBye() { System.out.println("Bye default"); }  //can't override this method.
	 */
	
	public static void main(String[] args) {
		StaticMethod staticMethod = new StaticMethod();
		staticMethod.sayBye();
		//staticMethod.sayHallo();  //not accessible
		staticInterfaceA.sayHallo();
	}

}
