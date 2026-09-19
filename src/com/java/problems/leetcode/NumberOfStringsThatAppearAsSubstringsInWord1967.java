package com.java.problems.leetcode;

import java.util.HashSet;

public class NumberOfStringsThatAppearAsSubstringsInWord1967 {
    public static void main(String[] args) {
        NumberOfStringsThatAppearAsSubstringsInWord1967 obj = new NumberOfStringsThatAppearAsSubstringsInWord1967();
        String[] patterns = {"a","abc","bc","d"};
        String word = "abc";
        System.out.println(obj.numOfStrings(patterns, word));
    }
    public int numOfStrings(String[] patterns, String word) {
        HashSet<String> substringsSt = new HashSet<>();
        int subStringCount = 0;
        substringsSt.add(word);
        for(int i = 1; i< word.length(); i++) {
            for(int j = 0; (j + i) <= word.length(); j++) {
                substringsSt.add(word.substring(j, j + i));
            }
        }
        for(String pattern : patterns) {
            if(substringsSt.contains(pattern)) {
                subStringCount++;
            }
        }
        return subStringCount;
    }
}
