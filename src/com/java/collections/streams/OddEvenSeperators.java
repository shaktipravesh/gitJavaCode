package com.java.collections.streams;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.stream.Collectors;

public class OddEvenSeperators {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List<Integer> listOfIntegers = Arrays.asList(71, 18, 42, 21, 67, 32, 95, 14, 56, 87);
		Map<Boolean, List<Integer>> oddEvenNumMap = listOfIntegers.stream().collect(Collectors.partitioningBy(i-> i%2 == 0));
		Set<Entry<Boolean, List<Integer>>> entrSet = oddEvenNumMap.entrySet();
		
		for(Entry<Boolean, List<Integer>> entry : entrSet) {
			System.out.println("-----------------");
			if(entry.getKey()) {
				System.out.println("Even Numbers.");
			} else {
				System.out.println("Odd Numbers.");
			}
			System.out.println("------------------");
			
			List<Integer> list = entry.getValue();
			
			for(int i: list) {
				System.out.println(i);
			}

		}
	}

}
