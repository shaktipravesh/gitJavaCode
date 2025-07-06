package com.java.problems.code360.hard;

import java.util.Scanner;

public class MaximumNumberInKSwaps {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int iTCs = sc.nextInt();
        for (int i = 0; i < iTCs; i++) {
            String m = sc.next();
            int k = sc.nextInt();
            System.out.println(findMax(m, k));
        }

    }
    public static String findMax(String m, int k) {
        char[] input = m.toCharArray();
        for(int i = 0; k > 0 && i < input.length;) {
            int maxDigit = Integer.MIN_VALUE;
            int index = -1;
            for(int j = input.length-1; j >= i; j--) {
                if(maxDigit < input[j]) {
                    maxDigit = input[j];
                    index = j;
                }
            }
            if(index == i || maxDigit == input[i]) {
                i++;
            } else {
                while(i < input.length && input[i] >= maxDigit) {
                    i++;
                }
                if(i < input.length && maxDigit > input[i]) {
                    int iNum = input[i];
                    input[i] = (char) maxDigit;
                    input[index] = (char) iNum;
                    k--;
                    i++;
                }
            }
        }
        return new String(input);
    }
}
