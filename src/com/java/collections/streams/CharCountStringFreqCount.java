package com.java.collections.streams;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class CharCountStringFreqCount {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String inputString = "Shakti Pravesh Suhasini Rathore Vincit Beena Rathore";
		Map<Character, Long> map = inputString.toLowerCase().chars().mapToObj(c-> (char) c).collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
		System.out.println(map);
		
		List<String> nameList = Arrays.asList("Shakti", "Pravesh", "Suhasini", "Rathore", "Beena", "Rathore", "Shakti");
		Map<String, Long> nameCountMap = nameList.stream().collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
		System.out.println(nameCountMap);
	}

}
