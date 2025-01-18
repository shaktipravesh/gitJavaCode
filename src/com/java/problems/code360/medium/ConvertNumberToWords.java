package com.java.problems.code360.medium;

public class ConvertNumberToWords {
    public static void main(String[] args) {
        System.out.println(handleAll(42314));
    }

    public static String handleAll(long n) {
        StringBuilder result = new StringBuilder();
        String[] ones = {"", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine"};
        String[] teens = {"ten", "eleven", "twelve", "thirteen", "fourteen", "fifteen", "sixteen", "seventeen", "eighteen", "nineteen"};
        String[] tens = {"", "ten", "twenty", "thirty", "forty", "fifty", "sixty", "seventy", "eighty", "ninety"};
        String[] divisorsStr = {"and", "hundred", "thousand", "lakh", "crore"};
        long[] dividers = {1, 100, 1000, 100000, 10000000};
        for(int i = 4 ; i >= 0; i-- ) {
            long quotient = n/dividers[i];
            n = n%dividers[i];
            if(quotient != 0) {
                if(n==0) {
                    result.append(divisorsStr[i]).append(" ");
                }
                if(quotient > 9 && quotient < 20) {
                    result.append(teens[(int) quotient % 10]).append(" ");
                } else {
                    if(quotient/10 > 0) {
                        result.append(tens[(int) quotient / 10]).append(" ");
                    } if(quotient%10 > 0) {
                        result.append(ones[(int) quotient % 10]).append(" ");
                    }
                }
                if(n >0) {
                    result.append(divisorsStr[i]).append(" ");
                }
            }
        }
        return result.toString();
    }
}
