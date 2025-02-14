package com.java8.features.functionalInterface;

/*
@FunctionalInterface
public interface Child extends Parent{
}
*/
/*
@FunctionalInterface
public interface Child extends Parent{
	public void SayHallo();
}
*/

@FunctionalInterface
public interface Child extends Parent{
	public void SayHallo();
	default void SayBye() {
		System.out.println("Say Bye to child");
	}
}
