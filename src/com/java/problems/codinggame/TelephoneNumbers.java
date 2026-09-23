package com.java.problems.codinggame;

import java.util.HashMap;
import java.util.Scanner;

public class TelephoneNumbers {
    public static void main(String args[]) {
        Scanner in = new Scanner(System.in);
        int N = in.nextInt();
        HashMap<Integer, HashMap> telephoneMap = new HashMap();
        int count = 0;
        for (int i = 0; i < N; i++) {
            String telephone = in.next();
            char[] telephoneChar = telephone.toCharArray();
            HashMap<Integer, HashMap> currTelephoneMap = telephoneMap;
            for (int j = 0; j < telephoneChar.length; j++) {
                Integer iThDigit = telephoneChar[j]-'0';
                if(!currTelephoneMap.containsKey(iThDigit)) {
                    currTelephoneMap.put(iThDigit, new HashMap());
                    count++;
                }
                currTelephoneMap = currTelephoneMap.get(iThDigit);
            }
        }
        System.out.println(count);
    }
}
