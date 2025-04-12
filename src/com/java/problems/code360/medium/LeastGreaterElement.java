package com.java.problems.code360.medium;

import java.util.TreeSet;

public class LeastGreaterElement {
    public static void main(String[] args) {
        int[] arr = { 1, 4, 2, 6 };
        leastGreaterElement(arr);
    }
    public static int[] leastGreaterElement(int[] arr) {
        TreeSet<Integer> set = new TreeSet<>();
        for(int i = arr.length-1; i >= 0; i--){
            int num = arr[i];
            int nextGreater = -1;
            for(Integer entry : set) {
                if(entry > num) {
                    nextGreater = entry;
                    break;
                }
            }
            arr[i] = nextGreater;
            set.add(num);

        }
        return arr;
    }
}
