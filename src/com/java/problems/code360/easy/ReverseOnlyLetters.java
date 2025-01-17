package com.java.problems.code360.easy;

public class ReverseOnlyLetters {
    public static void main(String[] args) {
        //2
        //a-bC-dEf-ghIj
        //Qedo1ct-eeLg=ntse-T!
        System.out.println(reverseOnlyLetters("a--bcd!"));
    }

    public static String reverseOnlyLetters(String s) {
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
}
