package com.java.problems.leetcode.hard;

import java.util.ArrayList;
import java.util.Collections;
import java.util.PriorityQueue;

public class FindMedianFromDataStream295 {
    public static void main(String[] args) {
        MedianFinder mf = new MedianFinder();
    }
}

class MedianFinder {

    PriorityQueue<Integer> maxHeap;
    PriorityQueue<Integer> minHeap;

    public MedianFinder() {
        maxHeap = new PriorityQueue<>(Collections.reverseOrder());
        minHeap = new PriorityQueue<>();
    }

    public void addNum(int num) {
        maxHeap.offer(num);

        if(!minHeap.isEmpty() && maxHeap.size() > minHeap.size()) {
            minHeap.offer(maxHeap.poll());
        }
        if(maxHeap.size() - minHeap.size() > 1) {
            minHeap.offer(maxHeap.poll());
        } else if(minHeap.size() > maxHeap.size()) {
            maxHeap.offer(minHeap.poll());
        }
    }

    public double findMedian() {
        if(minHeap.size() == maxHeap.size()) {
            return (maxHeap.peek() + minHeap.peek()) / 2.0;
        } else {
            return maxHeap.peek();
        }
    }
}

class MedianFinderBruteForce {

    ArrayList<Integer> list;
    public MedianFinderBruteForce() {
        list = new ArrayList<>();
    }

    public void addNum(int num) {
        list.add(num);
    }

    public double findMedian() {
        Collections.sort(list);
        if(list.size() % 2 == 0) {

            return ((double)list.get(list.size() / 2) + (double)list.get(list.size() / 2 - 1)) /2.0;
        } else {
            return list.get(list.size() / 2);
        }
    }
}