package com.java.problems.code360.easy;

import java.util.ArrayList;
import java.util.Collections;

public class FindNumbersContaining12And3 {
    public static ArrayList<Integer> containsNumber(int n, ArrayList<Integer> arr) {
        ArrayList<Integer> containsNumber = new ArrayList<>();
        for(Integer num : arr) {
            if(containsDigit(num)) {
                containsNumber.add(num);
            }
        }
        if(containsNumber.isEmpty()) {
            containsNumber.add(-1);
            return containsNumber;
        }
        Collections.sort(containsNumber);
        return containsNumber;
    }

    private static boolean containsDigit(Integer num) {
        String digits = String.valueOf(num);
        if(digits.contains("1") && digits.contains("2") && digits.contains("3")) {
            return true;
        }
        return false;
    }
}
