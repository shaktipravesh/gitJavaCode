package com.java8.features;


interface Parent {
	default void sayHallo() {
		System.out.println("Say Hallo");
	}
}

class Child implements Parent {
	@Override
	public void sayHallo() {
		System.out.println("Child Say Hallo");
	}
}

public class defaultMethods {
	public static void main(String[] args) {
		Child child = new Child();
		child.sayHallo();
	}

}
