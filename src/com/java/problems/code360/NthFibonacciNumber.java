package com.java.problems.code360;

public class NthFibonacciNumber {
    public static void main(String[] args) {
        System.out.println(fibonacciNumber(8));
    }

    public static int fibonacciNumber(int n){
        long fibonacciNumber = 1;
        if(n <= 2) {
            return (int)fibonacciNumber;
        }

        fibonacciNumber = getFibonacciNumber(n-1);
        return (int)fibonacciNumber;
    }

    public static long getFibonacciNumber (int n) {
        long[][] baseMatrix = {{1, 1}, {1, 0}};
        long[][] resultMatrix = {{1, 0}, {0, 1}};
        long modValue = 1000000007;
        while (n > 0) {
            if((n&1) == 1) {
                resultMatrix = multiplyMatrix(baseMatrix, resultMatrix);
            }
            baseMatrix = multiplyMatrix(baseMatrix, baseMatrix);
            n = n>>1;
        }
        return (int)resultMatrix[0][0]%modValue;
    }

    private static long[][] multiplyMatrix(long[][] baseMatrix, long[][] resultMatrix) {
        long[][] multiplyMatrix = new long[baseMatrix.length][baseMatrix[0].length];
        long modValue = 1000000007;
        multiplyMatrix[0][0] = (baseMatrix[0][0] * resultMatrix[0][0] + baseMatrix[0][1] * resultMatrix[1][0])%modValue;
        multiplyMatrix[0][1] = (baseMatrix[0][0] * resultMatrix[0][1] + baseMatrix[0][1] * resultMatrix[1][1])%modValue;
        multiplyMatrix[1][0] = (baseMatrix[1][0] * resultMatrix[0][0] + baseMatrix[1][1] * resultMatrix[1][0])%modValue;
        multiplyMatrix[1][1] = (baseMatrix[1][0] * resultMatrix[0][1] + baseMatrix[1][1] * resultMatrix[1][1])%modValue;
        return multiplyMatrix;
    }
}
