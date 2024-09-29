package com.java8.features;

import java.util.Arrays;
import java.util.List;

public class FirstCode {

	public static void main(String[] args) {
		List<String> names = Arrays.asList("Shakti", "Pravesh", "Suhasini", "Vincit");
		names.forEach(System.out::println);
	}

}
