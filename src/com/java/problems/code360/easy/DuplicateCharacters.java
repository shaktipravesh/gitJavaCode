package com.java.problems.code360.easy;

import java.util.ArrayList;

public class DuplicateCharacters {
    static class Pair{
        char alphabet;
        int count;
        Pair(char ch, int x){
            this.alphabet = ch;
            this.count = x;
        }
    }

    public static ArrayList<Pair> duplicate_char(String s, int n) {
        ArrayList<Pair> pairs = new ArrayList<Pair>();
        int[] counts = new int[26];
        char[] chars = s.toCharArray();
        for(int i = 0; i < n; i++){
            counts[chars[i] - 'a']++;
        }
        for(int i = 0; i < 26; i++){
            if(counts[i] > 1){
                pairs.add(new Pair((char) (i+'a'), counts[i]));
            }
        }
        return pairs;
    }
}
