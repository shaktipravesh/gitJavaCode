package com.java.problems.leetcode.easy;

import java.util.HashMap;
import java.util.Map;

public class WordPattern290 {
    public static void main(String[] args) {

    }
    public boolean wordPattern(String pattern, String s) {
        Map<Character, String> mapPattern = new HashMap<>();
        Map<String, Character> mapWord = new HashMap<>();
        char[] patternChar = pattern.toCharArray();
        String[] words = s.split(" ");
        if(pattern.length() != words.length) {
            return false;
        }
        for (int i = 0; i < patternChar.length; i++) {
            char c = patternChar[i];
            String word = words[i];
            if(mapPattern.containsKey(c)) {
                if(!mapPattern.get(c).equals(word)) {
                    return false;
                }
            } else if(mapWord.containsKey(word)) {
                if(!mapWord.get(word).equals(c)) {
                    return false;
                }
            }else {
                mapPattern.put(c, word);
                mapWord.put(word, c);
            }
        }
        return true;
    }
}
