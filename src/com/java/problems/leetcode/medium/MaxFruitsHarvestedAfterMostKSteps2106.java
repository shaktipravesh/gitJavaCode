package com.java.problems.leetcode.medium;

public class MaxFruitsHarvestedAfterMostKSteps2106 {
    public static void main(String[] args) {
        MaxFruitsHarvestedAfterMostKSteps2106 maxFruitHarvested = new MaxFruitsHarvestedAfterMostKSteps2106();
        int[][] fruits = {{0,9},{4,1},{5,7},{6,2},{7,4},{10,9}};
        int startPos = 5;
        int k = 4;
        maxFruitHarvested.maxTotalFruits(fruits, startPos, k);

        int[][] fruits1 = {{2,8},{6,3},{8,6}};
        startPos = 5;
        k = 4;
        maxFruitHarvested.maxTotalFruits(fruits1, startPos, k);
    }

    public int maxTotalFruits(int[][] fruits, int startPos, int k) {
        int maxFruitsCollected = 0;
        int maxIndex = fruits[fruits.length-1][0];
        int[] maxFruitsCollectAtPos = new int[maxIndex+1];
        int startPosInFruits = 0;
        for (int i = 0; i < fruits.length; i++) {
            if(startPos >= fruits[i][0]) {
                startPosInFruits = i;
            } else {
                break;
            }
        }
        for(int i = startPosInFruits+1, j = startPos+1, maxFruitCollect = 0; j <= maxIndex && j <= startPos + k; j++) {
            if(fruits[i][0] == j) {
                maxFruitCollect += fruits[i][1];
                i++;
            }
            maxFruitsCollectAtPos[j] = maxFruitCollect;
        }
        for(int i = startPosInFruits, j = startPos, maxFruitCollect = 0; j >= 0 && i >= 0; j--) {
            if(fruits[i][0] == j) {
                maxFruitCollect += fruits[i][1];
                i--;
            }
            maxFruitsCollectAtPos[j] = maxFruitCollect;
        }
        for(int i = 0; i < fruits.length; i++) {
            int fruitCollect = 0;
            int left = fruits[i][0];
            if(left >= startPos - k && left <= startPos + k) {
                int right1 = startPos + (k - (startPos - left) * 2);
                int right2 = startPos + (k - (startPos - left)) / 2;
                int right = Math.max(right1, right2);
                right = Math.min(right, maxIndex);
                if(left <= startPos)
                    fruitCollect = maxFruitsCollectAtPos[left];
                if(right > startPos) {
                    fruitCollect += maxFruitsCollectAtPos[right];
                }
                maxFruitsCollected = Math.max(maxFruitsCollected, fruitCollect);
            }
        }

        return maxFruitsCollected;
    }
}
