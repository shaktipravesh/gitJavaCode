package com.java.algoNDataStucture.workat.strings;

public class LongestCommonPrefix {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	
	String longestCommonPrefix(String[] str) {
        String subString = str[0];
        for(int i = 1; i < str.length; i++) {
        	int j = 0;
        	for(; j < subString.length() && j <str[i].length(); j++) {
        		if(subString.charAt(j) != str[i].charAt(j)) {
        			break;
        		}
        	}
        	subString = subString.substring(0, j);
        }
        return subString;
	}
}
