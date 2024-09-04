package com.java.leetCode.contest;

import java.util.List;

public class WeeklyContest413 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

    public boolean checkTwoChessboards(String coordinate1, String coordinate2) {
        int iValue1 = 0;
        int iValue2 = 0;
        boolean sameColor = false;
        iValue1 = Integer.parseInt(coordinate1);
        iValue2 = Integer.parseInt(coordinate2);
        iValue1 += coordinate1.toLowerCase().charAt(0) - 'a' +1;
        iValue2 += coordinate2.toLowerCase().charAt(0) - 'a' +1;
        if((iValue1 %2 ==0 && iValue2 %2 ==0) || (iValue1 %2 !=0 && iValue2 %2 !=0)) {
        	sameColor = true;
        }
        
        return sameColor;
    }
    
    
    public int maxScore(List<List<Integer>> grid) {
    	int maxScore = 0;
    	return maxScore;
        
    }
}
