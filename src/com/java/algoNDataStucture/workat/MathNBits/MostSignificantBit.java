package com.java.algoNDataStucture.workat.MathNBits;

public class MostSignificantBit {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
    int msbSignificance(int n) {
        int msb = 1;
        while(n > 1) {
        	n = n >> 1;
        	msb = msb << 1;
        }
        return msb;
    }
    
    boolean isPowerOfTwo(int n) {
    	boolean powerOfTwo = false;
    	int bitCount = 0;
    	while(n > 0) {
    		bitCount += n & 1; 
    		n = n >> 1;
    	}
    	if(bitCount == 1) {
    		powerOfTwo = true; 
    	}
    	return powerOfTwo;
    }
    
    int countSetBits(int n) {
    	int bitCount = 0;
    	while(n > 0) {
    		bitCount += n & 1; 
    		n = n >> 1;
    	}
    	return bitCount;
    }
}
