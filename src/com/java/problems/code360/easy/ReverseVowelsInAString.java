package com.java.problems.code360.easy;

import java.util.HashSet;
import java.util.List;

public class ReverseVowelsInAString {
    public static void main(String[] args) {
        System.out.println(reverseVowels("suhasini"));
    }
    public static String reverseVowels(String s){

        char[] arr = s.toCharArray();
        int start = 0;
        int end = s.length()-1;
        HashSet<Character> vowels = new HashSet<>(List.of('a', 'e', 'i', 'o', 'u'));
        while(start < end) {
            Character cStart = s.charAt(start);
            Character cEnd = s.charAt(end);
            if(vowels.contains(cEnd) && vowels.contains(cStart)) {
                char temp = arr[start];
                arr[start] = arr[end];
                arr[end] = temp;
                start++;
                end--;
            } else if(!vowels.contains(cStart)) {
                start++;
            } else if(!vowels.contains(cEnd)) {
                end--;
            }
        }
        return new String(arr);
    }
}
