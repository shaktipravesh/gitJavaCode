package com.java.problems.leetcode.hard;

import java.util.ArrayList;

public class Candy135 {
    public static void main(String[] args) {
        int[] ratings;
        ratings = new int[]{1,3,2,2,1};
        System.out.println(candy(ratings));
    }
    public static int candy(int[] ratings) {
        if(ratings == null || ratings.length == 0) return 0;
        if(ratings.length == 1) return 1;

        ArrayList<Integer> minima = new ArrayList<>();
        int[] chocolates = new int[ratings.length];
        int total = 0;
        for(int i = 0; i < ratings.length; i++) {
            if ((i == 0 && ratings[i] < ratings[i + 1])
                    || (i > 0 && i < ratings.length - 1 && ratings[i] <= ratings[i - 1] && ratings[i] <= ratings[i + 1])
                    || (i == ratings.length - 1 && ratings[i] < ratings[i - 1])) {
                minima.add(i);
            }
            chocolates[i] = 1;
        }
        for (int index : minima) {
            //left allocation
            if (index > 0) {
                for (int j = index - 1; j >= 0 && ratings[j] > ratings[j + 1]; j--) {
                    chocolates[j] = Math.max(chocolates[j], chocolates[j + 1] + 1);
                }
            }
            if (index < ratings.length - 1) {
                for (int j = index + 1; j < ratings.length && ratings[j] > ratings[j - 1]; j++) {
                    chocolates[j] = Math.max(chocolates[j], chocolates[j - 1] + 1);
                }
            }
        }
        for (int chocolate : chocolates) {
            total += chocolate;
        }
        return total;

    }
}
