package com.java8.features;

import java.util.function.Function;

public class FunctionInterface {

	public static void main(String[] args) {
		Function<Integer, Integer> function1 = x-> 2*x;
		Function<Integer, Integer> function2 = x-> x*x;
		
		System.out.println(function1.andThen(function2).apply(3));
		System.out.println(function2.andThen(function1).apply(3));
		
		System.out.println(function1.compose(function2).apply(3));
		

		Function<String, String> functionStr = Function.identity();
		System.out.println(functionStr.apply("Shakti"));
	}

}
