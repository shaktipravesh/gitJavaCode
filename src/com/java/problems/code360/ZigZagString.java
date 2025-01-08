package com.java.problems.code360;

public class ZigZagString {

    public static void main(String[] args) {
        System.out.println(zigZagString("ABCDEFG", 7, 3));
    }
    public static String zigZagString(String str, int n, int m) {
        String zigZagString = new String();
        int row = m-1;
        for(int i = 0; i <= row; i++) {
            for(int j = i, increment = i; j < n; j = j+2*increment) {
                zigZagString += str.charAt(j);
                if(increment == 0 && increment == row) {
                    increment = row;
                } else {
                    increment = row - increment;
                }
            }
        }
        return zigZagString;
    }
}
