package com.java.theory.generics;

public class GenericsInterfaceImpl<T> implements GenericsInterface<T>{

	T item;
	@Override
	public void name(T item) {
		this.item = item;
		
	}

	@Override
	public T get() {
		return item;
	}

}
