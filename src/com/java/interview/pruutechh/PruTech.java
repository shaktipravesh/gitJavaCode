package com.java.interview.pruutechh;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.TreeSet;

public class PruTech {
    static final int LIMIT = 20000;
    static final int MOD = 93179;
    static boolean isPrime[] = new boolean[LIMIT +1 ];
    static Long[] preFixProduct = new Long[LIMIT +1];

    public static List<Long> solve(int K, List<Long> L, List<Long> R) {
        List<Long> result = new ArrayList<>();
        Arrays.fill(isPrime, true);
        isPrime[0] = false;
        isPrime[1] = false;
        for (int i = 2; i*i < LIMIT; i++) {
            if (isPrime[i]) {
                for (int j = 2; j*i < LIMIT; j++) {
                    isPrime[i*j] = false;
                }
            }
        }
        preFixProduct[0] = 1L;
        for (int i = 1; i <= LIMIT; i++) {
            if(isPrime[i] && sumOfDigit(i) % K == 0) {
                preFixProduct[i] = (preFixProduct[i-1] * i) % MOD;
            } else {
                preFixProduct[i] = preFixProduct[i-1];
            }
        }

        return result;
    }

    private static int sumOfDigit(int i) {
        int sum = 0;
        while (i > 0) {
            sum += i % 10;
            i /= 10;
        }
        return sum;
    }

    public static void main(String[] args) {
        List<Long> L = new ArrayList<>(List.of(1L, 1L, 1L));
        List<Long> R = new ArrayList<>(List.of(4L, 5L, 14L));
        int K = 2;
        int Q = 3;
        List<Long> S = solve(K, L, R);

    }
}


class UniqueSortedList {
    public static List<Long> solution(List<Long> array) {
        TreeSet<Long> uniqueSortedSet = new TreeSet<>(array); // Removes duplicates & sorts
        return new ArrayList<>(uniqueSortedSet); // Convert back to List
    }

    public static void main(String[] args) {
        List<Long> input = Arrays.asList(1L, 2L, 1L, 3L, 4L);
        List<Long> result = solution(input);

        for (Long num : result) {
            System.out.println(num);
        }
    }
}