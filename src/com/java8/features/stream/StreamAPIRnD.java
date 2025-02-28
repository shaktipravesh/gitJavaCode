package com.java8.features.stream;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;

public class StreamAPIRnD {
    public static void main(String[] args) {
        flatMap();
        myMap();
    }

    private static void myMap() {
        List<String> names = Arrays.asList("John", "Alice", "Bob");

        List<Integer> map = names.stream().map(String::length).toList();
        System.out.println(map);
    }

    public static void  flatMap() {
        List<List<String>> namesList = Arrays.asList(
                Arrays.asList("John", "Alice"),
                Arrays.asList("Bob", "Charlie")
        );

        List<String> flatMap = namesList.stream().flatMap(Collection::stream).map(String::toUpperCase).toList();
        List<String> flatMap1 = namesList.stream().flatMap(a -> a.stream().map(String::toUpperCase)).toList();
        System.out.println(flatMap);
        System.out.println(flatMap1);
    }
}
