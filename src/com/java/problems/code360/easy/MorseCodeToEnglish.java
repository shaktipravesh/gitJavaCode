package com.java.problems.code360.easy;

import java.util.HashMap;
import java.util.HashSet;

public class MorseCodeToEnglish {
    public static void main(String[] args) {

    }
    public static String morseToEnglish(String morsecode) {
        HashMap<String, String> listMap = new HashMap<>();
        listMap.put(".-", "a");
        listMap.put("-...", "b");
        listMap.put("-.-.", "c");
        listMap.put("-..", "d");
        listMap.put(".", "e");
        listMap.put("..-.", "f");
        listMap.put("--.", "g");
        listMap.put("....", "h");
        listMap.put("..", "i");
        listMap.put(".---", "j");
        listMap.put("-.-", "k");
        listMap.put(".-..", "l");
        listMap.put("--", "m");
        listMap.put("-.", "n");
        listMap.put("---", "o");
        listMap.put(".--.", "p");
        listMap.put("--.-", "q");
        listMap.put(".-.", "r");
        listMap.put("...", "s");
        listMap.put("-", "t");
        listMap.put("..-", "u");
        listMap.put("...-", "v");
        listMap.put(".--", "w");
        listMap.put("-..-", "x");
        listMap.put("-.--", "y");
        listMap.put("--..", "z");
        listMap.put("-----", "0");
        listMap.put(".----", "1");
        listMap.put("..---", "2");
        listMap.put("...--", "3");
        listMap.put("....-", "4");
        listMap.put(".....", "5");
        listMap.put("-....", "6");
        listMap.put("--...", "7");
        listMap.put("---..", "8");
        listMap.put("----.", "9");

        StringBuilder result = new StringBuilder();
        String[] input = morsecode.split(" ");
        for (int i = 0; i < input.length; i++) {
            result.append(listMap.get(input[i]));
        }
        return new String(result.toString());
    }
}
