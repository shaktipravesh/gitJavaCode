package com.java.problems.zycus;

import java.util.ArrayList;
import java.util.Arrays;

public class PowerSet {
    public static void main(String[] args) {
        ArrayList<Integer> arr = new ArrayList<>(Arrays.asList(1, 2, 3));
        System.out.println(pwset(arr));
    }

    public static ArrayList<ArrayList<Integer>> pwset(ArrayList<Integer> arr) {
        ArrayList<ArrayList<Integer>> powerSets = new ArrayList<>();
        powerSets.add(new ArrayList<>());
        for (Integer integer : arr) {
            int size = powerSets.size();
            for (int index = 0; index < size; index++) {
                ArrayList<Integer> powerSet = new ArrayList<>(powerSets.get(index));
                powerSet.add(integer);
                powerSets.add(powerSet);
            }
        }
        return powerSets;
    }
}
