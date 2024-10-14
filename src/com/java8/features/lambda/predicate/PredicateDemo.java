package com.java8.features.lambda.predicate;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;

public class PredicateDemo {

	public static void main(String[] args) {
		
		List<Integer> numbers = Arrays.asList(1, 2, 3 ,4, 5, 6, 7, 8, 9, 10);
		int sum = numbers.stream().filter(x -> x > 6).mapToInt(n->n).sum();
		System.out.println(sum);
		
		
		Predicate<Integer> isEvenPredicate = x -> x%3 ==0;
		
		
		
		Predicate<String> strStratsWithPredicate  = x-> x.toLowerCase().charAt(0) == 'p';
		CharSequence p = "p";
		Predicate<String> strContainsPredicate  = x-> x.toLowerCase().contains(p) == true;
		
		
		
		
		
		Predicate<Integer> predicate = x -> x > 2000;
		System.out.println(predicate.test(30));
		
		int salary = 100;

	}

}
