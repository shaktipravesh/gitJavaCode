package com.java.problems.leetcode.medium;

import java.util.ArrayList;
import java.util.List;

public class Triangle120 {
    public static void main(String[] args) {
        //[[2],[3,4],[6,5,7],[4,1,8,3]]
        List<List<Integer>> triangle = new ArrayList<>();
        triangle.add(new ArrayList<>(List.of(2)));
        triangle.add(new ArrayList<>(List.of(3, 4)));
        triangle.add(new ArrayList<>(List.of(6, 5, 7)));
        triangle.add(new ArrayList<>(List.of(4, 1, 8, 3)));
        System.out.println(minimumTotal(triangle));


    }
    public static int minimumTotal(List<List<Integer>> triangle) {
        List<Integer> lastRow = triangle.getLast();
        List<Integer> minValues = new ArrayList<>(lastRow);
        for (int i = triangle.size() -2; i >= 0; i--) {
            List<Integer> row = triangle.get(i);
            for(int j = 0; j < row.size(); j++){
                minValues.set(j,  Math.min(minValues.get(j), minValues.get(j+1)) + row.get(j));
            }
        }
        return minValues.getFirst();
    }
}
