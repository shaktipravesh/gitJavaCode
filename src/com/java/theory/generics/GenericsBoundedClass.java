package com.java.theory.generics;

public class GenericsBoundedClass<T extends Number> {
	private T value;

	public T getValue() {
		return value;
	}

	public void setValue(T value) {
		this.value = value;
	}
}
