package com.java.problems.code360;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class PrintDivisorList {
    public static void main(String[] args) {
        System.out.println(printDivisors(10));
    }

    public static List< Integer > printDivisors(int n) {
        List<Integer> divisorList = new ArrayList<>();
        int start = 1;
        int end;
        while(start*start <= n) {
            if(n%start == 0) {
                end = n/start;
                divisorList.add(start);
                if(start != end) {
                    divisorList.add(end);
                }
            }
            start++;
        }
        divisorList.sort(Comparator.comparing(Integer::intValue));
        return divisorList;
    }
}
