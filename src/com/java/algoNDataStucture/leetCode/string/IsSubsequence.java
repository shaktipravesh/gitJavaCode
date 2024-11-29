package com.java.algoNDataStucture.leetCode.string;

public class IsSubsequence {
    public static void main(String[] args) {
        System.out.println(isSubsequence("abcdefg", "abcdefg"));
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
}
