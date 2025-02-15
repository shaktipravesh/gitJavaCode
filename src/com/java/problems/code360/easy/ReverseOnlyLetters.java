package com.java.problems.code360.easy;

public class ReverseOnlyLetters {
    public static void main(String[] args) {
        //2
        //a-bC-dEf-ghIj
        //Qedo1ct-eeLg=ntse-T!
        System.out.println(reverseOnlyLetters("a--bcd!"));
    }

    public static String reverseOnlyLetters1(String s) {
        char[] reversed = s.toCharArray();
        int start = 0;
        int end = reversed.length - 1;
        while (start < end) {
            while (start < end && !Character.isAlphabetic(reversed[start])) {
                start++;
            }
            while (start < end && !Character.isAlphabetic(reversed[end])) {
                end--;
            }
            char temp = reversed[start];
            reversed[start] = reversed[end];
            reversed[end] = temp;
            start++;
            end--;
        }
        return new String(reversed);
    }
    public static String reverseOnlyLetters(String s) {
        char[] input = s.toCharArray();
        int start = 0;
        int end = s.length();
        while(start < end) {
            while(start < end && !Character.isAlphabetic(input[start])) {
                start++;
            }
            while(start < end && !Character.isAlphabetic(input[end])) {
                end--;
            }
            if(Character.isAlphabetic(input[start]) && Character.isAlphabetic(input[end])) {
                char temp = input[start];
                input[start] = input[end] ;
                input[end] = temp;
                start++;
                end--;
            }
        }
        return input.toString();
    }
}
