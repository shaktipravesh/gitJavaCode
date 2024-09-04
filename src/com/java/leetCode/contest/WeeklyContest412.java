package com.java.leetCode.contest;

import java.util.Arrays;

public class WeeklyContest412 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		WeeklyContest412 weeklyContes412 = new WeeklyContest412();
		int[] nums = {5, 8, 12, 5, 5, 1, 20, 3, 10, 10, 5, 5, 5, 5, 1};
		System.out.println(weeklyContes412.countPairs(nums));
	}

    public int[] getFinalState(int[] nums, int k, int multiplier) {
        for(int i = 0; i < k; i++) {
        	int j = 0, minIndex = 0;;
        	for(; j < nums.length; j++) {
        		if(nums[minIndex] > nums[j]) {
        			minIndex = j;
        		}
        	}
        	nums[minIndex] = nums[minIndex]*multiplier;
        }
        
        return nums;
    }
    
    public int countPairs(int[] nums) {
    	int[] myNums = {226726,387862,880512,611522,343461,420841,334461,10813,226726,334461,80113,314364,10813,163067,134364,332548,413463,343416,236429,164332,566432,226726,334164,343461,143463,163229,667555,667555,343461,657565,343461,770521,285866,930657,236429,502387,313446,334461,12219,163760,144363,227626};
        int pairs = 0;
        int reverseNum = 0;
        Arrays.sort(nums);
        Arrays.sort(myNums);
        for(int i = 0; i < myNums.length; i++) {
        	System.out.print(myNums[i] +", ");
        }
        System.out.println();
        for(int i = 1; i < nums.length; i++) {
        	reverseNum = revertNumber(nums[i]);
        	if(reverseNum < nums[i]) {
        		nums[i] = reverseNum;
        	}
        }
        Arrays.sort(nums);
        for(int i = 1; i < nums.length; i++) {
        	for(int j = 0; j < i; j++) {
        		if(nums[i] == nums[j]) {
        			pairs++;
        		}
        	}
        }
        return pairs;
    }

	private int revertNumber(int i) {
		int reverseNum = 0;
		while( i > 0) {
			reverseNum = reverseNum*10 + i%10;
			i = i/10;
		}
		return reverseNum;
	}
    
    
}
