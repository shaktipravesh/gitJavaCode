package com.java.problems.leetcode.easy;

public class LengthofLastWord58 {
    public int lengthOfLastWord(String s) {
        String[] inputList = s.split(" ");
        return inputList[inputList.length - 1].length();
    }
}
