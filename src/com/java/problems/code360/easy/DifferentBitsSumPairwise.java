package com.java.problems.code360.easy;

import java.util.ArrayList;
import java.util.List;

public class DifferentBitsSumPairwise {
    public static void main(String[] args) {
        ArrayList<Integer> arr = new ArrayList<>(List.of(1, 3, 5));
        System.out.println(differentBitsSumPairwise(arr, arr.size()));
    }
    public static int differentBitsSumPairwise(ArrayList<Integer> arr, int n)
    {
        int bitsSum = 0;
        int MOD = 1000000007;
        long result =0;

        for(int bit = 0; bit < 32; bit++) {
            long countOnes = 0;
            for(int i = 0; i < n; i++) {
                if((arr.get(i) & (1<<bit)) > 0) {
                    countOnes++;
                }
            }
            long countZeros = n-countOnes;
            result = (result + (countOnes * countZeros * 2) % MOD)%MOD;
        }
        return (int)result;

		/*
		Bruteforce N^2
		for(int i = 0; i < n; i++) {
			for(int j = i+1; j < n; j++) {
				int xorOfTwo = arr.get(i)^arr.get(j) ;
				bitsSum += Integer.bitCount(xorOfTwo);
				bitsSum = bitsSum %mod;
			}
		}
		return 2*bitsSum;
		*/
    }
}
