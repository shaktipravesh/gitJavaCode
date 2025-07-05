package com.java.problems.leetcode.hard;

import java.util.ArrayList;

import static java.lang.System.*;

public class StringGameII3307 {
    public static void main(String[] args) {
        long k = 10;
        int[] operations = {0,1,0,1};
        StringGameII3307 game = new StringGameII3307();
        out.println(game.kthCharacter(k, operations));
    }

    public char kthCharacter(long k, int[] operations) {
        ArrayList<Long> powOfTwo = new ArrayList<>();
        char kThChar;
        long target = k;
        int increment = 0;
        powOfTwo.add(1L);
        while(powOfTwo.getLast() < k) {
            powOfTwo.add(powOfTwo.getLast()*2);
        }
        ArrayList<Integer> operationIndex = new ArrayList<>();
        for(int index = powOfTwo.size()-1; index > 0; index--) {
            if(powOfTwo.get(index) >= target && target > powOfTwo.get(index-1)) {
                operationIndex.add(index);
                target = target - powOfTwo.get(index-1);
            }
        }
        for(int i = 0; i < operationIndex.size(); i++) {
            increment += operations[operationIndex.get(i)-1];
        }
        kThChar = (char) ('a' + increment%26);
        return kThChar;
    }
}
