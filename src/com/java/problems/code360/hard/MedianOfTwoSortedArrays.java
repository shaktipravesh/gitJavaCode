package com.java.problems.code360.hard;

public class MedianOfTwoSortedArrays {
    public static void main(String[] args) {
        int[] a = {1, 2, 2};
        int[] b = {2, 4, 4};
        double median = median(a, b);
        System.out.println(median);
    }

    public static double median(int[] a, int[] b) {
        double median = 0;
        if(a.length > b.length) {
            median(b ,a);
        }
        int l = 0;
        int r = a.length - 1;
        int total = a.length + b.length;
        int preMedian = total/2;
        while(true) {
            int ia = (l + r)/2;
            int ib = preMedian - ia -2 ;
            int aLeft = ia >= 0? a[ia]: Integer.MIN_VALUE;
            int aRight = (ia+1) < a.length ? a[ia+1] : Integer.MAX_VALUE;
            int bLeft = ib >= 0? b[ib]: Integer.MIN_VALUE;
            int bRight = (ib + 1) < b.length ? b[ib+1] : Integer.MAX_VALUE;
            if(aLeft <= bRight && bLeft <= aRight) {
                if(total %2 != 0) {
                    median = Math.min(aRight, bRight);
                } else {
                    median = ((double)Math.max(aLeft, bLeft) + Math.min(aRight, bRight))/2;
                }
                break;
            } else if(aLeft > bRight) {
                r = ia -1;
            } else {
                l = ia+1;
            }
        }
        return median;
    }
}
