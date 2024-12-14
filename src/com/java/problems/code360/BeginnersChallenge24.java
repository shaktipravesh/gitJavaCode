package com.java.problems.code360;

import java.util.*;
import java.util.concurrent.atomic.AtomicReference;

public class BeginnersChallenge24 {
    public static void main(String[] args) {
        int[] counts = count(5);
        System.out.println(Arrays.stream(counts));
//        int[] arr = {-2, 8, 2, 5, -2, -5};
//        countPositiveNegativePairs(arr);
        int[] arr2 = {2, -2, -2, 2, 2, 2};
        countPositiveNegativePairs(arr2);
        System.out.println(reverseString("Shakti Pravesh Suhasini"));
        System.out.println(convertSentence("shakti"));
        System.out.println(evenSumTillN(10));
        System.out.println(power(41, 14));
        System.out.println(Arrays.toString(addFraction(1, 5, 3, 6)));
    }

    public static long evenSumTillN(int n) {
        return ((long)n/2)*(n/2+1);
    }

    public static int power(int N, int R){
        long powerValue = 1;
        int exponent = R;
        long base = N;
        long divisor = 1000000007;
        while(exponent > 0) {
            if((exponent&1) == 1) {
                powerValue = (powerValue * base)%divisor;
            }
            exponent = exponent>>1;
            base = (base*base)%divisor;
        }
        return (int)powerValue;

    }

    public static int[] count(int N)
    {
        int[] counts = new int[N+1];
        for(int n = 0; n <= N; n++) {
            for (int i = n; i > 0; i = i>>1 ) {
                if((i&1)==1) {
                    counts[n]++;
                }
            }
        }
        return counts;
    }

    public static long countPositiveNegativePairs(int[] arr)
    {
        HashMap<Long, Long> positiveCounts = new HashMap<>();
        HashMap<Long, Long> negativeCounts = new HashMap<>();
        AtomicReference<Long> pairCount = new AtomicReference<>(0L);
        for (int j : arr) {
            if (j > 0) {
                if (positiveCounts.containsKey((long) j)) {
                    positiveCounts.put((long) j, positiveCounts.get((long) j) + 1);
                } else {
                    positiveCounts.put((long) j, 1L);
                }
            } else if (j < 0) {
                if (negativeCounts.containsKey((long) j)) {
                    negativeCounts.put((long) j, negativeCounts.get((long) j) + 1);
                } else {
                    negativeCounts.put((long) j, 1L);
                }
            }
        }
        int positiveCount = positiveCounts.size();
        int negativeCount = negativeCounts.size();
        if(positiveCount > 0 && positiveCount <= negativeCount) {
            positiveCounts.forEach((k,v) -> {
                if(negativeCounts.containsKey(k*-1)) {
                    pairCount.updateAndGet(v1 -> v1 + positiveCounts.get(k) * negativeCounts.get(k * -1));
                }
            });
        } else if(negativeCount > 0 && negativeCount < positiveCount) {
            negativeCounts.forEach((k,v) -> {
                if(positiveCounts.containsKey(k*-1)) {
                    pairCount.updateAndGet(v1 -> v1 + positiveCounts.get(k * -1) * negativeCounts.get(k));
                }
            });
        }
        return pairCount.get();
    }

    public static String reverseString(String str)
    {
        String[] outPutStr = str.split(" ");
        String reverseStr = "";
        for(int i = outPutStr.length-1; i >= 0; i--) {
            reverseStr += outPutStr[i] +" ";
        }
        return reverseStr;
    }

    public static String intToRoman(int num) {
        String romanNum = "";
        int inputNum = num;
        int[] romanNumInt = {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
        String[] romanNumChar = {"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};
        for(int i = 0; i < romanNumInt.length; i++) {
            int j = 0;
            while(inputNum >= romanNumInt[i]) {
                j++;
                inputNum -= romanNumInt[i];
            }
            while(j >0) {
                romanNum +=romanNumChar[i];
                j--;
            }
        }
        return romanNum;
    }

    public static long[] addFraction(int a, int b, int c, int d) {
        long numerator = (long) a *d+ (long) b *c;
        long denominator = (long) c *d;
        long gcd = gcd(numerator, denominator);
        long[] result = new long[2];
        result[0] = numerator/gcd;
        result[1] = denominator/gcd;
        return result;
    }

    private static long gcd(long a, long b) {
        if (b == 0) return a;
        return gcd(b, a % b);
    }

    public static String convertSentence(String str)
    {
        StringBuilder result = new StringBuilder();
        HashMap<Character, String> hashMap = new HashMap<>();
        hashMap.put('a', "2");hashMap.put('b', "22");hashMap.put('c', "222");
        hashMap.put('d', "3");hashMap.put('e', "33");hashMap.put('f', "333");
        hashMap.put('g', "4");hashMap.put('h', "44");hashMap.put('i', "444");
        hashMap.put('j', "5");hashMap.put('k', "55");hashMap.put('l', "555");
        hashMap.put('m', "6");hashMap.put('n', "66");hashMap.put('o', "666");
        hashMap.put('p', "7");hashMap.put('q', "77");hashMap.put('r', "777");hashMap.put('s', "7777");
        hashMap.put('t', "8");hashMap.put('u', "88");hashMap.put('v', "888");
        hashMap.put('w', "9");hashMap.put('x', "99");hashMap.put('y', "999");hashMap.put('z', "9999");

        for(int i = 0; i < str.length(); i++) {
            result.append(hashMap.get(str.charAt(i)));
        }

        return result.toString();
    }

    public static int minDepth(BinaryTreeNode<Integer> root) {
        int minDepth = 0;
        boolean minDepthFound = false;
        int start;
        int size = 0;
        List<BinaryTreeNode<Integer>> nodes = new ArrayList<>();
        if(root != null) {
            minDepth++;
            nodes.add(root);
        }
        while (!nodes.isEmpty() && !minDepthFound) {
            start = size;
            size = nodes.size();
            for (int i = start; i < size; i++) {
                if (nodes.get(i).left == null && nodes.get(i).right == null) {
                    minDepthFound = true;
                    break;
                }
                if (nodes.get(i).left != null) {
                    nodes.add(nodes.get(i).left);
                }
                if (nodes.get(i).right != null) {
                    nodes.add(nodes.get(i).right);
                }
            }
            if(!minDepthFound) {
                minDepth++;
            }
        }
        return minDepth;
    }
}


class BinaryTreeNode<T> {
    T data;
    BinaryTreeNode<T> left;
    BinaryTreeNode<T> right;

    public BinaryTreeNode(T data) {
        this.data = data;
    }
}