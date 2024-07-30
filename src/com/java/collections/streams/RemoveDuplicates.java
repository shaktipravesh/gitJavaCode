package com.java.collections.streams;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class RemoveDuplicates {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List<String> listOfStrings = Arrays.asList("Shakti", "Pravesh", "Suhasini", "Rathore", "Beena", "Rathore");
		List<String> uniqueStrings = listOfStrings.stream().distinct().collect(Collectors.toList());
		System.out.println(uniqueStrings);

	}

}
