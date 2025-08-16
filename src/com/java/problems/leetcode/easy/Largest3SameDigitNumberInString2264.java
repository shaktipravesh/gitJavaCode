package com.java.problems.leetcode.easy;

import java.util.HashSet;

public class Largest3SameDigitNumberInString2264 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	public String largestGoodInteger(String num) {
		int maxNum = Integer.MIN_VALUE;
        String result = new String();
        char[] numArray = num.toCharArray();
        for(int i =2; i < num.length(); i++) {
        	int curNum = numArray[i] - '0';
        	if(numArray[i] == numArray[i-1]) {
        		if(numArray[i] == numArray[i-2]) {
	        		if(Character.isDigit(numArray[i]) && maxNum < curNum) {
	        			result = curNum + "" + curNum + "" + curNum;
	        			maxNum = curNum;
	        			if(maxNum == 9) {
	        				break;
	        			}
	        		}
	        	}
        	} else {
        		i++;
        	}
        }
        return result;
    }
	
	public boolean isPowerOfThree(int n) {
        HashSet<Integer> powerOfFourSet = new HashSet<>();
        long powerOfFour = 1;
        while(powerOfFour <= Integer.MAX_VALUE) {
        	powerOfFourSet.add((int) powerOfFour);
        	powerOfFour *= 3;
        }
        if(powerOfFourSet.contains(n)) {
            return true;
        }
        return false;
    }
}
