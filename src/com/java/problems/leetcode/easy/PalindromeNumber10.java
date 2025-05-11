package com.java.problems.leetcode.easy;

public class PalindromeNumber10 {
    public boolean isPalindrome(int x) {
        boolean isPalindrome = true;
        if(x<0)
            return false;
        StringBuilder inPutString = new StringBuilder();
        while (x > 0) {
            inPutString.append(x%10);
            x = x/10;
        }
        char[] inputChar = inPutString.toString().toCharArray();
        for(int i = 0, j = inPutString.length()-1; i<j;  i++, j--) {
            if(inputChar[i] != inputChar[i]) {
                isPalindrome = false;
                break;
            }

        }
        return isPalindrome;
    }
}
