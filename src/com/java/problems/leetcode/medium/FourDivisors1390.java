package com.java.problems.leetcode.medium;

import java.util.ArrayList;
import java.util.Arrays;

public class FourDivisors1390 {
    public static void main(String[] args) {
        int[] nums = {21,4,7};
        FourDivisors1390 obj = new FourDivisors1390();
        System.out.println(obj.sumFourDivisors(nums));
    }

    public int sumFourDivisors(int[] nums) {
        ArrayList<Integer> primes = getPrimeNumbers();
        int sumOfFourDivisors = 0;
        for(int num : nums) {
            for (Integer prime : primes) {
                if(prime*prime >= num) {
                    break;
                }
                if(num % prime == 0) {
                    if(primes.contains(num/prime)) {
                        sumOfFourDivisors += 1 + num + prime + num/prime;
                    }
                    if(num/prime == prime*prime) {
                        sumOfFourDivisors += 1 + num + prime + prime*prime;
                    }
                    break;
                }
            }
        }
        return sumOfFourDivisors;
    }

    private ArrayList<Integer> getPrimeNumbers() {
        int maxNum = 100001;
        int[] numbers = new int[maxNum];
        for (int i = 2; i < maxNum; i++) {
            numbers[i] = i;
        }
        for(int i = 2; i*i < maxNum; i++) {
            for(int j = i; i*j < maxNum && numbers[i] > 0; j++) {
                numbers[i*j] = 0;
            }
        }
        ArrayList<Integer> primes = Arrays.stream(numbers).filter(a-> a>0).collect(ArrayList::new, ArrayList::add, ArrayList::addAll);
        return primes;
    }
}
