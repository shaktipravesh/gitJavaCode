package com.java.problems.leetcode.medium;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import static java.lang.System.*;

public class GroupAnagrams49 {
    public static void main(String[] args) {
        String[] stars = {"eat","tea","tan","ate","nat","bat"};
        GroupAnagrams49 ga = new GroupAnagrams49();
        out.println(ga.groupAnagrams(stars));
    }
    public List<List<String>> groupAnagrams(String[] stars) {
        Map<String, List<String>> groupedAnagrams = Arrays.stream(stars)
                .collect(Collectors.groupingBy(word -> {
                    char[] chars = word.toCharArray();
                    Arrays.sort(chars);
                    return new String(chars);
                }));

        return groupedAnagrams.values().stream()
                .filter(group -> group.size() > 1)
                .toList();
    }
}
