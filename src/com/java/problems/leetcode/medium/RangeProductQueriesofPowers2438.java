package com.java.problems.leetcode.medium;

import java.util.HashMap;

public class RangeProductQueriesofPowers2438 {

	public static void main(String[] args) {
		RangeProductQueriesofPowers2438 r = new RangeProductQueriesofPowers2438();
		int n = 15;
		int[][] queries = {{0,1}, {2,2}, {0,3}};
		int[] queriesProduct = r.productQueries(n, queries);
		System.out.println(queriesProduct);

	}
	
	public int[] productQueries(int n, int[][] queries) {
		int mod = 1000000007;
		HashMap<String, Integer> queryMap = new HashMap<>();
		int numOfQueries = queries.length;
		int[] queriesProduct = new int[numOfQueries];
		int[] powersOfTwo = new int[33];
		long powOfTwo = 1;
		int index = 0;
		while(powOfTwo <= Integer.MAX_VALUE) {
			if((powOfTwo & n) == powOfTwo) {
				powersOfTwo[index++] = (int) powOfTwo;
			}
			powOfTwo = powOfTwo << 1;
		}
        
		for(int i = 0; i < numOfQueries; i++) {
			int start = queries[i][0];
			int end = queries[i][1];
			String key = start + "_" + end;
			long queryResult = 1;
			while(start <= end) {
				queryResult = queryResult*powersOfTwo[start] % mod;
				start++;
			}
			queriesProduct[i] = (int) queryResult;
		}
		
		return queriesProduct;
    }
}
