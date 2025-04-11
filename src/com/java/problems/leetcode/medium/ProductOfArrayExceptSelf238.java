package com.java.problems.leetcode.medium;

import java.util.Arrays;

import static java.lang.System.*;

public class ProductOfArrayExceptSelf238 {
    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 4};
        ProductOfArrayExceptSelf238 productOfArrayExceptSelf = new ProductOfArrayExceptSelf238();
        int[] result = productOfArrayExceptSelf.productExceptSelf(nums);
        out.println(Arrays.toString(result));
    }
    public int[] productExceptSelf(int[] nums) {
        int product = 1;
        int[] result = new int[nums.length];
        int countZero = 0;
        for (int num : nums) {
            if (num == 0) {
                countZero++;
            } else {
                product *= num;
            }
        }
        if(countZero >= 2) {
            product = 0;
        }
        for (int i = 0; i < nums.length; i++) {
            if(nums[i] != 0) {
                result[i] = countZero > 0 ? 0 :product / nums[i];
            } else {
                result[i] = product;
            }
        }
        return result;

    }
}
