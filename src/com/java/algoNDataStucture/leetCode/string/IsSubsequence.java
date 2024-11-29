package com.java.algoNDataStucture.leetCode.string;

public class IsSubsequence {
    public static void main(String[] args) {
        System.out.println(isSubsequence("abcdefg", "abcdefg"));
        String s = "coaching", t = "coding";
        System.out.println(appendCharacters(s, t));
    }
    public static boolean isSubsequence(String s, String t) {
        boolean result = true;
        int i = 0, j = 0;
        for(; i < s.length(); i++, j++) {
            while( j < t.length() && s.charAt(i) != t.charAt(j)){
                j++;
            }
            if(j == t.length()) {
                result = false;
                break;
            }
        }
        return result;
    }

    public static int appendCharacters(String s, String t) {
        boolean isSubsequence = true;
        int result = 0;
        int i = 0, j = 0;
        for(; i < t.length(); i++, j++) {
            while( j < s.length() && t.charAt(i) != s.charAt(j)){
                j++;
            }
            if(j == s.length()) {
                isSubsequence = false;
                break;
            }
        }
        if(!isSubsequence) {
            result = t.length()-i;
        }
        return result;
    }
}
