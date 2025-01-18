package com.java.problems.code360.hard;

import java.util.HashSet;
import java.util.Set;

public class DoubleStrings {
    public static void main(String[] args) {
        System.out.println(findDoubleStrings("abcarcar"));
        System.out.println(findDoubleStrings("abbasdasda"));
    }

    private static boolean isDoubleString(String str) {
        System.out.println(str);
        int mid = str.length() / 2;
        for (int i = 0; i < mid; i++) {
            if (str.charAt(i) != str.charAt(i + mid)) {
                return false;
            }
        }
        return true;
    }

    // Method to find the number of distinct double strings in a given string
    public static int findDoubleStrings(String str) {
        Set<String> allDistinctStrings = new HashSet<>();
        int strlen = str.length();

        for (int i = 0; i < strlen - 1; i++) {
            for (int len = 2; len <= strlen - i; len += 2) {
                String substring = str.substring(i, i + len);
                if (isDoubleString(substring)) {
                    allDistinctStrings.add(substring);
                }
            }
        }

        return allDistinctStrings.size();
    }
}
