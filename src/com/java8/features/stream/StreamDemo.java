package com.java8.features.stream;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StreamDemo {

	public static void main(String[] args) {
		List<Integer> list = Arrays.asList(1, 4, 2, 6, 78, 55,2,12,867,231,123,67, 645, 42);
		System.out.println(list.stream().max((a, b)-> a-b));
		list = (List<Integer>) list.stream().sorted((a, b) -> (b-a)).toList();
		System.out.println(list);

		String str = "Shakti:Pravesh,Beena:Rathore";
		Map<String, String> map = Arrays.stream(str.split(",")).map(entry -> entry.split(":")).collect(Collectors.toMap(e -> e[0], e->e[1]));

	
		List<Integer> listNum = new ArrayList<>(List.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10));
		List<Integer> square = listNum.stream().map(n-> n*n).collect(Collectors.toList());
		System.out.println(square);

		int max = listNum.stream().max(Integer::compare).get();
		System.out.println(max);

		List<Integer> evenNum = listNum.stream().filter(n-> n%2==0).collect(Collectors.toList());
		System.out.println(evenNum);

		Map<Integer, Integer> mapEvenSquare = listNum.stream().collect(Collectors.toMap(n->n, n-> n%2 == 0? n*n : n));
		System.out.println(map);

		List<String> nameList = new ArrayList<>(List.of("Shakti", "Pravesh"));
		System.out.println(nameList.stream().map(st-> st.toUpperCase()).toList());

		System.out.println(listNum.stream().mapToInt(n->n).sum());

		String[] names = {"Shakti", "Pravesh", "Beena", "Rathore", "Suhasini", "Vincit"};


		List<Integer> listNums = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);

		List<Integer> squareNums = listNums.stream().map(n->n*n).collect(Collectors.toList());
		System.out.println(squareNums);

		createStream();

	}

	public static void createStream() {
		System.out.println("Create Stream");
		List<Integer> list = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
		Stream<Integer> stream = list.stream();

		int[] nums = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};

		//Stream<Integer> myStream = (Stream<Integer>) Arrays.stream(nums);

		Stream<Integer> direectStream = Stream.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
		direectStream.sorted((a,b) -> b-a).skip(2).limit(2).forEach(System.out::println);

		Stream<Integer> iterateStream = Stream.iterate(0, n -> n*n).limit(10);
		System.out.println(iterateStream.collect(Collectors.toList()));

		List<Integer> sqNum = Stream.iterate(0, n -> n+1).skip(1).limit(10).sorted().collect(Collectors.toList());
		System.out.println(sqNum);

		Stream<Integer> generateStream = Stream.generate(() -> (int) Math.random()).limit(10);

	}


}
