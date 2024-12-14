package com.java.problems.code360;

import java.util.Scanner;

public class DynamicProgrammingSubsequencesAndGrid {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int iTCs = sc.nextInt();
        for (int i = 0; i < iTCs; i++) {
            int n = sc.nextInt();
            int k = sc.nextInt();
            int[] arr = new int[n];
            for (int j = 0; j < n; j++) {
                arr[j] = sc.nextInt();
            }
            System.out.println(subsetSumToK(n, k, arr));
        }
    }

    public static boolean subsetSumToK(int n, int k, int[] arr){
        boolean isSubsetSumToK = false;
        boolean[] sumArray = new boolean[k+1];
        sumArray[0] = true;
        for(int i = 0; i < n && !isSubsetSumToK; i++) {
            if(arr[i] <= k) {
                for(int j = k; j >=arr[i]; j--) {
                    if(sumArray[j-arr[i]]) {
                        sumArray[j] = true;
                    }
                    if(sumArray[k]) {
                        isSubsetSumToK = true;
                        break;
                    }
                }
            }
        }
        return isSubsetSumToK;
    }

    public static boolean canPartition(int[] arr, int n) {
        boolean isPartitioned;
        int sum = 0;
        for(int i = 0; i < n; i++) {
            sum += arr[i];
        }
        if(sum % 2 != 0) {
            return false;
        }
        int k = sum / 2;
        isPartitioned = subsetSumToK(n, k, arr);
        return isPartitioned;
    }

    public static int findWays(int[] num, int tar) {
        int[] sumArray = new int[tar+1];
        sumArray[0] = 1;
        for (int k : num) {
            for (int j = tar; j >= k; j--) {
                sumArray[j] = sumArray[j] + sumArray[j - k];
            }
        }
        return sumArray[tar];
    }
}
