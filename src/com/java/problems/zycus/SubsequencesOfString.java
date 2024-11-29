package com.java.problems.zycus;

import java.util.ArrayList;

public class SubsequencesOfString {
    public static void main(String[] args) {
        ArrayList<String> result = subsequences("bbb");
        System.out.println(result);
    }

    public static ArrayList<String> subsequences(String str) {
        ArrayList<String> result = new ArrayList<>();
        for (int i = 0; i < str.length(); i++) {
            int size = result.size();
            for (int index = 0; index < size; index++) {
                result.add(result.get(index)+str.charAt(i));
            }
            result.add(String.valueOf(str.charAt(i)));
        }
        return result;
    }


}
