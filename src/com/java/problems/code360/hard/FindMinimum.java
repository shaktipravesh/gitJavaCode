package com.java.problems.code360.hard;

public class FindMinimum {
    public static void main(String[] args) {
        int[] a = {7, 2, 6, 1, 5, 2};
        //int[] a = {7, 2};
        int n = 2;
        int m = 8;
        int min = findMinimum(n, m, a);
        System.out.println(min);
    }

    static int findMinimum(int n, int m, int[] a) {
        int l = -1, r = m;
        while (l < r - 1) {
            int mid = (l + r) / 2;
            if (good(mid, m, n, a)) {
                l = mid;
            } else {
                r = mid;
            }
        }
        return r;
    }
    static boolean good(int mid, int m, int n, int[] a) {
        int prev = 0;
        System.out.println("mid: " + mid );
        System.out.println("prev >= lf && prev <= rf) || ((prev + m) >= lf && (prev + m) <= rf)");
        for (int i = 0; i < n; i++) {
            int lf = a[i];
            int rf = a[i] + mid;
            System.out.println(prev +" >= "+ lf + " && " + prev + " =< " + rf + " ) || (( " + prev + " + " + m + ") >= " + lf + " && (" + prev + " + "+ m + ") <= " + rf +")");
            if ((prev >= lf && prev <= rf) || ((prev + m) >= lf && (prev + m) <= rf)) {
                continue;
            }
            if (lf < prev) {
                return true;
            }
            prev = lf;
        }
        return false;
    }
}
