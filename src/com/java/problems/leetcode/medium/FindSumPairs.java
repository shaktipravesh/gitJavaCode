package com.java.problems.leetcode.medium;

import java.util.Map;
import java.util.TreeMap;

//FindingPairsWithACertainSum1865.java
public class FindSumPairs {
    TreeMap<Integer, Integer> numMap1 = new TreeMap<>();
    TreeMap<Integer, Integer> numMap2 = new TreeMap<>();
    int[] num1;
    int[] num2;
    public FindSumPairs(int[] nums1, int[] nums2) {
        this.num1 = new int[nums1.length];
        this.num2 = new int[nums2.length];
        for (int j = 0; j < nums1.length; j++) {
            this.num1[j] = nums1[j];
            numMap1.put(num1[j], numMap1.getOrDefault(nums1[j], 0) + 1);
        }
        for (int i = 0; i < nums2.length; i++) {
            this.num2[i] = nums2[i];
            numMap2.put(nums2[i], numMap2.getOrDefault(nums2[i], 0) + 1);
        }
    }

    public void add(int index, int val) {
        int oldKey = this.num2[index];
        int newKey = this.num2[index] + val;
        if(numMap2.containsKey(oldKey) && numMap2.get(oldKey) > 1) {
            numMap2.put(oldKey, numMap2.get(oldKey) - 1);
        } else {
            numMap2.remove(oldKey);
        }
        numMap2.put(newKey, numMap2.getOrDefault(newKey, 0) + 1);
        num2[index] = newKey;
    }

    public int count(int tot) {
        int pairCount = 0;
        for(Map.Entry<Integer, Integer> entry : numMap1.entrySet()) {
            int key = entry.getKey();
            if(numMap2.containsKey(tot - key)) {
                pairCount += numMap2.get(tot - key) * entry.getValue();
            }
        }
        return pairCount;
    }

    public static void main(String[] args) {
        int[] num1 = {9,70,14,9,76};
        int[] num2 = {26,26,58,23,74,68,68,78,58,26};
        FindSumPairs findSumPairs = new FindSumPairs(num1, num2);
        findSumPairs.add(6,10);
        findSumPairs.add(5,6);
        findSumPairs.count(32);
        findSumPairs.add(3,55);
        findSumPairs.add(9,32);
        findSumPairs.add(9,16);
        findSumPairs.add(1,48);
        findSumPairs.add(1,4);
        findSumPairs.add(0,52);
        findSumPairs.add(8,20);
        findSumPairs.add(9,4);
        findSumPairs.count(88);
        findSumPairs.count(154);
    }
}
