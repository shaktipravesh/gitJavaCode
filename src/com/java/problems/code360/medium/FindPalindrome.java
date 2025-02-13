package com.java.problems.code360.medium;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class FindPalindrome {
    public static void main(String[] args) {
        int[] palindromes = getPalindromes(10000);
        for(int num : palindromes) {
            System.out.print(num+ ", ");
        }
        System.out.println();
    }
    static boolean isPalindrome(int num) {
        String str = String.valueOf(num);
        return str.equals(new StringBuilder(str).reverse().toString());
    }
    public static int[] getPalindromesBruteForce(int n) {
        ArrayList<Integer> palindromeList = new ArrayList<>();
        int[] palindromes = new int[0];
        for (int i = 1; i <= n; i++) {
            if (isPalindrome(i)) {
                palindromeList.add(i);
            }
        }
        if (palindromeList.size() > 0) {
            palindromes = new int[palindromeList.size()];
            for (int i = 0; i < palindromeList.size(); i++) {
                palindromes[i] = palindromeList.get(i);
            }
        }
        return palindromes;
    }


    public static int[] getPalindromes(int n) {
        List<Integer> arr = new ArrayList<>();
        for (int i = 0; i < 2; ++i) {
            int num = 1;
            int palindrome = pal(num, i % 2);
            System.out.println(num + ", " + (i%2) + ", " + palindrome);
            while (palindrome <= n) {
                arr.add(palindrome);
                num += 1;

                palindrome = pal(num, i % 2);
                System.out.println(num + ", " + (i%2) + ", " + palindrome);
            }
        }
        Collections.sort(arr);
        int ans[] = arr.stream().mapToInt(i -> i).toArray();
        return ans;
    }

    private static int pal(int num, int a) {
        int n = num;
        int n2 = num;
        if (a > 0)  n = n / 10;
        while (n > 0) {
            n2 = n2 * 10 + (n % 10);
            n = n / 10;
        }
        return n2;
    }
}
