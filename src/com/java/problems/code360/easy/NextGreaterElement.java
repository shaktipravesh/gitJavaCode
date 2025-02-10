package com.java.problems.code360.easy;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class NextGreaterElement {
    public static void main(String[] args) {
        ArrayList<Integer> list = new ArrayList<>(List.of(7, 5, 6, 12, 1, 20));
        ArrayList<Integer> result = nextGreaterElement(list, list.size());
        System.out.println(result);
    }
    public static ArrayList<Integer> nextGreaterElement(ArrayList<Integer> arr, int n)
    {
        ArrayList<Integer> nextGreaterElement = new ArrayList<>(Collections.nCopies(n, -1));
        ArrayList<Integer> tempList = new ArrayList<>();
        tempList.add(0);
        for(int i = 1; i < n; i++) {
            int tempNum = arr.get(i);
            while(!tempList.isEmpty() && tempNum > arr.get(tempList.getLast())) {
                nextGreaterElement.set( tempList.getLast(), tempNum);
                tempList.removeLast();
            }
            tempList.add(i);
        }
        return nextGreaterElement;
    }
}
