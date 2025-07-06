package com.java.problems.leetcode.contest;

import java.util.Iterator;
import java.util.Map;
import java.util.TreeMap;

import static java.lang.System.*;

public class weeklyContest445 {
    public static void main(String[] args) {
        weeklyContest445 weeklyContest445 = new weeklyContest445();
        String s = "addccab";
        String smallestPalindrome = weeklyContest445.smallestPalindrome(s);
        out.println(smallestPalindrome);
        String kS = "clwqhkonwyeeywnokhqwlc";
        String kthSmallestPalindrome = weeklyContest445.smallestKthPalindrome(kS, 528377);
        out.println(kthSmallestPalindrome);
    }
    public int findClosest(int x, int y, int z) {
        int distance1 = Math.max(x, z) - Math.min(x, z);
        int distance2 = Math.max(y, z) - Math.min(y, z);
        if(distance1 > distance2){
            return 2;
        } else if(distance1 < distance2){
            return 1;
        } else {
            return 0;
        }
    }

    int count = 0;
    String result = "";
    public String smallestPalindrome(String s) {
        StringBuilder sbFirst = new StringBuilder();
        StringBuilder smallestPalindrome = new StringBuilder();
        TreeMap<Character, Integer> charCount = new TreeMap<>();
        int size = s.length();
        for (int i = 0; i < size; i++) {
            charCount.put(s.charAt(i), charCount.getOrDefault(s.charAt(i), 0) + 1);
        }
        Character centerChar = null;
        for(Map.Entry<Character, Integer> entry : charCount.entrySet()){
            if(entry.getValue() % 2 == 1){
                centerChar = entry.getKey();
                charCount.put(centerChar, charCount.getOrDefault(centerChar, 0) - 1);
                if(charCount.get(centerChar) == 0){
                    charCount.remove(centerChar);
                }
                break;
            }
        }
        for(Map.Entry<Character, Integer> entry : charCount.entrySet()){
            int count = entry.getValue();
            for(int i = 0; i < count; i = i + 2){
                sbFirst.append(entry.getKey());
            }
        }
        smallestPalindrome.append(sbFirst);
        if(centerChar != null){
            smallestPalindrome.append(centerChar);
        }
        smallestPalindrome.append(sbFirst.reverse());
        
        return smallestPalindrome.toString();
    }

    public String smallestKthPalindrome(String s, int k) {
        StringBuilder sbFirst = new StringBuilder();
        StringBuilder sbSecond = new StringBuilder();
        StringBuilder kthPalindrome = new StringBuilder();
        TreeMap<Character, Integer> charCount = new TreeMap<>();
        int size = s.length();
        for (int i = 0; i < size; i++) {
            charCount.put(s.charAt(i), charCount.getOrDefault(s.charAt(i), 0) + 1);
        }
        Character centerChar = null;
        for(Map.Entry<Character, Integer> entry : charCount.entrySet()){
            if(entry.getValue() % 2 == 1){
                centerChar = entry.getKey();
                charCount.put(centerChar, charCount.getOrDefault(centerChar, 0) - 1);
                if(charCount.get(centerChar) == 0){
                    charCount.remove(centerChar);
                }
                break;
            }
        }
        for(Map.Entry<Character, Integer> entry : charCount.entrySet()){
            int count = entry.getValue();
            for(int i = 0; i < count; i = i + 2){
                sbFirst.append(entry.getKey());
            }
        }
        getNthPermutation(sbFirst.toString(), k);

        kthPalindrome.append(result);
        sbSecond.append(result);
        if(centerChar != null){
            if((sbFirst.length()<= 0 && k == 1) || (result.length() > 0))
            kthPalindrome.append(centerChar);
        }
        kthPalindrome.append(sbSecond.reverse());
        return kthPalindrome.toString();
    }

    public String getNthPermutation(String s, int n) {
        Map<Character, Integer> freq = new TreeMap<>();
        for (char c : s.toCharArray()) {
            freq.put(c, freq.getOrDefault(c, 0) + 1);
        }

        backtrack(freq, new StringBuilder(), s.length(), n);
        return result;
    }

    private boolean backtrack(Map<Character, Integer> freq, StringBuilder path, int totalLength, int n) {
        if (path.length() == totalLength) {
            count++;
            if (count == n) {
                result = path.toString();
                return true;
            }
            return false;
        }

        for (Iterator<Character> iterator = freq.keySet().iterator(); iterator.hasNext(); ) {
            char c = iterator.next();
            if (freq.get(c) == 0) continue;

            freq.put(c, freq.get(c) - 1);
            path.append(c);

            if (backtrack(freq, path, totalLength, n)) return true;

            path.deleteCharAt(path.length() - 1);
            freq.put(c, freq.get(c) + 1);
        }
        return false;
    }

}
