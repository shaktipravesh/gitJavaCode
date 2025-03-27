package com.java8.features.stream.parallelstream;

import java.util.*;
import java.util.logging.Logger;
import java.util.stream.Collectors;

import static java.lang.System.*;

public class ParallelStreamExample {
    Logger logger = Logger.getLogger(ParallelStreamExample.class.getName());
    public static void main(String[] args) {
        ParallelStreamExample example = new ParallelStreamExample();
        example.parallelStreamForEach();
        example.parallelStreamMap();
    }

    public void parallelStreamForEach() {
        ArrayList<Integer> list = new ArrayList<>(List.of(-10, -9, -8, -7, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10));

        //evenlist as true and odd as false
        Map<Boolean, List<Integer>> map = list.stream().collect(Collectors.partitioningBy(x -> x % 2 == 0));
        out.println(map);

        List<Integer> even = list.stream().filter(x -> x % 2 == 0).collect(Collectors.toList());
        out.println(even);

        //evenlist as "Even" and Odd as "Odd"
        Map<String, List<Integer>> mp = list.stream().collect(Collectors.groupingBy(x -> x % 2 == 0 ? "Even" : "Odd"));
        out.println(mp);

        //devide list as "PostiveEven" , "NegativeEven", "PostiveOdd" and "NegativeOdd"
        Map<String, List<Integer>> mapList = list.stream().collect(Collectors.groupingBy(x -> {
            return ((x % 2) == 0) ? x > 0 ? "PositiveEven" : "NegativeEven" : x > 0 ? "PositiveOdd" : "NegativeOdd";
        }));
        out.println(mapList);

        list.parallelStream().forEach(a-> logger.info(Thread.currentThread().getName() + " " + a));

        List<String> words = Arrays.asList("apple", "banana", "cherry", "date", "fig", "grape");

        // Grouping by length and counting occurrences in each group
        Map<Integer, Long> groupedByLength = words.stream()
                .collect(Collectors.groupingBy(String::length, Collectors.counting()));
        out.println(groupedByLength);

        Map<Integer, List<String>> groupStrByLength = words.stream().collect(Collectors.groupingBy(String::length));
        out.println(groupStrByLength);

        List<Employee> employees = Arrays.asList(
                new Employee("John", 50000),
                new Employee("Jane", 60000),
                new Employee("Mark", 55000),
                new Employee("Sophia", 75000),
                new Employee("Alex", 40000)
        );

        Employee employee = employees.stream().sorted(Comparator.comparingInt(Employee::getSalary)).toList().getLast();
        out.println(employee);
    }

    static class Employee {
        String name;
        int salary;
        public Employee(String name, int salary) {
            this.name = name;
            this.salary = salary;
        }

        public int getSalary() {
            return salary;
        }
    }
    public void parallelStreamMap() {
        ArrayList<Integer> list = new ArrayList<>(List.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10));

        List<Integer> listSquare = list.parallelStream().map(integer -> integer*integer).toList();
        logger.info(Thread.currentThread().getName() + " " + listSquare);
        Map<Integer, Integer> squareMap = list.parallelStream().collect(Collectors.toMap(integer -> integer, integer -> integer*integer));
        logger.info(squareMap.toString());


    }
}
