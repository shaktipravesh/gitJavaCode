package com.java.problems.codinggame;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Stack;

public class ReversePolishNotation {
    public static void main(String args[]) {
        Scanner in = new Scanner(System.in);
        HashSet<String> operators = new HashSet<>();
        operators.add("ADD");
        operators.add("SUB");
        operators.add("MUL");
        operators.add("DIV");
        operators.add("MOD");
        operators.add("POP");
        operators.add("DUP");
        operators.add("SWP");
        operators.add("ROL");
        Stack<String> instructionStack = new Stack<>();
        int N = in.nextInt();
        for (int i = 0; i < N; i++) {
            String instruction = in.next();
            if(operators.contains(instruction)) {
                int secondOperand = 0;
                int firstOperand = 0;
                try {
                    secondOperand = Integer.parseInt(instructionStack.pop());
                    firstOperand = Integer.parseInt(instructionStack.pop());
                } catch (Exception e) {
                    instructionStack.removeAllElements();
                    instructionStack.push("ERROR");
                    break;
                }
                switch (instruction) {
                    case "ADD": {
                        instructionStack.push(String.valueOf(firstOperand + secondOperand));
                    }
                    break;
                    case "SUB": {
                        instructionStack.push(String.valueOf(firstOperand - secondOperand));
                    }
                    break;
                    case "MUL": {
                        instructionStack.push(String.valueOf(firstOperand * secondOperand));
                    }
                    break;
                    case "DIV": {
                        if(secondOperand != 0) {
                            instructionStack.push(String.valueOf(firstOperand / secondOperand));
                        } else {
                            instructionStack.push("ERROR");
                        }
                    }
                    break;
                    case "MOD": {
                        instructionStack.push(String.valueOf(firstOperand % secondOperand));
                    }
                    break;
                    case "POP": {
                        instructionStack.push(String.valueOf(firstOperand));
                    }
                    break;
                    case "DUP": {
                        instructionStack.push(String.valueOf(firstOperand));
                        instructionStack.push(String.valueOf(secondOperand));
                        instructionStack.push(String.valueOf(secondOperand));
                    }
                    break;
                    case "SWP": {
                        instructionStack.push(String.valueOf(secondOperand));
                        instructionStack.push(String.valueOf(firstOperand));
                    }
                    break;
                    case "ROL": {
                        try {
                            Stack<String> tempStack = new Stack<>();
                            tempStack.push(String.valueOf(firstOperand));
                            for(int j = 1; j < secondOperand; j++){
                                tempStack.push(instructionStack.pop());
                            }
                            String lastString = tempStack.pop();
                            while(!tempStack.empty()){
                                instructionStack.push(tempStack.pop());
                            }
                            instructionStack.push(lastString);
                        } catch (Exception e) {
                            instructionStack.removeAllElements();
                            instructionStack.push("ERROR");
                            break;
                        }
                    }
                }
            } else {
                instructionStack.push(instruction);
            }
        }

        // Write an answer using System.out.println()
        // To debug: System.err.println("Debug messages...");
        String result = String.join(" ", instructionStack);
        System.out.println(result);
    }
}
