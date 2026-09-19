package com.java.problems.leetcode.easy;

import java.util.ArrayList;

public class GCDOfOddAndEvenSums3658 {
    public static void main(String[] args) {
        GCDOfOddAndEvenSums3658 gcd = new GCDOfOddAndEvenSums3658();
        int n = 4;
        System.out.println(gcd.gcdOfOddEvenSums(n));
    }
    ArrayList<Integer> gcd = new ArrayList<>();
    ArrayList<Integer> odd = new ArrayList<>();
    ArrayList<Integer> even = new ArrayList<>();
    int gcd(int a, int b) {
        return a % b == 0 ? b : gcd(b, a % b);
    }
    public int gcdOfOddEvenSums(int n) {
        if (n == 0) return 0;
//        if(n == 1) return 1;
        if(n > gcd.size()) {
            if(gcd.size() == 0) {
                odd.add(1);
                even.add(2);
                gcd.add(1);
            }
            int start = gcd.size();
            while (start <= gcd.size()) {
                odd.add(odd.getLast() + (start+1)*2-1);
                even.add(even.getLast() + (start+1)*2);
                gcd.add(gcd(odd.getLast(), even.getLast()));
            }
        }
        return gcd.get(n);
    }
}
