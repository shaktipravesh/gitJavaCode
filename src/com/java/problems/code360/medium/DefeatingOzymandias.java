package com.java.problems.code360.medium;

import java.util.ArrayList;
import java.util.function.Function;

public class DefeatingOzymandias {
    //https://www.naukri.com/code360/problems/defeating-ozymandias_1466951?kunjiRedirection=true
    public static ArrayList<ArrayList<Integer>> sol(Function f, int z) {
        ArrayList<ArrayList<Integer>> res = new ArrayList<>();
        int i = 1, j = z;
        while(i <= z && j >= 1) {
            int ans = z;//f.f(i, j);
            if(ans == z) {
                ArrayList<Integer> temp = new ArrayList<>();
                temp.add(i);
                temp.add(j);
                res.add(temp);
                i++;
                j--;
            } else if( ans < z) {
                i++;
            } else {
                j--;
            }
        }
        return res;
    }
}
