package com.java.problems.leetcode.medium;

import java.util.Stack;

public class ReverseSubstringsBetweenEachPairOfParentheses1190 {
    public static void main(String[] args) {
        ReverseSubstringsBetweenEachPairOfParentheses1190 obj = new ReverseSubstringsBetweenEachPairOfParentheses1190();
        String s = "(abcd)";
        System.out.println(obj.reverseParentheses(s));
    }
    public String reverseParentheses(String s) {
        Stack<Character> stack = new Stack<>();
        boolean isStartBracket = false;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == ')') {
                Stack<Character> temp = new Stack<>();
                while(!stack.isEmpty() && stack.peek() != '(') {
                    temp.push(stack.pop());
                }
                stack.pop();
                stack.addAll(temp);
            } else {
                if(i == 0 && c == '(') {
                    isStartBracket = true;
                }
                stack.push(c);
            }
        }

        StringBuilder result = new StringBuilder();

        if (isStartBracket) {
            for (char ch : stack) {
                result.append(ch);
            }
        } else {
            while (!stack.isEmpty()) {
                result.append(stack.pop());
            }
        }

        return result.reverse().toString();
    }
}
