package com.java.problems.zycus;

import java.util.Arrays;

public class MergeTwoSortedArraysWithoutExtraSpace {
    public static void main(String[] args) {
        long[] A = {1, 4, 5, 7};
        long[] B = {2, 3, 6};
        mergeTwoSortedArraysWithoutExtraSpace(A, B);
        System.out.println(Arrays.toString(A));
        System.out.println(Arrays.toString(B));
    }

    public static void mergeTwoSortedArraysWithoutExtraSpace(long []a, long []b){
        for(int i=0, j=0;i<a.length && j < b.length;){
            if(a[i]>b[j]){
                long temp = b[j];
                int k = j;
                while(k+1 < b.length && a[i]>b[k+1]){
                    b[k] = b[k+1];
                    k++;
                }
                b[k] = a[i];
                a[i] = temp;
                i++;
            } else {
                i++;
            }
        }
        System.out.println(Arrays.toString(a));
        System.out.println(Arrays.toString(b));
    }
}
