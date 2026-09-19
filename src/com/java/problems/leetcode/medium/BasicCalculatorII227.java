package com.java.problems.leetcode.medium;

import java.util.ArrayList;

public class BasicCalculatorII227 {
    public static void main(String[] args) {
        BasicCalculatorII227 basicCalculatorII227 = new BasicCalculatorII227();
        String s = "1+1+1";
        System.out.println(basicCalculatorII227.calculate(s));
        s = " 3/2 ";
        System.out.println(basicCalculatorII227.calculate(s));
        s = " 3/2 ";
        System.out.println(basicCalculatorII227.calculate(s));
        s = " 3+5 / 2 ";
        System.out.println(basicCalculatorII227.calculate(s));
    }

    public int calculate(String s) {
        int result = 0;
        s = s.replaceAll("\\s+", "");
        char[] sign = {'/', '*', '+', '-'};
        System.out.println(s);
        ArrayList<Object> sOperation = new ArrayList<>();
        char[] chars = s.toCharArray();
        for(int i = 0; i < chars.length; i++){
            if(chars[i] == ' '){
                continue;
            }
            if(chars[i] == '+' || chars[i] == '-' || chars[i] == '*' || chars[i] == '/'){
                sOperation.add(chars[i]);
            } else {
                int currNum = chars[i] - '0';
                while(i+1 < chars.length && chars[i+1] >= '0' && chars[i+1] <= '9'){
                    currNum = currNum * 10 + chars[++i] - '0';
                }
                sOperation.add(currNum);
            }
        }
        for (char value : sign) {
            for (int j = 1; j < sOperation.size()-1; j++) {
                char c = sOperation.get(j).toString().charAt(0);
                if (sOperation.get(j).toString().charAt(0) == value) {
                    int firstNum = Integer.parseInt(sOperation.get(j - 1).toString());
                    int secondNum = Integer.parseInt(sOperation.get(j + 1).toString());
                    int cal = getVal(firstNum, secondNum, value);
                    sOperation.add(j - 1, cal);
                    sOperation.remove(j);
                    sOperation.remove(j);
                    sOperation.remove(j);
                    j--;
                }
            }
        }
        return Integer.parseInt(sOperation.getFirst().toString());
    }

    private int getVal(int firstNum, int secondNum, char c) {
        switch(c){
            case '+': {
                return firstNum + secondNum;
            }
            case '-': {
                return firstNum - secondNum;
            }
            case '*': {
                return firstNum * secondNum;
            }
            case '/': {
                return firstNum / secondNum;
            }
            default: {
                return 0;
            }
        }
    }
}
