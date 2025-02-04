package com.java.problems.code360.easy;

import java.security.KeyStore;
import java.sql.SQLOutput;
import java.util.*;

public class SortElementsByFrequency {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int iTCs = in.nextInt();
        for (int iTC = 0; iTC < iTCs; iTC++) {
            int n = in.nextInt();
            int[] arr = new int[n];
            for (int arr_i = 0; arr_i < n; arr_i++) {
                arr[arr_i] = in.nextInt();
            }
            System.out.println(elementCount(arr));
            //System.out.println(sortByFrequency(arr));
        }
    }
    public static int[] sortByFrequency(int[] nums) {
        int[] sorted = new int[nums.length];
        Map<Integer, Integer> map = new LinkedHashMap<>();
        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
        }
        int[][] frequencies = new int[map.size()][2];
        int i = 0;
        for(Map.Entry<Integer, Integer> entry : map.entrySet()) {
            frequencies[i][0] = entry.getKey();
            frequencies[i][1] = entry.getValue();
            i++;
        }
        Arrays.sort(frequencies, (a,b) -> b[1] - a[1]);
        i = 0;
        for (int[] frequency : frequencies) {
            for (int k = 0; k < frequency[1]; k++) {
                sorted[i++] = frequency[0];
            }
        }

        return sorted;
    }

    public static int elementCount(int []A) {
        Map<Integer, Integer> map = new TreeMap<>();
        for (int j : A) {
            map.put(j, map.getOrDefault(j, 0) + 1);
        }
        int count = 0;
        ArrayList<Integer> list = new ArrayList<>(map.keySet());
        for(int i = 1; i < list.size(); i++) {
            if(list.get(i) == list.get(i - 1) + 1) {
                count += map.get(list.get(i-1));
            }
        }
        return count;
    }
}
