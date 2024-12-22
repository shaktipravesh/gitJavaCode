package com.java.problems.code360;

import static java.lang.System.*;

public class ConvertNumberToWords {

    public static void main(String[] args) {
        String str = handleAll(935525353);
        out.println(str);
    }

    public static String handleAll(long n) {
        StringBuilder str = new StringBuilder();
        String[] onesPlace = {"", "one ", "two ", "three ", "four ", "five ", "six ", "seven ", "eight ", "nine "};
        String[] tenthPlace = {"", "ten ", "twenty ", "thirty ", "forty ", "fifty ", "sixty ", "seventy ", "eighty ", "ninety "};
        String[] digitName = {"crore ", "lakh ", "thousand ", "hundred "};
        String[] teens = {"eleven ", "twelve ", "thirteen ", "fourteen ", "fifteen ", "sixteen ", "seventeen ", "eighteen ", "nineteen "};
        int[] digitValue = {10000000, 100000, 1000, 100};
        for(int i = 0; i < digitValue.length && n > 0; i++) {
            int quotient =(int) (n / digitValue[i]);
            n = (int) (n % digitValue[i]);
            if(quotient != 0) {
                if(quotient > 10 && quotient < 20) {
                    str.append(teens[(quotient % 11)]).append(digitName[i]);
                } else {
                    str.append(tenthPlace[quotient/10]).append(onesPlace[quotient%10]).append(digitName[i]);
                }
            }
        }
        if(n > 10 && n < 20) {
            str.append("and ").append(teens[(int)(n%11)]);
        }
        else if(n > 0) {
            str.append("and ").append(tenthPlace[(int)(n/10)]).append(onesPlace[(int)(n%10)]);
        }
        return str.toString();
    }
}
