package com.java.problems.leetcode.medium;

import java.util.LinkedHashMap;

public class LRUCache146 {
    LinkedHashMap<Integer,Integer> map = new LinkedHashMap<>();
    int capacity;
    public void LRUCache(int capacity) {
        this.capacity = capacity;
    }

    public int get(int key) {
        if(map.containsKey(key)) {
            int value = map.get(key);
            map.remove(key);
            map.put(key, value);
            return value;
        }
        return -1;
    }

    public void put(int key, int value) {
        if(!map.containsKey(key) && map.size() == capacity) {
            map.remove(map.keySet().iterator().next());
        }
        map.remove(key);
        map.put(key, value);
    }

    public static void main(String[] args) {
        //[[2],[1,1],[2,2],[1],[3,3],[2],[4,4],[1],[3],[4]]
        LRUCache146 lruCache = new LRUCache146();
        lruCache.LRUCache(2);
        lruCache.put(1, 1);
        lruCache.put(2, 2);
        lruCache.get(1);
        lruCache.put(3, 3);
        lruCache.get(2);
        lruCache.put(4, 4);
        lruCache.get(1);
        lruCache.get(3);
        lruCache.get(4);
        //[[2],[2,1],[1,1],[2,3],[4,1],[1],[2]]
        lruCache.LRUCache(2);
        lruCache.map.clear();
        lruCache.put(2, 1);
        lruCache.put(1, 1);
        lruCache.put(2, 3);
        lruCache.put(4, 1);
        lruCache.get(1);
        lruCache.get(2);


    }
}
