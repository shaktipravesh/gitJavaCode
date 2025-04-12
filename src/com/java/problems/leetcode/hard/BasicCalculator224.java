package com.java.problems.leetcode.hard;

import java.util.Stack;

import static java.lang.System.*;

public class BasicCalculator224 {
    public static void main(String[] args) {
        out.println(calculate("1 + 1")); // Output: 2
        out.println(calculate(" 2-1 + 2 ")); // Output: 3
        out.println(calculate("(1+(4+5+2)-3)+(6+8)")); // Output: 23
    }
    public static int calculate(String s) {
        Stack<Integer> stack = new Stack<>();
        int result = 0;
        int number = 0;
        int sign = 1;

        for(int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if(Character.isDigit(c)) {
                number = number * 10 + c - '0';
            } else if(c == '+' || c == '-') {
                result += sign * number;
                number = 0;
                sign = c == '+' ? 1 : -1;
            } else if(c == '(') {
                stack.push(result);
                stack.push(sign);
                result = 0;
                sign = 1;
            } else if(c == ')') {
                result = result + sign*number;
                result *= stack.pop();
                result += stack.pop();
                number = 0;
            }
        }
        return result + sign*number;

    }
}
