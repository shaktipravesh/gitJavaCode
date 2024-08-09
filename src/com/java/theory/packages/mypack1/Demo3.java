package com.java.theory.packages.mypack1;

public class Demo3 extends Demo1{

	public void show() {
		System.out.println(a /* b The field Demo1.b is not visible */ + c + d);
	}

}
