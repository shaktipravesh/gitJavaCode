package com.java.problems.leetcode.easy;

public class MaximumNumberOfWordsCanType1935 {
    public int canBeTypedWords(String text, String brokenLetters) {
        int brokenLetter = 0;
        for (int i = 0; i < brokenLetters.length(); i++) {
            brokenLetter |= 1 << (brokenLetters.charAt(i) - 'a');
        }
        String[] words = text.split(" ");
        int canTypeWords = words.length;
        for (int i = 0; i < words.length; i++) {
            String word = words[i];
            for (int j = 0; j < word.length(); j++) {
                if((1 << (word.charAt(j) - 'a') & brokenLetter) > 0) {
                    canTypeWords--;
                    break;
                }
            }
        }
        return canTypeWords;
    }
}
