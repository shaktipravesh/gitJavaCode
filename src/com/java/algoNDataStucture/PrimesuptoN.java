package com.java.algoNDataStucture;

import java.util.ArrayList;
import java.util.List;

public class PrimesuptoN {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		PrimesuptoN pn = new PrimesuptoN();
		pn.primesUptoN(8);
	}

	/**
	 * @param n
	 * @return
	 */
	List<Integer> primesUptoN(int n) {
	    int[] arrayNum = new int[n+1];
		List<Integer> primeNumList = new ArrayList<Integer>();
		arrayNum[0] = -1;
		arrayNum[1] = -1;
		if(n >=2){
			arrayNum[2] = 2;
			primeNumList.add(2);
		}
		for(int i = 3; i <= n; i++){
			int sqrtNum = (int)Math.sqrt(i);
			
			for(int j = 2; j<=sqrtNum; j++){
				if(i%j == 0){
					arrayNum[i] = -1;
					break;
				}
			}
			if(arrayNum[i] != -1){
				arrayNum[i] = i;
				primeNumList.add(i);
			}
		}
		return primeNumList;
	}
	
}
