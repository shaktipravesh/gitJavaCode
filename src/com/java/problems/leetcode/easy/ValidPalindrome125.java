package com.java.problems.leetcode.easy;

public class ValidPalindrome125 {
    public static void main(String[] args) {
        String s1 = "race a car";
        ValidPalindrome125 vp = new ValidPalindrome125();
        System.out.println(vp.isPalindrome(s1));
    }
    public boolean isPalindrome(String s) {
        char[] sArray = s.toLowerCase().toCharArray();
        int start = 0, end = sArray.length - 1;
        while (start < end) {
            if(!Character.isAlphabetic(sArray[start]) && !Character.isDigit(sArray[start])) {
                start++;
            } else if(!Character.isAlphabetic(sArray[end]) && !Character.isDigit(sArray[end])) {
                end--;
            } else if(sArray[start] == sArray[end]) {
                start++;
                end--;
            }
            else {
                return false;
            }
        }
        return true;
    }
}
