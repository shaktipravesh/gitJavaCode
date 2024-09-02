package com.java.algoNDataStucture.workat.strings;

public class IntegerToRomanNumeral {

	public static void main(String[] args) {
		IntegerToRomanNumeral integerToRomanNumeral = new IntegerToRomanNumeral();
		int[] num = {4234, 3464, 4564, 1333, 563, 847, 4325, 49, 10, 6, 5, 4, 9, 1};
		for(int i = 0; i < num.length; i++) {
			System.out.println(integerToRomanNumeral.integerToRoman(num[i]) + ", ");
		}

	}

    String integerToRoman(int num) {
        String romanNum = new String();
        int inputNum = num;
        int[] romanNumInt = {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
        String[] romanNumChar = {"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};
        for(int i = 0; i < romanNumInt.length; i++) {
        	int j = 0;
        	while(inputNum >= romanNumInt[i]) {
        		j++;
        		inputNum -= romanNumInt[i];
        	}
        	while(j > 0) {
	        	romanNum = romanNum + romanNumChar[i];
	        	j--;
        	}
        }
        return romanNum;
    }
}
