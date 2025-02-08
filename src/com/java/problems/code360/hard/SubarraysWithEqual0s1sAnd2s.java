package com.java.problems.code360.hard;

import java.util.HashMap;

public class SubarraysWithEqual0s1sAnd2s {
    public static int countSubarrays(int n, int[] arr) {
        if(n<0) {
            return 0;
        }
        int countSubarrays = 0;
        HashMap<String, Integer> map = new HashMap<>();
        int C0 = 0, C1 = 0, C2 = 0;
        String key = (C2-C1)+ "#" + (C1-C0);
        map.put(key, map.getOrDefault(key, 0) + 1);
        for(int i = 0; i < arr.length; i++) {
            if(arr[i] == 0) {
                C0++;
            }
            if(arr[i] == 1) {
                C1++;
            }
            if(arr[i] == 2) {
                C2++;
            }
            key = (C2-C1)+ "#" + (C1-C0);
            if(map.containsKey(key)) {
                countSubarrays += map.get(key);
            }
            map.put(key, map.getOrDefault(key, 0) + 1);

        }
        return countSubarrays;
    }
}
