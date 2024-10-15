package com.java8.features.consumer;

import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;

public class ConsumerInterface {
	public static void main(String[] args) {
		Consumer<String> consumer = s-> System.out.println(s);
		consumer.accept("Shakti Pravesh");
		
		Consumer<List<Integer>> consumerListAdd = li -> {
			for(Integer i : li) {
				System.out.println(i + 100);
			}
		};
		
		consumerListAdd.accept(Arrays.asList(1, 2, 3, 4));
		
		
		Consumer<List<Integer>> consumerList = li -> {
			for(Integer i : li) {
				System.out.println(i);
			}
		};
		
		consumerList.andThen(consumerListAdd).accept(Arrays.asList(1, 2, 3, 4, 5, 6));
	}

}
