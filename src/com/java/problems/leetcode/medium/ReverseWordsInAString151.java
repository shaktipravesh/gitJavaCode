package com.java.problems.leetcode.medium;

public class ReverseWordsInAString151 {
    public static void main(String[] args) {
        String str = "a good   example";
        System.out.println(reverseWords(str));
    }

    public static String reverseWords(String s) {
        // Trim the input string to remove leading and trailing spaces
        s = s.trim();

        // Split the string by one or more spaces
        String[] words = s.split("\\s+");

        // Reverse the words array
        StringBuilder result = new StringBuilder();
        for (int i = words.length - 1; i >= 0; i--) {
            result.append(words[i]);
            if (i > 0) {
                result.append(" "); // Add a space between words
            }
        }

        return result.toString();
//
//        String[] wordArray = s.split(" ");
//        List<String> wordList = Arrays.asList(wordArray);
//        wordList= wordList.stream().filter(word -> word.trim().length() > 0).toList();
//        Collections.reverse(wordList);
//        System.out.println(wordList);
//        s= String.join(" ", wordList);
//        return s.trim();

    }

    public static String reverseWordsWithoutSplit(String s) {
        if (s == null) return null;

        char[] a = s.toCharArray();
        int n = a.length;

        // step 1. reverse the whole string
        reverse(a, 0, n - 1);
        // step 2. reverse each word
        reverseWords(a, n);
        // step 3. clean up spaces
        return cleanSpaces(a, n);
    }

    static void reverseWords(char[] a, int n) {
        int i = 0, j = 0;

        while (i < n) {
            while (i < j || i < n && a[i] == ' ') i++; // skip spaces
            while (j < i || j < n && a[j] != ' ') j++; // skip non spaces
            reverse(a, i, j - 1);                      // reverse the word
        }
    }

    // trim leading, trailing and multiple spaces
    static String  cleanSpaces(char[] a, int n) {
        int i = 0, j = 0;

        while (j < n) {
            while (j < n && a[j] == ' ') j++;             // skip spaces
            while (j < n && a[j] != ' ') a[i++] = a[j++]; // keep non spaces
            while (j < n && a[j] == ' ') j++;             // skip spaces
            if (j < n) a[i++] = ' ';                      // keep only one space
        }

        return new String(a).substring(0, i);
    }

    // reverse a[] from a[i] to a[j]
    private static void reverse(char[] a, int i, int j) {
        while (i < j) {
            char t = a[i];
            a[i++] = a[j];
            a[j--] = t;
        }
    }
}
