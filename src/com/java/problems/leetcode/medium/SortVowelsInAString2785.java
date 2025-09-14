package com.java.problems.leetcode.medium;

import java.util.*;

public class SortVowelsInAString2785 {
    public static void main(String[] args) {
        SortVowelsInAString2785 sol = new SortVowelsInAString2785();
        String s = "lEetcOde";
        System.out.println(sol.sortVowels(s));
    }
    public String sortVowels(String s) {
        HashSet<Character> vowels = new HashSet<>(List.of('a', 'e', 'i', 'o', 'u', 'A', 'E', 'I', 'O', 'U'));
        char[] chars = s.toCharArray();
        List<Character> vowelsChars = new ArrayList<>();
        for (char c : chars) {
            if (vowels.contains(c)) {
                vowelsChars.add(c);
            }
        }
        Collections.sort(vowelsChars);

        for (int i = 0, j = 0; i < chars.length && j < vowelsChars.size(); i++) {
            if( vowels.contains(chars[i])) {
                chars[i] = vowelsChars.get(j);
                j++;
            }
        }
        return new String(chars);
    }

    public boolean doesAliceWin(String s) {
        long vowelsCount = 0;
        Set<Character> vowels = Set.of('a', 'e', 'i', 'o', 'u', 'A', 'E', 'I', 'O', 'U');
        int size = s.length();
        int half = size / 2;
        for(int i = 0; i <= half; i++) {
            if(vowels.contains(s.charAt(i)) || vowels.contains(s.charAt(size - 1 - i))) {
                vowelsCount++;
                break;
            }
        }
        return vowelsCount > 0;
    }

    public int maxFreqSum(String s) {
        int[] frequency = new int[27];
        int vowel = 0;
        vowel = 1 << 'a'-'a' | 1 << 'e'-'a' | 1 << 'i'-'a' | 1 << 'o'-'a' |1 << 'u'-'a';
        int vowelMaxFreq = 0;
        int consonantmaxFreq = 0;
        for(int i =0; i < s.length(); i++) {
            frequency[s.charAt(i)-'a'+1]++;
        }
        for(int i =1; i < 27; i++) {
            if((vowel & i) > 0) {
                if(frequency[i] > vowelMaxFreq) {
                vowelMaxFreq = frequency[i];
                }
            } else {
                if(frequency[i] > consonantmaxFreq) {
                    consonantmaxFreq = frequency[i];
                }
            }
        }
        return consonantmaxFreq + vowelMaxFreq;
    }
}
