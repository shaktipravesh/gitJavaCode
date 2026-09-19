package com.java.problems.leetcode.medium;

import java.util.ArrayList;

public class TotalWavinessOfNumbersInRangeI3751 {
    public static void main(String[] args) {
        TotalWavinessOfNumbersInRangeI3751 t = new TotalWavinessOfNumbersInRangeI3751();
        int num1 = 8900, num2 = 9532;
        System.out.println(t.totalWaviness(num1, num2));
    }
    public int totalWaviness(int num1, int num2) {
        int waviness = 0;
        for (int i = num1; i <= num2; i++) {
            ArrayList<Integer> digits = new ArrayList<>();
            int num = i;
            digits = getDigits(digits, num);;
            for(int j = 1; j < digits.size()-1; j++) {
                if((digits.get(j) > digits.get(j+1) && digits.get(j) > digits.get(j-1)) ||
                        (digits.get(j) < digits.get(j+1) && digits.get(j) < digits.get(j-1))){
                    waviness++;
                }
            }
            System.out.println(i + ": " + waviness);
        }
        return waviness;
    }

    private ArrayList<Integer> getDigits(ArrayList<Integer> digits, int num) {
        if (num == 0) return digits;
        if(num > 0) {
            getDigits(digits, num / 10);
            digits.add(num % 10);
        }
        return digits;
    }
}
