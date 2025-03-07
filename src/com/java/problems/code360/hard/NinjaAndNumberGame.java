package com.java.problems.code360.hard;

import java.util.ArrayList;
import java.util.List;

public class NinjaAndNumberGame {

    public static void main(String[] args) {
        ArrayList<Integer> arr = new ArrayList<>(List.of(1, 2, 3, 4));
        System.out.println(numbers(arr));
    }

    public static int numbers(ArrayList<Integer> arr) {
        final int MOD = 1000000007;
        long multplcationOfNumbers = arr.getFirst();
        long result = 1;
        long gcd = arr.getFirst();
        for (int i = 1; i < arr.size(); i++) {
            multplcationOfNumbers = (multplcationOfNumbers * arr.get(i)) % MOD;
            gcd = getGCD(gcd, (long)arr.get(i));
        }

        while(gcd > 0) {
            result = (result * multplcationOfNumbers) % MOD;
            gcd--;
        }
        return (int)result;
    }

    private static long getGCD(long a, long b) {
        if (b == 0) {
            return a;
        }
        return getGCD(b, a % b);
    }
}
