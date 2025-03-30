package com.java.problems.leetcode.contest;

import java.util.*;

public class WeeklyContest441 {
    public static void main(String[] args) {
        int[] nums = {2,10,20,20,20};
        int[] queries = {1, 4, 2};
        WeeklyContest441 wc = new WeeklyContest441();
        wc.solveQueries(nums, queries);
    }

    public List<Integer> solveQueries(int[] nums, int[] queries) {
        List<Integer> res = new ArrayList<>();
        HashMap<Integer, List<Integer>> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(nums[i])) {
                List<Integer> set = map.get(nums[i]);
                set.add(i);
            } else {
                List<Integer> set = new ArrayList<>();
                set.add(i);
                map.put(nums[i], set);
            }
        }
        for (int index : queries) {
            int num = nums[index];
            if (map.containsKey(num)) {
                List<Integer> list = map.get(num);

                if (list.size() < 2) {
                    res.add(-1);
                } else {
                    int j = 0;
                    for (; j < list.size(); j++) {
                        if (list.get(j) == index) {
                            break;
                        }
                    }
                    int current = list.get(j);
                    int next = list.get((j + 1) % list.size());
                    int prev = j > 0 ? list.get(j - 1) : list.getLast();
                    int nextDistance = current < next ? next - current : nums.length - current + next;
                    int prevDistance = current > prev ? current - prev : nums.length - prev + current;
                    res.add(Math.min(prevDistance, nextDistance));
                }
            }
        }
        return res;

    }

    public int maxSum(int[] nums) {
        int maxSum = 0;
        int maxNum = Integer.MIN_VALUE;
        HashSet<Integer> set = new HashSet<>();
        for (int num : nums) {
            maxNum = Math.max(maxNum, num);
            if (!set.contains(num) && num > 0) {
                set.add(num);
                maxSum += num;
            }
        }
        if(maxNum < 0) {
            return maxNum;
        }
        return maxSum;

    }
}

