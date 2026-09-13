package problems.leetcode.easy;

public class FindGreatestCommonDivisorOfArray1979 {
    public int findGCD(int[] nums) {
        int smallest = Integer.MAX_VALUE;
        int largest = Integer.MIN_VALUE;
        for(int num : nums) {
            smallest = Math.min(smallest, num);
            largest = Math.max(largest, num);
        }
        return findGCD(smallest, largest);
    }
    public static int findGCD(int a, int b) {
        if (b == 0) {
            return a;
        }
        return findGCD(b, a % b);
    }
}
