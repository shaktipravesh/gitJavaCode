package com.java.problems.code360.medium;

public class MergeTwoSortedArrays {
    public static void main(String[] args) {
        int[] arr1 = {1, 2, 3};
        int[] arr2 = {4, 5};
        ninjaAndSortedArrays(arr1, arr2, 3, 2);
    }

    public static int[] ninjaAndSortedArrays(int arr1[], int arr2[], int m, int n) {
        int[] mergedArray = new int[m+n];
        int iMerged = 0, iM = 0, iN = 0;
        while(iM < m && iN < n) {
            if(arr1[iM] <= arr2[iN]) {
                mergedArray[iMerged++] = arr1[iM++];
            } else {
                mergedArray[iMerged++] = arr2[iN++];
            }
        }
        while(iM < m) {
            mergedArray[iMerged++] = arr1[iM++];
        }
        while(iN < n) {
            mergedArray[iMerged++] = arr2[iN++];
        }
        return mergedArray;
    }
}
