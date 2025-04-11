package com.java.problems.leetcode.medium;

import java.util.ArrayList;
import java.util.List;

import static java.lang.System.*;

public class ContainerWithMostWater11 {
    public static void main(String[] args) {
        int[] height = {1,8,6,2,5,4,8,3,7};
        ContainerWithMostWater11 c = new ContainerWithMostWater11();
        out.println(c.maxArea(height));
    }
    public int maxArea(int[] height) {
        int maxArea = 0;
        int leftMax = Integer.MIN_VALUE;
        int rightMax = Integer.MIN_VALUE;
        List<Integer> leftMaxList = new ArrayList<>();
        List<Integer> rightMaxList = new ArrayList<>();
        for(int i = 0; i < height.length; i++){
            if(leftMax < height[i]){
                leftMax = height[i];
                leftMaxList.add(i);
            }
        }
        for(int i = height.length-1; i > 0; i--){
            if(rightMax < height[i]){
                rightMax = height[i];
                rightMaxList.add(i);
            }
        }
        for (int leftIndex : leftMaxList) {
            for (int rightIndex : rightMaxList) {
                int area = Math.min(height[leftIndex], height[rightIndex]) * (rightIndex - leftIndex);
                maxArea = Math.max(maxArea, area);
            }
        }
        return maxArea;

    }
}
