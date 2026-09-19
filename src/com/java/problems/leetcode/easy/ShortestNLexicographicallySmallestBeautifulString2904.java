package com.java.problems.leetcode.easy;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;

public class ShortestNLexicographicallySmallestBeautifulString2904 {
    public static void main(String[] args) {
        ShortestNLexicographicallySmallestBeautifulString2904 sh = new ShortestNLexicographicallySmallestBeautifulString2904();
        String s = "001110101101101111";
        int k = 10;
        System.out.println(sh.shortestBeautifulSubstring(s, k));
    }
    public String shortestBeautifulSubstring(String s, int k) {
        char[] sChar = s.toCharArray();
        int start = 0;
        int end = 0;
        int count = 0;
        int[] smalllest = new int[3];
        for (int i = 0; i < s.length(); i++) {
            end++;
            if(sChar[i] == '1') {
                count++;
            }
            while(count >= k && start < end) {
                if(smalllest[0] == 0 || (end - start) < smalllest[0]) {
                    smalllest[0] = end - start;
                    smalllest[1] = start;
                    smalllest[2] = end;
                } else if ((end - start) == smalllest[0]){
                    String previousSubString = s.substring(smalllest[1], smalllest[2]);
                    String currentSubString = s.substring(start, end);
                    if(isCurrentSmaller(previousSubString, currentSubString)) {
                        smalllest[0] = end - start;
                        smalllest[1] = start;
                        smalllest[2] = end;
                    }
                }
                if(sChar[start] == '1') {
                    count--;
                }
                start++;
            }
        }
        return s.substring(smalllest[1], smalllest[2]);
    }

    private boolean isCurrentSmaller(String previousSubString, String currentSubString) {
        for(int i = 0; i < currentSubString.length(); i++) {
            if(previousSubString.charAt(i) < currentSubString.charAt(i)) {
                return false;
            } else if(previousSubString.charAt(i) > currentSubString.charAt(i)) {
                return true;
            }
        }
        return true;
    }
    public boolean uniformArrayEasy(int[] nums1) {
        return true;
    }

    public boolean uniformArray(int[] nums1) {
        boolean allOdd = true;
        boolean allEven = true;
        int minOdd = Integer.MAX_VALUE;
        int minEven = Integer.MAX_VALUE;
        for (int j : nums1) {
            if (j % 2 == 0) {
                allOdd = false;
                minEven = Math.min(minEven, j);
            } else {
                allEven = false;
                minOdd = Math.min(minOdd, j);
            }
        }
        return allOdd || allEven || minEven > minOdd;
    }

    public long countCommas(long n) {
        long commasCount = 0;
        long baseNumber = 999;
        long remainderCal = 0;
        if (n <= 999) {
            return 0;
        }
        while(remainderCal < n) {
            remainderCal = remainderCal*1000 + baseNumber;
            commasCount += n - remainderCal;
        }
        return commasCount;
    }

    public int averageOfSubtree(TreeNode root) {
        return 0;
    }

    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode() {}
        TreeNode(int val) { this.val = val; }
        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
    public int totalNumbers(int[] digits) {
        boolean isZero = false;
        HashSet<Integer> evenDigits = new HashSet<>();
        HashSet<Integer> digitsSet = new HashSet<>();
        for (int digit : digits) {
            digitsSet.add(digit);
            if(digit%2==0) {
                evenDigits.add(digit);
            }
            if(digit == 0) {
                isZero = true;
            }
        }
        if(isZero) {
            return (digitsSet.size()-2)*(digitsSet.size()-2)*(evenDigits.size());
        }
        return (digitsSet.size()-1)*(digitsSet.size()-2)*(evenDigits.size());
    }

}
