package com.java.problems.code360.medium;

public class MaximumDifferenceOfZerosAndOnesInABinaryString {
    public static void main(String[] args) {
        String input;
        input = "00111000011";
        System.out.println(maximumDifference(input));
        input = "11110110110111010";
        System.out.println(maximumDifference(input));
        input = "001101100110";
        System.out.println(maximumDifference(input));
        input = "111101111";
        System.out.println(maximumDifference(input));
        input = "10010001001";
        System.out.println(maximumDifference(input));
        input = "11";
        System.out.println(maximumDifference(input));
        input = "1100010001";
        System.out.println(maximumDifference(input));
        input = "1101";
        System.out.println(maximumDifference(input));
        input = "000000";
        System.out.println(maximumDifference(input));
        input = "0101010101";
        System.out.println(maximumDifference(input));
    }
    public static int maximumDifference(String str) {
        int maxDiff = Integer.MIN_VALUE;
        int currentSum = 0;

        for (char c : str.toCharArray()) {
            int val = (c == '0') ? 1 : -1;
            currentSum = Math.max(val, currentSum + val);
            maxDiff = Math.max(maxDiff, currentSum);
        }

        return maxDiff;
    }
}
