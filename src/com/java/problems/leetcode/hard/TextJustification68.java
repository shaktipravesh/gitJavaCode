package com.java.problems.leetcode.hard;

import java.util.ArrayList;
import java.util.List;

import static java.lang.System.*;

public class TextJustification68 {
    public static void main(String[] args) {
        String[] words = {"Science","is","what","we","understand","well","enough","to","explain","to","a","computer.","Art","is","everything","else","we","do"};
        int maxWidth = 20;
        List<String> result = fullJustify(words, maxWidth);
        out.println(result);

    }
    public static List<String> fullJustify(String[] words, int maxWidth) {
        List<String> result = new ArrayList<>();

        for (int i = 0; i < words.length;) {
            int maxLength = 0;
            int textLength = 0;
            int j = i;
            int start = i;
            int end = i;
            StringBuilder sb = new StringBuilder();
            for(; j < words.length && maxLength + words[j].length() <= maxWidth; j++) {
                maxLength = maxLength + words[j].length() + 1;
                textLength += words[j].length();
                end++;
            }
            int wordCt = end - start-1;
            int space = 0;
            int quotient = wordCt > 0 ? (maxWidth - textLength)/wordCt : 0;
            int remainder = wordCt > 0 ? (maxWidth - textLength) % wordCt : 0;
            while (start < end) {
                while(space > 0) {
                    sb.append(' ');
                    space--;
                }
                sb.append(words[start]);
                space = quotient;
                space += remainder > 0 ? 1 : 0;
                if(end == words.length) {
                    space = 1;
                }
                remainder--;
                start++;

            }
            while(sb.length() < maxWidth) {
                sb.append(' ');
            }
            i = end;
            result.add(sb.toString());
        }
        return result;
    }
}
