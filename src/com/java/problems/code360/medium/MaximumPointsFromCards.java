package com.java.problems.code360.medium;

import static java.lang.System.*;

public class MaximumPointsFromCards {
    public static void main(String[] args) {
        int[] arr = {39, 51, 68, 60, 64, 56, 26, 41, 46, 43, 29, 71, 48, 46, 42, 41};
        int[] arr01 = {9, 7, 5, 3, 2, 1, 8};
        out.println(maxPoints(arr01, 4));
        maxPoints(arr, 7);
    }
    public static int maxPoints(int []arr , int K){
        int maxPoint = 0;
        int sum = 0;
        int size = arr.length - 1;
        for(int i = 0; i < K; i++) {
            sum += arr[i];
        }
        maxPoint = sum;
        int i = K - 1, j = size;
        while (i >= 0) {
            sum = sum - arr[i] + arr[j];
            maxPoint = Math.max(maxPoint, sum);
            i--;
            j--;
        }
        out.println(maxPoint);
        return maxPoint;

    }
}
