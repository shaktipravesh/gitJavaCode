package com.java8.features.functionalInterface;

@FunctionalInterface
public interface MyInterface {
	public void sayHallo();
	default void sayBye() {
		System.out.println("Say Bye");
	};
}

