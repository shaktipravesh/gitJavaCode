package com.java8.features;

import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;

/*
class ConsumerImpl implements Consumer<Integer> {

	public void accept(Integer t) {
		System.out.print(t + " ");
	}
	
}
*/

public class DemoForEach {

	public static void main(String[] args) {
		List<Integer> values = Arrays.asList(4, 5, 6, 7, 8);
		for (int i = 0; i < values.size(); i++) {
			System.out.print(values.get(i) + " ");
		}
		System.out.println();

		for(int i : values) {
			System.out.print(i + " ");
		}
		System.out.println();
		
		values.forEach(i -> System.out.print(i + ". "));  //Lambda Expression with for each
		System.out.println();
		
		/*
		Consumer<Integer> c = new ConsumerImpl();
		values.  forEach(c);
		System.out.println();
		*/
		
		Consumer<Integer> c = i -> System.out.print(i + ", "); 
		values.forEach(c);
	}
}
