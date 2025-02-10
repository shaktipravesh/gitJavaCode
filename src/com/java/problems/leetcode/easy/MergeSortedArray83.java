package com.java.problems.leetcode.easy;

public class MergeSortedArray83 {
    public static void main(String[] args) {
        int[] nums1 = {1,2,3,0,0,0};
        int m = 3;
        int[] nums2 = {2,5,6};
        int n = 3;
        merge(nums1, m, nums2, n);
        System.out.println(nums1);
    }
    public static void merge(int[] nums1, int m, int[] nums2, int n) {
        int iN = n-1;
        int iM = m-1;
        for(int i = m+n-1; i >= 0; i--) {
            if(iM >= 0 &&iN >= 0) {
                if (nums1[iM] > nums2[iN]) {
                    nums1[i] = nums1[iM--];
                } else {
                    nums1[i] = nums2[iN--];
                }
            } else if (iN >= 0) {
                nums1[i] = nums2[iN--];
            }
        }
    }
}

