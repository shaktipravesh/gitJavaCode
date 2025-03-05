package com.java8.features.stream.parallelstream;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.logging.Logger;
import java.util.stream.Collectors;

public class ParallelStreamExample {
    Logger logger = Logger.getLogger(ParallelStreamExample.class.getName());
    public static void main(String[] args) {
        ParallelStreamExample example = new ParallelStreamExample();
        example.parallelStreamForEach();
        example.parallelStreamMap();
    }

    public void parallelStreamForEach() {
        ArrayList<Integer> list = new ArrayList<>(List.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10));

        list.parallelStream().forEach(a-> logger.info(Thread.currentThread().getName() + " " + a));
    }

    public void parallelStreamMap() {
        ArrayList<Integer> list = new ArrayList<>(List.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10));

        List<Integer> listSquare = list.parallelStream().map(integer -> integer*integer).toList();
        logger.info(Thread.currentThread().getName() + " " + listSquare);
        Map<Integer, Integer> squareMap = list.parallelStream().collect(Collectors.toMap(integer -> integer, integer -> integer*integer));
        logger.info(squareMap.toString());


    }
}
