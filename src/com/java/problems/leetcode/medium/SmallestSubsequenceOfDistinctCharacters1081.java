package problems.leetcode.medium;

import java.util.LinkedHashSet;

public class SmallestSubsequenceOfDistinctCharacters1081 {
    public String smallestSubsequence(String s) {
        LinkedHashSet<Character> smallestDistinctCharacterSubstring = new LinkedHashSet<>();
        char[] sChar = s.toCharArray();
        for (char value : sChar) {
            if (!smallestDistinctCharacterSubstring.contains(value)) {
                smallestDistinctCharacterSubstring.add(value);
            } else {
                int iCharPos = 0;
                for (Character c : smallestDistinctCharacterSubstring) {
                    if ((c > value)) {
                        break;
                    }
                    if (c.equals(value) || iCharPos > 0) {
                        iCharPos++;
                    }
                    if (iCharPos > 1) {
                        smallestDistinctCharacterSubstring.add(value);
                        break;
                    }
                }
            }
        }
        return smallestDistinctCharacterSubstring.toString();
    }
    public int longestPalindromeSubseq(String s) {
        int[][] sDp = new int[s.length()][s.length()];
        for(int i = 0; i < s.length(); i++) {
            sDp[i][i] = 1;
            for (int j = i - 1; j >= 0; j--){
                if(s.charAt(i) == s.charAt(j)){
                    sDp[i][j] = sDp[i-1][j+1] + 2;
                } else {
                    sDp[i][j] = Math.max(sDp[i-1][j], sDp[i][j+1]);
                }
            }
        }
        return sDp[s.length()-1][0];
    }
}
