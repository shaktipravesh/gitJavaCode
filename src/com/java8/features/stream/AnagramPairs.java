package com.java8.features.stream;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import static java.lang.System.*;

public class AnagramPairs {
    public static void main(String[] args) {
        List<String> words = Arrays.asList("listen", "silent", "enlist", "rat", "tar", "god", "dog");

        Map<String, List<String>> groupedAnagrams = words.stream()
                .collect(Collectors.groupingBy(word -> {
                    char[] chars = word.toCharArray();
                    Arrays.sort(chars);
                    return new String(chars);
                }));

        out.println(groupedAnagrams.values().stream().toList());
        List<List<String>> anagramPairs = groupedAnagrams.values().stream()
                .filter(group -> group.size() > 1)
                .toList();

        out.println("Anagram Pairs: " + anagramPairs);
    }
}