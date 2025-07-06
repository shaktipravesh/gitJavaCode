package com.java.problems.code360.hard;

public class CountSetBits {
    public static void main(String[] args) {
        System.out.println(countSetBits(5));
    }
    public static int countSetBits(int n)
    {
        int bitCount = 0;
        int MOD = 1000000007;

        for(int powerNum = 1; powerNum <= n; powerNum = powerNum << 1) {
            int bitTrueNum = n - powerNum + 1;
            int quotient = bitTrueNum/(powerNum*2);
            int remainder = Math.min(bitTrueNum % (powerNum*2), powerNum);
            int powerNumBitCount = (quotient*powerNum + remainder)%MOD;
            bitCount = (bitCount + powerNumBitCount) % MOD;
        }
        return bitCount;
    }
}
