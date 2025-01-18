package com.java.problems.code360.easy;

import java.util.ArrayList;
import java.util.Collections;

public class LeadersInAnArray {
    public static void main(String[] args) {

    }

    public static ArrayList<Integer> findLeaders(ArrayList<Integer> elements, int n) {
        ArrayList<Integer> leaders = new ArrayList<>();
        Integer leader = elements.getLast();
        leaders.add(leader);
        for (int i = elements.size()-2; i >= 0; i--) {
            if(elements.get(i) > leader) {
                leaders.add(elements.get(i));
            }
        }
        Collections.reverse(leaders);
        return leaders;
    }
}
