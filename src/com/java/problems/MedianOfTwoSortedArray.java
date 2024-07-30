package com.java.problems;

public class MedianOfTwoSortedArray {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] num1 = {1,2,3,4,4,6,7,8,9};
		int[] num2 = {1,2,5,5,6,8,9};
		Solution solution = new Solution();
		double median = solution.findMedianOfTwoSortedArray(num1, num2);
		System.out.println(median);

	}

}


class Solution {
	public double findMedianOfTwoSortedArray(int[] nums1, int[] nums2) {
		double median = 0;
		int iNumCount =nums1.length + nums2.length;
		int iPreMedian = (iNumCount-1)/2;
		int iLeft = 0, iRight = nums2.length;
		int iMiddle = (iLeft + iRight)/2;
		int iMid = iPreMedian - iMiddle - 2;
		
		while(true) {
			if(nums2[iMiddle +1] >= nums1[iMid] && nums1[iMid +1] >= nums2[iMiddle]) {
				break;
			}
			if(nums2[iMiddle +1] < nums1[iMid]) {
				iLeft = iMiddle + 1;
			} else if(nums1[iMid +1] < nums2[iMiddle]) {
				iRight = iMiddle + 1;
			}
			iMiddle = (iLeft + iRight)/2;
			iMid = iPreMedian - iMiddle - 2;
		}
		if(iNumCount % 2 == 0) {
			median =  ((double)(nums1[iMid +1] + nums2[iMiddle +1]))/2;
		} else {
			median = Math.min(nums1[iMid +1] , nums2[iMiddle +1]);
		}
		return median;
		
	}
}