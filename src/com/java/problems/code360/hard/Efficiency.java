package com.java.problems.code360.hard;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;


public class Efficiency {
    public static void main(String[] args) {
        System.out.println(countSubstrings("shaktipravesh"));
    }

    public static int maximumEfficiency(int []outcome, int n) {
        Arrays.sort(outcome);
        int efficiency = 0;
        int variableEfficiency = 0;
        int negativeEnd = 0;
        int task = 0;
        for (int i = 0; i < n; i++) {
            if(outcome[i] >= 0) {
                task++;
                efficiency += task * outcome[i];
                variableEfficiency += outcome[i];
            } else {
                negativeEnd = i;
            }
        }
        while (negativeEnd >=0) {
            if( variableEfficiency > outcome[negativeEnd] ) {
                efficiency += variableEfficiency;
                variableEfficiency += outcome[negativeEnd];
                negativeEnd--;
            } else {
                break;
            }
        }
        return efficiency;
    }

    public static int countSubstrings(String s)
    {
        int vowelCt = 0;
        HashSet<Character> set = new HashSet<>(List.of('a', 'e', 'i', 'o', 'u'));
        int vowelLen = 0;
        for (int i = 0; i < s.length(); i++) {
            if(set.contains(s.charAt(i))) {
                vowelCt++;
                vowelLen++;
            } else {
                vowelCt +=(vowelLen * (vowelLen + 1))/2 - vowelLen;
                vowelLen = 0;
            }
        }
        vowelCt +=(vowelLen * (vowelLen + 1))/2 - vowelLen;
        return vowelCt;
    }
}
