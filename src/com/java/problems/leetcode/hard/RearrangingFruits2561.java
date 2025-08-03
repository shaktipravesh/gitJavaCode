package com.java.problems.leetcode.hard;

import java.util.*;

public class RearrangingFruits2561 {
    public static void main(String[] args) {
        RearrangingFruits2561 rf = new RearrangingFruits2561();
        int[] basket1 = {84,80,43,8,80,88,43,14,100,88};
        int[] basket2 = {32,32,42,68,68,100,42,84,14,8};
        System.out.println(rf.minCost(basket1, basket2));
    }

    public long minCost(int[] basket1, int[] basket2) {
        long minCost = -1;
        long minFruitValue = Long.MAX_VALUE;
        HashMap<Integer, Integer> mapBasket1 = new HashMap<>(basket1.length);
        HashMap<Integer, Integer> mapBasket2 = new HashMap<>(basket2.length);
        for (int j : basket1) {
            mapBasket1.put(j, mapBasket1.getOrDefault(j, 0) + 1);
            minFruitValue = Math.min(minFruitValue, j);
        }

        for (int j : basket2) {
            minFruitValue = Math.min(minFruitValue, j);
            if (mapBasket1.containsKey(j)) {
                mapBasket1.put(j, mapBasket1.get(j) - 1);
                if (mapBasket1.get(j) == 0) {
                    mapBasket1.remove(j);
                }
            } else {
                mapBasket2.put(j, mapBasket2.getOrDefault(j, 0) + 1);
            }
        }
        List<Integer> listBasket1 = new ArrayList<>(basket1.length);
        List<Integer> listBasket2 = new ArrayList<>(basket1.length);

        for(Map.Entry<Integer, Integer> entry : mapBasket1.entrySet()) {
            if(entry.getValue() % 2 != 0) {
                return minCost;
            }
            for(int i = 0; i < entry.getValue() / 2; i++) {
                listBasket1.add(entry.getKey());
            }
        }
        for(Map.Entry<Integer, Integer> entry : mapBasket2.entrySet()) {
            if(entry.getValue() % 2 != 0) {
                return minCost;
            }
            for(int i = 0; i < entry.getValue() / 2; i++) {
                listBasket2.add(entry.getKey());
            }
        }
        minCost = 0;
        for (int i = 0; i < listBasket1.size(); i++) {
            minCost += Math.min(2*minFruitValue,  Math.min(listBasket1.get(i), listBasket2.get(i)));
        }
        return minCost;
    }
}
