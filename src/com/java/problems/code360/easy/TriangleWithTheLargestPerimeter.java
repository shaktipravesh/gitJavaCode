package com.java.problems.code360.easy;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class TriangleWithTheLargestPerimeter {
    public static void main(String[] args) {
        ArrayList<Integer> arr = new ArrayList<>(List.of(3, 7, 1, 5));
        int n = 4;
        System.out.println(maxPerimeterTriangle(arr, n));
    }

    public static int maxPerimeterTriangle(ArrayList<Integer> arr, int n) {
        int maxPerimeter = 0;
        Collections.sort(arr);
        for(int a = 0; a < n-2; a++ ) {
            if((arr.get(a) + arr.get(a+1)) > arr.get(a+2)) {
                maxPerimeter = Math.max(maxPerimeter, arr.get(a) + arr.get(a+1) + arr.get(a+2));
            }
        }
        return maxPerimeter;
    }
}


