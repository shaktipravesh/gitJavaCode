package com.java8.features.stream;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class StreamDemo {

	public static void main(String[] args) {
		List<Integer> list = Arrays.asList(1, 4, 2, 6, 78, 55,2,12,867,231,123,67, 645, 42);
		System.out.println(list.stream().max((a, b)-> a-b));
		list = (List<Integer>) list.stream().sorted((a, b) -> (b-a)).toList();
		System.out.println(list);
		String str = "Shakti:Pravesh,Beena:Rathore";
		Map<String, String> map = Arrays.stream(str.split(",")).map(entry -> entry.split(":")).collect(Collectors.toMap(e -> e[0], e->e[1]));

	}

}
