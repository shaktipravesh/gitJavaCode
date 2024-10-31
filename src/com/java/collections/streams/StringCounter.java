package com.java.collections.streams;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class StringCounter {

	public static void main(String[] args) {
		String strInput = "aaaddsssaaadddrrr";
		int counter = 1;
		String outPut = new String();
		char previousChar = strInput.charAt(0);
		for(int i = 1; i < strInput.length(); i++) {
			if(previousChar == strInput.charAt(i) ) {
				counter++;
			} else {
				outPut = outPut + previousChar + counter;
				previousChar = strInput.charAt(i);
				counter = 1;
			}
		}
		outPut = outPut + previousChar + counter;
		System.out.println(outPut);
		
		
		//Input: {2, 4, 6, 8, 2, 10, 4, 12, 6}; -> If divisble by three the =n square else same number
		//Output: [2,4,36,8,2,10,4,144,36]
		
		Integer[] intArray = {2, 4, 6, 8, 2, 10, 4, 12, 6};
		IntStream stream = IntStream.of(2, 4, 6, 8, 2, 10, 4, 12, 6); 
		
		List<Integer> numbers = Arrays.asList(2, 4, 6, 8, 2, 10, 4, 12, 6);

        List<Integer> processedNumbers = numbers.stream()
            .map(n -> n % 3 == 0 ? n * n : n) // if-else logic in lambda
            .collect(Collectors.toList());

        System.out.println(processedNumbers); // Output: [2, 4, 4, 8, 6, 12]
		//stream.forEach(value -> value % 3 == 0?value*value:value)
		
        // Using IntStream.forEach 
        stream.forEach(value -> {
            if (value % 3 == 0) {
                System.out.print(value*value + " ");
     
            } else {
            	System.out.print(value + " ");
     
            }
        });
	}

	
//	User Managment: How many user are accessing the system: How many people are acessing the system If we are using for a office inverntory etc the lmited a simple service will be enough else we have to use multiple services. 
//	Inventory management : Categorization of the products to store the products: 
//		Here we need to have scalable system if some products are being explore more and some are less demanding:
//	OrderManagment: This is can be a single separate service assuming the exploring will be more and order will be limited
	
	
	
	//System Scalable Secure, Communication
}
