package com.java.problems.leetcode.easy;

import java.util.HashMap;

public class ValidAnagram242 {
    public static void main(String[] args) {
        ValidAnagram242 v = new ValidAnagram242();

        String s = "anagram";
        String t = "nagaram";
        System.out.println(v.isAnagram(s, t));
    }
    public boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) return false;
        HashMap<Character, Integer> mapS = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            mapS.put(c, mapS.getOrDefault(c, 0) + 1);
        }
        for (int i = 0; i < t.length(); i++) {
            char c = t.charAt(i);
            if (mapS.containsKey(c)) {
                mapS.put(c, mapS.get(c) - 1);
                if (mapS.get(c) == 0) mapS.remove(c);
            }
            else return false;
        }
        if (mapS.size() == 0) return true;
        return false;

    }
}
