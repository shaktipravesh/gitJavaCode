package com.java.algoNDataStucture.leetCode;

public class ReverseInteger {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ReverseInteger reverseInteger = new ReverseInteger();
		int reversedInteger = -123;
		reversedInteger = reverseInteger.reverse(reversedInteger);
		System.out.println(reversedInteger);
	}

    public int reverse(int x) {
        int MAX_VALUE = 214748364;  //2^31 = 2147483648
        int reverseInt = 0;
        while(x != 0) {
            if(reverseInt >= 0){
                if(reverseInt > MAX_VALUE || (reverseInt == MAX_VALUE && x%10 > 7)) {
                    return 0;
                }
            }
             if(reverseInt < 0){
                if(reverseInt < -MAX_VALUE || (reverseInt == MAX_VALUE && x%10 > 8)) {
                    return 0;
                }
            }
            reverseInt = reverseInt*10 + x%10;
            x = x/10;
        }
        return reverseInt;
    }
}
