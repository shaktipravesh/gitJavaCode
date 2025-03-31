package com.java.problems.leetcode.medium;

import java.util.*;

import static java.lang.System.*;

public class InsertDeleteGetRandomO1380 {
    public static void main(String[] args) {
        InsertDeleteGetRandomO1380 ins = new InsertDeleteGetRandomO1380();

        RandomizedSet randomizedSet = ins.new RandomizedSet();
        out.println(randomizedSet.insert(1));
        out.println(randomizedSet.remove(2));
        out.println(randomizedSet.insert(2));
        out.println(randomizedSet.getRandom());
        out.println(randomizedSet.remove(1));
        out.println(randomizedSet.insert(2));
        out.println(randomizedSet.getRandom());
    }

    class RandomizedSet {
        HashSet<Integer> numberHSet;
        /** Initialize your data structure here. */
        public RandomizedSet() {
            numberHSet = new HashSet<Integer>();
        }

        /** Inserts a value to the set. Returns true if the set did not already contain the specified element. */
        public boolean insert(int val) {
            boolean result = false;
            if(!numberHSet.contains(val)) {
                numberHSet.add(val);
                result = true;
            }
            return result;
        }

        /** Removes a value from the set. Returns true if the set contained the specified element. */
        public boolean remove(int val) {
            boolean result = false;
            if(numberHSet.contains(val)) {
                numberHSet.remove(val);
                result = true;
            }
            return result;
        }

        /** Get a random element from the set. */
        public int getRandom() {
            int result = 0;
            int item = new Random().nextInt(numberHSet.size());
            Iterator<Integer> iter = numberHSet.iterator();
            for (int i = 0; i <= item; i++) {
                result = iter.next();
            }
            return result;
        }
    }
    /*
    static class RandomizedSet {

        private Map<Integer, Integer> map;
        private Random rand;
        public RandomizedSet() {
            map = new HashMap<>();
            rand = new Random();
        }

        public boolean insert(int val) {
            if (map.containsKey(val)) {
                return false;
            }
            map.put(val, map.getOrDefault(val, 0) + 1);
            return true;
        }

        public boolean remove(int val) {
            if (!map.containsKey(val)) {
                return false;
            }
            map.remove(val);
            return true;
        }

        public int getRandom() {
            int randomIndex = rand.nextInt(map.size());
            randomIndex = randomIndex == map.size() ? randomIndex -1 : randomIndex;
            return map.get(randomIndex);
        }
    }

     */

//    class RandomizedSet {
//        RandomizedSet randomizedSet;
//        public RandomizedSet() {
//            randomizedSet = new RandomizedSet();
//        }
//
//        public boolean insert(int val) {
//            return randomizedSet.insert(val);
//        }
//
//        public boolean remove(int val) {
//            return randomizedSet.remove(val);
//        }
//
//        public int getRandom() {
//            return randomizedSet.getRandom();
//        }
//    }
}
