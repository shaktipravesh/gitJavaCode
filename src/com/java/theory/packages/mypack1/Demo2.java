package com.java.theory.packages.mypack1;

public class Demo2 {
	Demo1 d1 = new Demo1();
	public void show() {
		System.out.println(d1.a /* + d1.b The field Demo1.b is not visible */ + d1.c + d1.d);
	}

}
