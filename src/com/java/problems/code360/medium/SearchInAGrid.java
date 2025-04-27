package com.java.problems.code360.medium;

import java.util.ArrayList;
import java.util.List;

import static java.lang.System.*;

public class SearchInAGrid {
    public static void main(String[] args) {
        ArrayList<ArrayList<Integer>> mat = new ArrayList<>();
        mat.add(new ArrayList<>(List.of(9, 10, 14, 16)));
        mat.add(new ArrayList<>(List.of(13, 19, 27, 27)));
        mat.add(new ArrayList<>(List.of(17, 25, 34, 36)));
        mat.add(new ArrayList<>(List.of(23, 28, 35, 38)));
        mat.add(new ArrayList<>(List.of(30, 31, 37, 44)));
        out.println(searchGrid(mat, 5, 4, 25));
    }
    public static boolean searchGrid(ArrayList<ArrayList<Integer>> mat, int n, int m, int target) {

        int row = 0;
        int col = 0;
        while (row < n) {
            col = 0;
            if(target >= mat.get(row).get(col) && target <= mat.get(row).get(m-1)) {
                if (target == mat.get(row).get(col) || target == mat.get(row).get(m - 1)) {
                    return true;
                }
                while(col < m) {
                    if(target == mat.get(row).get(col)) {
                        return true;
                    }
                    if(target < mat.get(row).get(col)) {
                        break;
                    }
                    col++;
                }

            }
            if(target < mat.get(row).getFirst()) {
                break;
            }
            row++;
        }
        return false;
    }
}
