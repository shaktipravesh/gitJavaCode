package com.java.problems.leetcode.medium;

import java.util.*;

import static java.lang.System.*;

public class LongestConsecutiveSequence128 {
    public static void main(String[] args) {
        int[] nums = {100,4,200,1,3,2};
        LongestConsecutiveSequence128 lcs = new LongestConsecutiveSequence128();
        int longestConsecutive = lcs.longestConsecutive(nums);
        out.println(longestConsecutive);
        longestConsecutive = lcs.longestConsecutiveOn(nums);
        out.println(longestConsecutive);
        longestConsecutive = lcs.longestConsecutiveSpaceOn(nums);
        out.println(longestConsecutive);
    }

    public int longestConsecutiveOn(int[] nums) {
        Set<Integer> numSet = new HashSet<>();
        for (int num : nums) {
            numSet.add(num);
        }

        int longestStreak = 0;

        for (int num : numSet) {
            // Only start counting if it's the beginning of a sequence
            if (!numSet.contains(num - 1)) {
                int currentNum = num;
                int currentStreak = 1;

                while (numSet.contains(currentNum + 1)) {
                    currentNum++;
                    currentStreak++;
                }

                longestStreak = Math.max(longestStreak, currentStreak);
            }
        }

        return longestStreak;
    }

    public int longestConsecutive(int[] nums) {
        if (nums == null || nums.length == 0) return 0;
        int[] dp = new int[100001];
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        Arrays.fill(dp, Integer.MAX_VALUE);
        for (int num : nums) {
            dp[num] = 1;
            min = Math.min(num, min);
            max = Math.max(num, max);
        }

        int longestSequence = 0;
        int subsequenceLength = 0;
        for (int i = min; i <= max; i++) {
            if(dp[i] == 1) {
                subsequenceLength++;
            } else {
                subsequenceLength = 0;
            }
            longestSequence = Math.max(longestSequence, subsequenceLength);
        }
        return longestSequence;
    }

    public int longestConsecutiveSpaceOn(int[] nums) {
        if (nums == null || nums.length == 0) return 0;
        Set<Integer> set = new TreeSet<>();
        for (int num : nums) {
            set.add(num);
        }

        List<Integer> numList = set.stream().toList();
        int prev = numList.getFirst();
        int longestSequence = 0;
        int subsequenceLength = 1;
        for (int i = 1; i < numList.size(); i++) {
            int cur = numList.get(i);
            if(cur -1 == prev) {
                subsequenceLength++;
            } else {
                subsequenceLength = 1;
            }
            prev = cur;
            longestSequence = Math.max(longestSequence, subsequenceLength);
        }
        return longestSequence;
    }
}
