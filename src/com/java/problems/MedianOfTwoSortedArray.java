package com.java.problems;

public class MedianOfTwoSortedArray {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		int[] num1 = {1,2,3,4,4,6,7,8,9};
//		int[] num2 = new int[0];
//		int[] num1 = {1,2,3,4,4,6,7,8,9,10};
//		int[] num2 = new int[0];
//		int[] num1 = new int[0];
//		int[] num2 = {1,2,5,5,6,8,9};
//		int[] num1 = new int[0];
//		int[] num2 = {1,2,5,5,6,8,9, 10};
//		int[] num1 = {1,2,3,3,3,6,7,8,9};
//		int[] num2 = {1,2,5,5,6,8,9};
//		int[] num1 = {8, 9, 18, 19, 29};
//		int[] num2 = {1, 2, 3, 4, 5, 6, 7};

		int[] num1 = {1, 2};
		int[] num2 = {3, 4};
//		int[] num1 = {1, 3};
//		int[] num2 = {2};
//		int[] num1 = {1,2,3,4,4,6,7,8,9};
//		int[] num2 = {1,2,5,5,6,8,9};
//		int[] num1 = {1,2,3,4,4,6,7,8,9};
//		int[] num2 = {1,2,5,5,6,8,9};
//		int[] num1 = {1,2,3,4,4,6,7,8,9};
//		int[] num2 = {1,2,5,5,6,8,9};
		Solution solution = new Solution();
		double median;
		median = solution.findMedianSortedArrays(num1, num2);
		System.out.println(median);
		median = solution.findMedianOfTwoSortedArray(num1, num2);
		System.out.println(median);

	}
}


class Solution {

	public double findMedianSortedArrays(int nums1[], int nums2[]) {
		//if nums1 length is greater than switch them so that nums1 is smaller than nums2.
		if (nums1.length > nums2.length) {
			return findMedianSortedArrays(nums2, nums1);
		}
		int x = nums1.length;
		int y = nums2.length;

		int low = 0;
		int high = x;
		while (low <= high) {
			int partitionX = (low + high)/2;
			int partitionY = (x + y + 1)/2 - partitionX;

			//if partitionX is 0 it means nothing is there on left side. Use -INF for maxLeftX
			//if partitionX is length of input then there is nothing on right side. Use +INF for minRightX
			int maxLeftX = (partitionX == 0) ? Integer.MIN_VALUE : nums1[partitionX - 1];
			int minRightX = (partitionX == x) ? Integer.MAX_VALUE : nums1[partitionX];

			int maxLeftY = (partitionY == 0) ? Integer.MIN_VALUE : nums2[partitionY - 1];
			int minRightY = (partitionY == y) ? Integer.MAX_VALUE : nums2[partitionY];

			if (maxLeftX <= minRightY && maxLeftY <= minRightX) {
				//We have partitioned array at correct place
				// Now get max of left elements and min of right elements to get the median in case of even length combined array size
				// or get max of left for odd length combined array size.
				if ((x + y) % 2 == 0) {
					return ((double)Math.max(maxLeftX, maxLeftY) + Math.min(minRightX, minRightY))/2;
				} else {
					return (double)Math.max(maxLeftX, maxLeftY);
				}
			} else if (maxLeftX > minRightY) { //we are too far on right side for partitionX. Go on left side.
				high = partitionX - 1;
			} else { //we are too far on left side for partitionX. Go on right side.
				low = partitionX + 1;
			}
		}

		//Only we we can come here is if input arrays were not sorted. Throw in that scenario.
		throw new IllegalArgumentException();
	}

	public double findMedianOfTwoSortedArray(int[] nums1, int[] nums2) {
		double median = 0;
		if (nums1.length > nums2.length) {
			return findMedianOfTwoSortedArray(nums2, nums1);
		}
		int num1Length = nums1.length;
		int num2Length = nums2.length;
		int preMedian = (num1Length + num2Length + 1) / 2;
		int num1Left = 0;
		int num1Right = num1Length;

		while (num1Left <= num1Right) {
			int num1MedianIndex = (num1Left + num1Right) / 2;
			int num2MedianIndex = preMedian - num1MedianIndex;

			int num1Min = (num1MedianIndex == 0)? Integer.MIN_VALUE : nums1[num1MedianIndex - 1] ;
			int num1Max = (num1MedianIndex == num1Length)? Integer.MAX_VALUE : nums1[num1MedianIndex] ;

			int num2Min = (num2MedianIndex == 0)? Integer.MIN_VALUE : nums2[num2MedianIndex - 1] ;
			int num2Max = (num2MedianIndex == num2Length)? Integer.MAX_VALUE : nums2[num2MedianIndex] ;
			if (num1Min <= num2Max && num2Min <= num1Max) {
				if((num1Length + num2Length) % 2 == 0) {
					return (double) (Math.max(num1Min, num2Min) + Math.min(num1Max, num2Max)) / 2.0;
				} else {
					return Math.max(num1Min, num2Min);
				}
			} else if(num1Min > num2Max) {
				num1Right = num1MedianIndex - 1;
			} else {
				num1Left = num1MedianIndex + 1;
			}
		}
		return median;
	}

}