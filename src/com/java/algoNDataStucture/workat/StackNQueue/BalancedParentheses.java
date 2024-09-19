package com.java.algoNDataStucture.workat.StackNQueue;

import java.util.Stack;

public class BalancedParentheses {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		BalancedParentheses balancedParentheses = new BalancedParentheses();
		System.out.println(balancedParentheses.isBalancedParentheses("({})[]"));
	}

	boolean isBalancedParentheses(String str) {
	    boolean balanaced = true;
	    Stack<Character> parenthesesStack = new Stack<Character>();
	    for(int i = 0; i < str.length(); i++) {
	    	if(str.charAt(i) == '(' || str.charAt(i) == '{' || str.charAt(i) == '[') {
	    		parenthesesStack.push(str.charAt(i));
	    	} else {
	    		if(parenthesesStack.size() <= 0) {
	    			return false;
	    		}
	    		Character charAtI = parenthesesStack.pop();
	    		if((str.charAt(i) == ')' && charAtI != '(') || (str.charAt(i) == '}' && charAtI != '{') || (str.charAt(i) == ']' && charAtI != '[')) {
	    			return false;
	    		}
	    	}
	    }
	    if(parenthesesStack.size() > 0) {
	    	return false;
	    }
	    return balanaced;
	}
}
