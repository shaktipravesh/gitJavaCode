package com.java.algoNDataStucture.workat.strings;

import java.util.Arrays;

public class Anagrams {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	boolean areAnagrams(String A, String B) {
	    int[] anagramInt = new int[26];
	    boolean anagram = true;
	    A = A.toLowerCase();
	    B = B.toLowerCase();
	    for(int i = 0; i < A.length(); i++) {
	    	anagramInt[A.charAt(i)-'a']++;
	    }
	    for(int i = 0; i < B.length(); i++) {
	    	anagramInt[B.charAt(i)-'a']--;
	    }
	    
	    for(int i = 0; i < anagramInt.length; i++) {
	    	if(anagramInt[i] > 0) {
	    		anagram = false;
	    		break;
	    	}
	    }
	    return anagram;
	}
	
    static boolean areAnagram(String A, String B)
    {
        // Get lengths of both strings
    	char[] str1 = A.toCharArray();
    	char[] str2 = B.toCharArray();
        int n1 = str1.length;
        int n2 = str2.length;
 
        // If length of both strings is not
        // same, then they cannot be anagram
        if (n1 != n2)
            return false;
 
        // Sort both strings
        Arrays.sort(str1);
        Arrays.sort(str2);
 
        // Compare sorted strings
        for (int i = 0; i < n1; i++)
            if (str1[i] != str2[i])
                return false;
 
        return true;
    }
}
