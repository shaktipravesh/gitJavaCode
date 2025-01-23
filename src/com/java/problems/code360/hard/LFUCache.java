package com.java.problems.code360.hard;

import java.util.LinkedHashMap;

public class LFUCache {
    LinkedHashMap<Integer, Integer> lfu = new LinkedHashMap<>();
    int capacity;
    LFUCache(int capacity) {
        this.capacity = capacity;
    }

    int get(int key) {
        return lfu.getOrDefault(key, -1);
    }

    void put(int key, int value) {
        if(lfu.containsKey(key)) {
            lfu.remove(key);
        } else {
            if(lfu.size() == capacity) {
                int first = lfu.keySet().iterator().next();
                lfu.remove(first);
            }
        }
        lfu.put(key, value);
    }
}
