package com.java.problems.leetcode.contest;

import java.util.ArrayList;

import static java.lang.System.*;

public class weeklyContest448 {
    public static void main(String[] args) {
        int n = 31;
        weeklyContest448 w = new weeklyContest448();
        out.println(w.maxProduct(n));
    }
    public int maxProduct(int n) {
        ArrayList<Integer> list = new ArrayList<>();
        while (n > 0) {
            list.add(n % 10);
            n/=10;
        }
        list.sort(Integer::compareTo);
        return list.get(list.size() - 1)*list.get(list.size() - 2);
    }
}
