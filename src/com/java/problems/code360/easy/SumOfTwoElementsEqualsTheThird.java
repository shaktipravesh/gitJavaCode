package com.java.problems.code360.easy;

import java.util.ArrayList;
import java.util.Arrays;

public class SumOfTwoElementsEqualsTheThird {
    public static ArrayList<Integer> findTriplets(int[] arr, int n)
    {
        ArrayList<Integer> triplets = new ArrayList<>();
        Arrays.sort(arr);
        for(int k = n-1; k >= 0; k--) {
            int target = arr[k];
            int left = 0;
            int right = k - 1;
            while(left < right) {
                int sum = arr[left] + arr[right];
                if(sum == target) {
                    triplets.add(arr[k]);
                    triplets.add(arr[right]);
                    triplets.add(arr[left]);
                    return triplets;
                } else if(sum > target) {
                    right--;
                } else {
                    left++;
                }
            }
        }
        return triplets;
    }
}
