package com.java8.features.supplier;

import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

public class SupplierInterface {

	public static void main(String[] args) {
		Supplier<Integer> supplier =() -> 1;
		System.out.println(supplier.get());
		
		
		Predicate<Integer> predicate = x -> x % 2 == 0;
		
		Function<Integer, Integer> function = x -> x*x;
		
		Supplier<Integer> supplier2 = () -> 45;
		
		Consumer<Integer> consumer = x -> System.out.println(x);
		
		if(predicate.test(supplier2.get())) {
			consumer.accept(function.apply(supplier2.get()));
		}
		
		
	}

}
