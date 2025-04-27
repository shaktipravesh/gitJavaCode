package com.java.problems.code360.easy;

import java.util.ArrayList;

import static java.lang.System.*;

public class InterestingAlphabets {
    public static void main(String[] args) {
        int N = 5;
        out.println(interestingPattern(N));
    }
    public static ArrayList<ArrayList<Character>> interestingPattern(int N) {
        char[] chars = {'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z'};
        ArrayList<ArrayList<Character>> interestingPattern = new ArrayList<>();
        for (int i = N-1; i >= 0; i--) {
            ArrayList<Character> charPattern  = new ArrayList<>();
            for (int j = i; j < N; j++) {
                charPattern.add(chars[j]);
            }
            interestingPattern.add(charPattern);
        }
        return interestingPattern;
    }
}
