package com.java.algoNDataStucture.workat.strings;

public class RomanNumeralToInteger {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		RomanNumeralToInteger romanNumeralToInteger = new RomanNumeralToInteger();
		romanNumeralToInteger.romanToInt("XV");
	}

	int romanToInt(String s) {
		int romanToIntValue = 0;
		char cRoman;
		char cRomanPrev;
	    for(int i = s.length()-1; i >= 0; i--) {
	    	cRoman = s.charAt(i);
	    	int intValue = getIntegerValue(cRoman);
	    	if(i > 0) {
	    		cRomanPrev = s.charAt(i-1);
		    	if(intValue > getIntegerValue(cRomanPrev)) {
		    		intValue -= getIntegerValue(cRomanPrev);
		    		i--;
		    	}
	    	}
	    	
	    	romanToIntValue += intValue;
	    }
	    
	    return romanToIntValue;
	}

	private int getIntegerValue(char cRoman) {
		int iValue = 0;
		switch(cRoman) {
		case 'M': 
			iValue = 1000;
			break;
		case 'D':
			iValue = 500;
			break;
		case 'C': 
			iValue = 100;
			break;
		case 'L':
			iValue = 50;
			break;
		case 'X':
			iValue = 10;
			break;
		case 'V': 
			iValue = 5;
			break;
		case 'I':
			iValue = 1;
			break;
		default:
			break;
		}
		return iValue;
	}
}
