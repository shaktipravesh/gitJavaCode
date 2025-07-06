package com.java.problems.leetcode.medium;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

import static java.lang.System.*;

public class MinimumNumberOfArrowsToBurstBalloons452 {
    public static void main(String[] args) {
        int[][] points = {{10,16}, {2,8}, {1,6}, {7,12}};
        int[][] points01 = {{1,2}, {3,4}, {5,6}, {7,8}};
        int[][] points02 = {{1,2}, {2,3}, {3,4}, {4,5}};
        MinimumNumberOfArrowsToBurstBalloons452 solution = new MinimumNumberOfArrowsToBurstBalloons452();
        out.println(solution.findMinArrowShots(points));
        out.println(solution.findMinArrowShots(points01));
        out.println(solution.findMinArrowShots(points02));
    }

    public int findMinArrowShots(int[][] points) {
        if(points == null || points.length == 0) return 0;
        int count = 1;
        List<Integer[]> pointList = new ArrayList<>();
        for(int[] point : points) {
            pointList.add(new Integer[]{point[0], point[1]});
        }
        pointList.sort(Comparator
                .comparing((Integer[] arr) -> arr[1])
                .thenComparing(arr -> arr[0]));
        Integer[] prePoint = pointList.getFirst();
        for(int i = 1; i < pointList.size(); i++) {
            Integer[] point = pointList.get(i);
            if(prePoint[1] < point[0]) {
                prePoint = point;
                count++;
            }

        }
        return count;
    }
}
