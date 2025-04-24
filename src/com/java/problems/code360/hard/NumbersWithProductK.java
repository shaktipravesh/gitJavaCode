package com.java.problems.code360.hard;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Map;

public class NumbersWithProductK {
    public static void main(String[] args) {
        System.out.println(numsWithProductK(1, 23, 6));

    }

    public static int numsWithProductK(int l, int r, int k) {
        int digitCountK = String.valueOf(r).length();
        int result = 0;
        ArrayList<Integer> numbers = new ArrayList<>();
        LinkedHashMap<Integer, Integer> numsProduct = new LinkedHashMap<>();
        for(int i = 1; i < 10; i++) {
            if(k%i ==0) {
                numbers.add(i);
                numsProduct.put(i, i);
                if(i == k && i >= l && i <=r) {
                    result++;
                }
            }
        }
        for(int i = 1; i < digitCountK; i++) {
            LinkedHashMap<Integer, Integer> numsProductNthDigit = new LinkedHashMap<>();
            for(Map.Entry<Integer, Integer> entry : numsProduct.entrySet()) {
                int key = entry.getKey();
                int value = entry.getValue();
                for(int j = 0; j < numbers.size(); j++) {
                    int digit = numbers.get(j);
                    int newKey = key*10 + digit;
                    int newValue = value*digit;
                    if(newValue > k || newKey > r) {
                        break;
                    }
                    if(newValue <= k || newKey <= r) {
                        numsProductNthDigit.put(newKey, newValue);
                    }
                    if(k == newValue && newKey >= l && newKey <=r) {
                        result++;
                    }
                }

            }
            numsProduct = numsProductNthDigit;
        }
        return result;
    }
}
