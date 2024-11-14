package com.java.problems;

import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class ReverseWordOfString {
    public static void main(String[] args) {
        String strInput = "Hello Shakti Pravesh";
        String[] wordArray = strInput.split(" ");
        List<String> wordList = Arrays.asList(wordArray);
        Collections.reverse(wordList);
        System.out.println(wordList);


    }
}
