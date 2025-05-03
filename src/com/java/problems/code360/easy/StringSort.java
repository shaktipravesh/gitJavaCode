package com.java.problems.code360.easy;

import java.util.Arrays;

public class StringSort {
    public static String stringSort(String s) {
        char[] chars = s.toCharArray();
        Arrays.sort(chars);
        return new String(chars);
    }
}
