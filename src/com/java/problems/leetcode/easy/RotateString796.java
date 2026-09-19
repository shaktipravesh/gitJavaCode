package com.java.problems.leetcode.easy;

import java.util.LinkedHashMap;

public class RotateString796 {
    public static void main(String[] args) {
        learnMap();
//        RotateString796 r = new RotateString796();
//        String s = "abcde";
//        String goal = "cdeab";
//        System.out.println(r.rotateString(s, goal));
    }

    private static void learnMap() {
        LinkedHashMap<String, Integer> map = new LinkedHashMap<>(10, 0.75F, true);
        map.put("a", 1);
        map.put("b", 2);
        map.put("c", 3);
//        map.get("b");
        map.forEach((k, v) -> System.out.println(k + " : " + v));
    }

    public boolean rotateString(String source, String goal) {
        if(source == null || goal == null || source.isEmpty() || goal.isEmpty() || source.length() != goal.length()) {
            return false;
        }
        boolean isRotated = false;
        int len = goal.length();
        char[] charSource = source.toCharArray();
        char[] charsGoal = goal.toCharArray();
        for (int i = 0; i < len && !isRotated; i++) {
            if(charsGoal[i] == charSource[0]) {
                for (int j = 0; j < len && !isRotated; j++) {
                    if(charSource[j] != charsGoal[(j+i)%len]) {
                        break;
                    }
                    if (charSource[j] == charsGoal[(j + i) % len] && j == len - 1) {
                        isRotated = true;
                        break;
                    }
                }
            }
        }
        return isRotated;
    }
}

