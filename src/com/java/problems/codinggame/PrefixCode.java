package com.java.problems.codinggame;

import javax.xml.transform.Result;
import java.util.HashMap;
import java.util.Scanner;

public class PrefixCode {
    public static void main(String args[]) {
        Scanner in = new Scanner(System.in);
        HashMap<String, Character> strCharMap = new HashMap<>();
        StringBuilder strBuilder = new StringBuilder();
        int n = in.nextInt();
        for (int i = 0; i < n; i++) {
            String b = in.next();
            int c = in.nextInt();
            strCharMap.put(b, (char) c);
        }
        String s = in.next();
        int j = 0;
        for(int i = 0; i < s.length() && s.length() > 0; i++) {
            String sub = s.substring(0, i+1);
            if(strCharMap.containsKey(sub)) {
                strBuilder.append(strCharMap.get(sub));
                s = s.substring(i+1);
                j += i+1;
                i = -1;
            }
        }
        if(s.length() > 0) {
            System.out.println("DECODE FAIL AT INDEX " + j);
        } else {
            // Write an answer using System.out.println()
            // To debug: System.err.println("Debug messages...");

            System.out.println(strBuilder.toString());
        }
    }
}
