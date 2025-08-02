package com.java.problems.leetcode.easy;

import java.util.HashSet;

public class HappyNumber202 {
    public static void main(String[] args) {
        HappyNumber202 happyNumber202 = new HappyNumber202();
        int n = 2;
        System.out.println(happyNumber202.isHappy(n));
    }
    public boolean isHappy(int n) {
        HashSet<Integer> set = new HashSet<>();
        int num = n;
        set.add(num);
        int digitSquareSum = getDigitSquareSum(num);
        while (digitSquareSum != num && digitSquareSum != 1 && !set.contains(digitSquareSum)) {
            set.add(digitSquareSum);
            digitSquareSum = getDigitSquareSum(digitSquareSum);
        }
        return digitSquareSum == 1;

    }

    private int getDigitSquareSum(int num) {
        int sum = 0;
        while (num > 0) {
            sum += (num % 10)*(num % 10);
            num /= 10;
        }
        return sum;
    }
}
