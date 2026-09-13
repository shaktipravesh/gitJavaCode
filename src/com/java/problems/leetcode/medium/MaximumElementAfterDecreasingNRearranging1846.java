package problems.leetcode.medium;

import java.util.Arrays;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;

public class MaximumElementAfterDecreasingNRearranging1846 {
    public static void main(String[] args) {
        MaximumElementAfterDecreasingNRearranging1846 maxElement = new MaximumElementAfterDecreasingNRearranging1846();
        int[] arrInts= {209,209,209,209,209,209,209,209};
        System.out.println(maxElement.maximumElementAfterDecrementingAndRearranging(arrInts));
    }
    public int maximumElementAfterDecrementingAndRearranging(int[] arr) {
        Arrays.sort(arr);
        int maxElement = 1;
        for(int num : arr) {
            if(num >= maxElement + 1) {
                maxElement++;
            }
        }
        return maxElement;
    }
}
