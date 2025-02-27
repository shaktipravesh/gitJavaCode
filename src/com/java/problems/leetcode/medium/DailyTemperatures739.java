package com.java.problems.leetcode.medium;

import java.util.Stack;

public class DailyTemperatures739 {
    public int[] dailyTemperatures(int[] temperatures) {
        Stack<Integer> stack = new Stack<>();
        int[] result = new int[temperatures.length];
        stack.push(0);

        for(int i = 1; i < temperatures.length; i++) {
            while(!stack.isEmpty() && temperatures[i] > temperatures[stack.peek()]) {
                result[stack.peek()] = i-stack.peek();
                stack.pop();
            }
            stack.push(i);
        }
        return result;

    }
}
