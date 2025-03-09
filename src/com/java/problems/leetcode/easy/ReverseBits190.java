package com.java.problems.leetcode.easy;

import static java.lang.System.*;

public class ReverseBits190 {
    public static void main(String[] args) {
        out.println(reverseBits(16));
    }
    public static int reverseBits(int n) {
        int input = n;
        int result = 0;
        for(int i = 0; i < 32; i++) {
            result = result << 1;
            result += input & 1;
            input = input >> 1;
        }
        return result;
    }
}
