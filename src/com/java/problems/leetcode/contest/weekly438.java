package com.java.problems.leetcode.contest;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class weekly438 {
    public static void main(String[] args) {
        //String s = "3902";
        //System.out.println(hasSameDigits(s));

        int[][] grid = {{5,3,7},{8,2,6}};
        int[] limits = {2,2};
        int k = 3;
        System.out.println(maxSum(grid, limits, k));
    }

    public static boolean hasSameDigits(String s) {
        int[] digits = new int[s.length()];
        for (int i = 0; i < s.length(); i++) {
            digits[i] = s.charAt(i) - '0';
        }
        for(int size = digits.length-1; size > 1; size--) {
            for(int j = 0; j < size; j++) {
                digits[j] = (digits[j] + digits[j + 1])%10;
            }
        }
        if(digits[0] == digits[1]) {
            return true;
        } else {
            return false;
        }
    }

    public static  long maxSum(int[][] grid, int[] limits, int k) {
        ArrayList<Integer> selectedNums = new ArrayList<>();
        long maxSum = 0;
        int rowLen = grid[0].length-1;
        for(int i = 0; i < limits.length; i++) {
            int[] row = grid[i];
            Arrays.sort(row);
            for(int j = 0; j < limits[i]; j++) {
                selectedNums.add(row[rowLen-j]);
            }
        }
        Collections.sort(selectedNums, Collections.reverseOrder());

        for(int i = 0; i < k && i < selectedNums.size(); i++) {
            maxSum += selectedNums.get(i);
        }
        return maxSum;

    }
}
