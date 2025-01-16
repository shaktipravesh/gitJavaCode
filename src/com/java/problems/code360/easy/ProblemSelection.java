package com.java.problems.code360.easy;

import java.util.Arrays;

public class ProblemSelection {
    //https://www.naukri.com/code360/problems/problem-selection_2824965?kunjiRedirection=true
    public static void main(String[] args) {
        int[] arr = {3, 2, 1, 4, 5};
        System.out.println(Arrays.toString(problemSelection(arr, 4)));

    }

    public static long[] problemSelection(int[] A, int K) {
        long[] result = new long[2];
        Arrays.sort(A);
        //max mark
        for(int start = 0, end = A.length; start < end; start++, end -=K) {
            result[0] += A[start];
        }
        //min mark
        for(int start = 0, end = A.length-1; start <= end; end--, start+=K) {
            result[1] += A[end];
        }
        return result;
    }
}
