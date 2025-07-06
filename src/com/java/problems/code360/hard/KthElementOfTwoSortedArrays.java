package com.java.problems.code360.hard;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Scanner;

public class KthElementOfTwoSortedArrays {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        ArrayList<Integer> arr1 = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            arr1.add(sc.nextInt());
        }
        int m = sc.nextInt();
        ArrayList<Integer> arr2 = new ArrayList<>();
        for (int i = 0; i < m; i++) {
            arr2.add(sc.nextInt());
        }
        int k = sc.nextInt();
        ArrayList<Integer> arrMerge = new ArrayList<>();
        arrMerge.addAll(arr1);
        arrMerge.addAll(arr2);
        arrMerge.sort(Comparator.comparing(Integer::intValue));
        kthElement(arr1, arr2, n, m, k);
    }
    public static int kthElement(ArrayList<Integer> arr1, ArrayList<Integer> arr2, int n, int m, int k) {
        if( arr1.size() > arr2.size() ) {
            return kthElement(arr2, arr1, m, n, k);
        }
        int l = 0;
        int r = n-1;
        int kthElement = 0;
        while(true) {
            int iArr1 = (l+r)/2;
            int iArr2 = k - iArr1 - 2;

            int arr1Left = iArr1 >= 0 ? arr1.get(iArr1) : Integer.MIN_VALUE;
            int arr1Right = (iArr1 +1) < arr1.size() ? arr1.get(iArr1 +1) : Integer.MAX_VALUE;
            int arr2Left = iArr2 >= 0 ? arr2.get(iArr2) : Integer.MIN_VALUE;
            int arr2Right = (iArr2 +1) < arr2.size() ? arr2.get(iArr2 + 1) : Integer.MAX_VALUE;
            if(arr1Left <= arr2Right && arr2Left <= arr1Right) {
                kthElement = Math.max(arr1Left, arr2Left);
                break;
            } else if(arr1Left > arr2Right){
                r = iArr1 - 1;
            } else {
                l = iArr1 + 1;
            }

        }
        return kthElement;
    }
}
