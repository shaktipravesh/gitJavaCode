package com.java.problems.codinggame;

import java.util.Scanner;

public class WORLD1000000000D {
    public static void main(String args[]) {
        Scanner in = new Scanner(System.in);
        String a = in.nextLine();
        String b = in.nextLine();
        String[] aString = a.split(" ");
        String[] bString = b.split(" ");
        long sum = 0;
        long aISize = 0;
        long bISize = 0;
        long aINum = 0;
        long bINum = 0;
        for(int i = 0, j = 0; i < aString.length && j < bString.length;) {
            if(aISize == 0) {
                aISize = Integer.parseInt(aString[i]);
                aINum = Integer.parseInt(aString[i+1]);
            }
            if(bISize == 0) {
                bISize = Integer.parseInt(bString[j]);
                bINum = Integer.parseInt(bString[j + 1]);
            }
            if(aISize > bISize) {
                sum += bISize * aINum * bINum;
                aISize -= bISize;
                bISize = 0;
            } else {
                sum += aISize *aINum * bINum;
                bISize -= aISize;
                aISize = 0;
            }
            i = aISize == 0? i+2 : i;
            j = bISize == 0? j+2 : j;
        }
        // Write an answer using System.out.println()
        // To debug: System.err.println("Debug messages...");

        System.out.println(sum);
    }
}
