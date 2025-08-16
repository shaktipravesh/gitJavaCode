package com.java.problems.leetcode.easy;

public class Maximum69Number1323 {

	public static void main(String[] args) {
		maximum69Number(9669);
		
	}
	
	public static int maximum69Number (int num) {
        int max69Number = num;
        int n = num;
        for(int i = 1; n > 0; i = i* 10, n = n/10) {
        	if(n % 10 == 6) {
        		max69Number = num + 3*i; 
        	}
        }
        return max69Number;
    }

}
