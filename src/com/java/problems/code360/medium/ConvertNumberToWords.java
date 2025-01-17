package com.java.problems.code360.medium;

public class ConvertNumberToWords {
    public static void main(String[] args) {
        System.out.println(handleAll(42314));
    }

    public static String handleAll(long n) {
        String result = "";
        String[] ones = {"", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine"};
        String[] teens = {"ten", "eleven", "twelve", "thirteen", "fourteen", "fifteen", "sixteen", "seventeen", "eighteen", "nineteen"};
        String[] tens = {"", "ten", "twenty", "thirty", "fourty", "fifty", "sixty", "seventy", "eighty", "ninety"};
        String[] devisorsStr = {"and", "hundred", "thousand", "lakh", "crore"};
        long[] devisers = {1, 100, 1000, 100000, 10000000};
        for(int i = 4 ; i >= 0; i-- ) {
            long quotient = n/devisers[i];
            n = n%devisers[i];
            if(quotient != 0) {
                if(n==0) {
                    result += devisorsStr[i] +" ";
                }
                if(quotient > 9 && quotient < 20) {
                    result += teens[(int)quotient%10] + " ";
                } else {
                    if(quotient/10 > 0) {
                        result += tens[(int)quotient/10] + " ";
                    } if(quotient%10 > 0) {
                        result += ones[(int)quotient%10] + " ";
                    }
                }
                if(n >0) {
                    result += devisorsStr[i] +" ";
                }
            }
        }
        return result;
    }
}
