package com.java.problems.code360.medium;

import java.util.HashSet;

public class Day21CountConnectedLL {

    public static int countConnected(Node head, int[] arr, int m) {
        int countConnected = 0;
        HashSet<Integer> set = new HashSet<>();
        for (int j : arr) {
            set.add(j);
        }
        Node input = head;
        int start = 0;
        while(input != null) {
            if(set.contains(input.data)) {
                if(start == 0) {
                    countConnected++;
                }
                start++;
            } else {
                start = 0;
            }
            input = input.next;
        }
        return countConnected;
    }

    class Node
    {
        int data;
        Node next;
        Node(int data)
        {
            this.data = data;
            this.next = null;
        }
    };
}
