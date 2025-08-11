package com.java.problems.leetcode.medium;

import java.util.HashMap;

public class FruitIntoBaskets904 {
    public static void main(String[] args) {
        FruitIntoBaskets904 fruitIntoBaskets904 = new FruitIntoBaskets904();
        int[] fruits = {1,2,3,2,2};
        System.out.println(fruitIntoBaskets904.totalFruit(fruits));
    }

    public int totalFruit(int[] fruits) {
        HashMap<Integer, Integer> mapFruits = new HashMap<>();
        int totalFruitPick;
        int maxFruitPick = 0;
        int startIndex = 0;
        int endIndex = 0;
        for (int fruit : fruits) {
            while(!mapFruits.containsKey(fruit) && mapFruits.size() >= 2) {
                mapFruits.put(fruits[startIndex], mapFruits.get(fruits[startIndex]) - 1);
                if(mapFruits.get(fruits[startIndex]) == 0) {
                    mapFruits.remove(fruits[startIndex]);
                }
                startIndex++;
            }
            mapFruits.put(fruit, mapFruits.getOrDefault(fruit, 0) + 1);
            totalFruitPick = endIndex - startIndex + 1;
            maxFruitPick = Math.max(maxFruitPick, totalFruitPick);
            endIndex++;
        }
        return maxFruitPick;
    }
}
