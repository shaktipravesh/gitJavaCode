package com.java.problems.leetcode.easy;

public class SmallestDivisibleDigitProductI {
    public static void main(String[] args) {
        SmallestDivisibleDigitProductI sd = new SmallestDivisibleDigitProductI();
        int n = 15;
        int t = 3;
        System.out.println(sd.smallestNumber(n, t));
    }
    public int smallestNumber(int n, int t) {
        int smallestNum = n;
        for (int start = n; start <= 100; start++) {
            int digitMultiply = getDigitMultiply(start);
            if(digitMultiply % t == 0){
                smallestNum = start;
                break;
            }
        }
        return smallestNum;
    }

    private int getDigitMultiply(int start) {
        int multiplier = 1;
        while (multiplier > 0 && start > 0) {
            multiplier *= start % 10;
            start /= 10;
        }
        return multiplier;
    }
}
