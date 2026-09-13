package problems.leetcode.medium;

import java.util.HashSet;

public class RemovingMinimumAndMaximumFromArray2091 {
    public static void main(String[] args) {
        RemovingMinimumAndMaximumFromArray2091 sol = new RemovingMinimumAndMaximumFromArray2091();
        int[] nums = {2,10,7,5,4,1,8,6};
        System.out.println(sol.minimumDeletions(nums));
    }
    public int minimumDeletions(int[] nums) {
        int size = nums.length;
        int min = 0;
        int max = 0;
        for(int i = 0; i < nums.length; i++){
            if(nums[i] < nums[min]){
                min = i;
            }
            if(nums[i] > nums[max]){
                max = i;
            }
        }
        if(min <  size/2 && max <  size/2) {
            return Math.max(min, max) +1;
        }
        if(min >=  size/2 && max >=  size/2){
            return Math.max(size - min, size - max);
        }
        if(min <  size/2 && max >=  size/2){
            return Math.min(min + 1 + size - max, Math.min(size - min, max +1));
        }
        if(min >=  size/2 && max <  size/2){
            return Math.min(max + 1 + size - min, Math.min(size - max, min +1));
        }
        return 0;
    }

    public int countSpecialIntegers(int[] nums) {
        HashSet<Integer> set = new HashSet<>();
        HashSet<Integer> contiguousSet = new HashSet<>();
        int count = 0;
        for(int i = 0; i < nums.length; i++){
            if(set.contains(nums[i])){
                if(nums[i] != nums[i-1]){
                    contiguousSet.remove(nums[i]);
                }
            } else {
                set.add(nums[i]);
                contiguousSet.add(nums[i]);
            }
        }
        return contiguousSet.size();
    }
    public int sumDecoded(long[] nums) {
        long sum = 0;
        long MOD = 1_000_000_007;
        for (long num : nums) {
            long width = num % 10;
            long d = num / 10;
            long xi = getXi(d, width);
            long yi = getYi(d, xi);
            sum = (sum + getXPowerY(xi, yi, MOD)) % MOD;
        }
        return (int)(sum % MOD);
    }

    private long getXPowerY(long xi, long yi, long mod) {
        long result = 1;
        xi %= mod;

        while (yi > 0) {
            if ((yi & 1) == 1) {
                result = (result * xi) % mod;
            }

            xi = (xi * xi) % mod;
            yi >>= 1;
        }

        return result;
    }

    private long getYi(long d, long xi) {
        String dStr = String.valueOf(d);
        String xiStr = String.valueOf(xi);

        if (dStr.startsWith(xiStr)) {
            String remaining = dStr.substring(xiStr.length());
            return remaining.isEmpty() ? 0 : Long.parseLong(remaining);
        }
        return d;
    }

    private long getXi(long d, long width) {
        String numberStr = String.valueOf(Math.abs(d));
        String targetSubstring = numberStr.substring(0, (int) width);
        long result = Long.parseLong(targetSubstring);
        return d < 0 ? -result : result;
    }
    public int firstStableIndex(int[] nums, int k) {
        int[] maxPrev =  new int[nums.length];
        int[] minNext = new int[nums.length];

        int instabilityScore = 0;
        for(int i = 0; i < nums.length; i++){
            maxPrev[i] = i > 0?  Math.max(maxPrev[i-1], nums[i]): nums[i];
            minNext[nums.length - i - 1] = i > 0?  Math.min(minNext[nums.length - i], nums[nums.length - i -1]): nums[nums.length - i - 1];
        }
        for(int i = 0; i < nums.length; i++){
            if(maxPrev[i] -minNext[i] >= k){
                instabilityScore++;
            }
        }
        return instabilityScore;
    }
}
