package com.java.problems.leetcode.easy;

import java.util.HashMap;
public class IsomorphicStrings205 {
    public static void main(String[] args) {
        IsomorphicStrings205 iso = new IsomorphicStrings205();

        String s = "bbbaaaba";
        String t = "aaabbbba";
        System.out.println(iso.isIsomorphic(s, t));
    }
    public boolean isIsomorphic(String s, String t) {
        if(s.length() != t.length()) {
            return false;
        }

        HashMap<Character, Character> stMap = new HashMap<>();
        HashMap<Character, Character> tsMap = new HashMap<>();

        for(int i = 0; i < s.length(); i++) {
            char sChar = s.charAt(i);
            char tChar = t.charAt(i);
            if(stMap.containsKey(sChar)) {
                if(stMap.get(sChar) != tChar) {
                    return false;
                }
            } else {
                stMap.put(sChar, tChar);
            }
            if(tsMap.containsKey(tChar)) {
                if(tsMap.get(tChar) != sChar) {
                    return false;
                }
            } else {
                tsMap.put(tChar, sChar);
            }
        }
        return true;
    }
}
