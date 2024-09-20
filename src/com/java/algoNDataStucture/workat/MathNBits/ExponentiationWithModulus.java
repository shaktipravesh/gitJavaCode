package com.java.algoNDataStucture.workat.MathNBits;

public class ExponentiationWithModulus {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	int getModulatedPower(int x, int y, int z) {
	    int modulatedPower = 1;
	    x = x % z; 
	    while (y > 0)
	    {
	      if ((y & 1) != 0) {
	    	  modulatedPower = (modulatedPower * x) % z;
	      }
	      y = y >> 1; // y = y/2
	      x = (x * x) % z;
	    }
	    return modulatedPower;
	}
}
