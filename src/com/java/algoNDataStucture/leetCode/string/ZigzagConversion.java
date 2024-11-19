package com.java.algoNDataStucture.leetCode.string;

import java.util.Arrays;

public class ZigzagConversion {
    public static void main(String[] args) {
        String inputString = "SHAKTIPRAVESHSUHASINIRATHOREVINCITBEENARATHORE";
        int numRows = 5;
        String outputString = convert(inputString, numRows);
        System.out.println(outputString);
    }

    public static String convert(String s, int numRows) {
        if(numRows < 2)
            return s;

        int iColumn = s.length() / (2*numRows-2) * (numRows -1) + s.length() % (2*numRows-2);
        String outputString = "";
        Character[][] charOutput = new Character[numRows][iColumn];
        boolean iRowDir = true;
        for(int i = 0, iRow = 0, iCol = 0; i  < s.length(); i++) {
            charOutput[iRow][iCol] = s.charAt(i);
            if(iRow == numRows-1) {
                iRowDir = false;
            } else if(iRow == 0){
                iRowDir = true;
            }
            if(iRowDir) {
                iRow++;
            } else {
                iCol++;
                iRow--;
            }

        }
        for(int iRow = 0; iRow < charOutput.length; iRow++) {
            for(int col = 0; col < charOutput[0].length; col++) {
                if(charOutput[iRow][col] != null) {
                    outputString += charOutput[iRow][col];
                }
                //System.out.print(charOutput[iRow][col] + " ");
            }
            //System.out.println();
        }
        //System.out.println();
        return outputString;
    }
}
