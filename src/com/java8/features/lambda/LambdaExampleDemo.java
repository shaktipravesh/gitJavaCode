package com.java8.features.lambda;

@FunctionalInterface
interface Printhello {
	public void sayHello();
}

@FunctionalInterface
interface Child extends Printhello{

}

interface Sum {
	public int addNum(int a, int b);
}

public class LambdaExampleDemo {

	//1
	public void name() {
		System.out.println("Hello Lambda");
	}
	
	
	//2
	public int addNum(int a, int b) {
		return a + b;
	}
	
	
	@SuppressWarnings("unused")
	public static void main(String[] args) {

		Printhello printhello = ()-> System.out.println("hello Function Interface");
		
		Sum sum = (int a, int b) -> { return a+b; };
		Sum sum1 = (a, b) -> { return a+b; };
		Sum sum2 = (int a, int b) -> a+b;
		Sum sum3 = (a, b) -> a+b;
				
	}

}
