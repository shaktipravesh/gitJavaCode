package com.java.problems.leetcode.easy;

import java.util.ArrayList;
import java.util.List;

public class PascalsTriangle118 {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> result = new ArrayList<>();
        if (numRows == 0) {
            return result;
        }
        List<Integer> row = new ArrayList<>();
        row.add(1);
        result.add(row);

        for (int i = 1; i < numRows; i++) {
            List<Integer> prevRow = result.get(i - 1);
            List<Integer> currRow = new ArrayList<>();
            for (int j = 0; j <= prevRow.size(); j++) {
                if(j == 0) {
                    currRow.add(prevRow.get(j));
                } else if(j == prevRow.size()) {
                    currRow.add(prevRow.get(j-1));
                } else {
                    currRow.add(prevRow.get(j) + prevRow.get(j - 1));
                }
            }
            result.add(currRow);
        }
        return result;
    }
}
