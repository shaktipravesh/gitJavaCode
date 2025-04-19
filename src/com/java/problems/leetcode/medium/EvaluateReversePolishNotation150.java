package com.java.problems.leetcode.medium;

import java.util.Stack;

import static java.lang.System.*;

public class EvaluateReversePolishNotation150 {
    public static void main(String[] args) {
        String[] tokens01 = {"2","1","+","3","*"};
        String[] tokens02 = {"4","13","5","/","+"};
        String[] tokens03 = {"10","6","9","3","+","-11","*","/","*","17","+","5","+"};
        EvaluateReversePolishNotation150 eval = new EvaluateReversePolishNotation150();
        out.println(eval.evalRPN(tokens01));
        out.println(eval.evalRPN(tokens02));
        out.println(eval.evalRPN(tokens03));

    }

    public int evalRPN(String[] tokens) {
        if (tokens.length == 0) return 0;
        Stack<Integer> stack = new Stack<>();
        for (String token : tokens) {
            switch (token) {
                case "+": stack.push(stack.pop() + stack.pop()); break;
                case "-": {
                    Integer num = stack.pop();
                    stack.push(stack.pop() - num);
                } break;
                case "*": stack.push(stack.pop() * stack.pop()); break;
                case "/": {
                    Integer num = stack.pop();
                    stack.push( stack.pop() / num);
                }break;
                default: stack.push(Integer.parseInt(token));
            }
        }
        return stack.pop();
    }
}
