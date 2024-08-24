package com.java.algoNDataStucture.workat.dp;

public class LongestCommonSubsequence {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		LongestCommonSubsequence lcs = new LongestCommonSubsequence();
		int lcsLength = lcs.getLengthOfLCS("shaktipravesh", "suhasinirathorevincit");
		System.out.println(lcsLength);
		
		String[] strs = {"flower","flow"};
		lcs.longestCommonPrefix(strs);
	}

	int getLengthOfLCS(String s1, String s2) {
		// add your logic here
		int[][] LCSMatrix = new int[s1.length()+1][s2.length()+1];
		for(int i = 0; i < s1.length(); i++) {
			for(int j = 0; j < s2.length(); j++) {
				if(s1.charAt(i) == s2.charAt(j)) {
					LCSMatrix[i+1][j+1] = LCSMatrix[i][j] + 1;
				} else {
					LCSMatrix[i+1][j+1] = Math.max(LCSMatrix[i][j+1], LCSMatrix[i+1][j]);
				}
			}
		}
		
		return LCSMatrix[s1.length()][s2.length()];
	}
	
    public String longestCommonPrefix(String[] strs) {
        String subString = strs[0];
        for(int i = 1; i < strs.length; i++) {
        	int j = 0;
        	for(; j < subString.length() && j <strs[i].length(); j++) {
        		if(subString.charAt(j) != strs[i].charAt(j)) {
        			break;
        		}
        	}
        	subString = subString.substring(0, j);
        }
        System.out.println(subString);
        return subString;
    }
}
