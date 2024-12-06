package com.java.problems.leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class LetterCombinationsOfAPhoneNumber {
    public static void main(String[] args) {
        List<String> result = letterCombinations("23");
        System.out.println(result);
    }

    public static List<String> letterCombinations(String digits) {
        List<String> result = new ArrayList<>();
        HashMap<Integer, String> map = new HashMap<>();
        map.put(2, "abc");
        map.put(3, "def");
        map.put(4, "ghi");
        map.put(5, "jkl");
        map.put(6, "mno");
        map.put(7, "pqrs");
        map.put(8, "tuv");
        map.put(9, "wxyz");

        for(int i = 0; i < digits.length(); i++) {
            String str = map.get(digits.charAt(i)-'0');
            if(result.isEmpty()) {
                for(int j = 0; j < str.length(); j++) {
                    result.add(str.charAt(j) + "");
                }
            } else {
                List<String> resultTemp = new ArrayList<>();
                for (String s : result) {
                    for (int j = 0; j < str.length(); j++) {
                        resultTemp.add(s + str.charAt(j));
                    }
                }
                result = resultTemp;
            }
        }
        return result;
    }
}
