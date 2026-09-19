package com.java.problems.leetcode.medium;

import java.util.*;

public class RemoveMethodsFromProject3310 {
    public static void main(String[] args) {
        RemoveMethodsFromProject3310 obj = new RemoveMethodsFromProject3310();
//        int n = 3;
//        int k = 2;
//        int[][] invocations = {{1,2}, {0,1}, {2,0}};
        int n = 4;
        int k = 1;
        int[][] invocations = {{1,2}, {0,1}, {3,2}};
        System.out.println(obj.remainingMethods(n, k, invocations));
    }
    public List<Integer> remainingMethods(int n, int k, int[][] invocations) {
        Stack<Integer> removals = new Stack<>();
        HashSet<Integer> used = new HashSet<>();
        HashSet<Integer> result = new HashSet<>();
        HashMap<Integer, ArrayList<Integer>> nodeToMap = new HashMap<>();
        HashMap<Integer, ArrayList<Integer>> nodeFromMap = new HashMap<>();
        for (int[] invocation : invocations) {
            int fromNode = invocation[0];
            int toNode = invocation[1];
            if (!nodeToMap.containsKey(fromNode)) {
                nodeToMap.put(fromNode, new ArrayList<>());
            }
            if (!nodeFromMap.containsKey(toNode)) {
                nodeFromMap.put(toNode, new ArrayList<>());
            }
            nodeToMap.get(fromNode).add(toNode);
            nodeFromMap.get(toNode).add(fromNode);
            used.add(toNode);
            if(!used.contains(fromNode)) {
                removals.add(fromNode);
            }
            if(removals.contains(toNode)) {
                removals.remove(toNode);
            }
        }
        while (!removals.isEmpty()) {
            int node = removals.pop();
            result.add(node);
            List<Integer> children = nodeFromMap.get(node);
            for (Integer child : children) {
                nodeFromMap.get(child).remove(node);
                if(nodeFromMap.get(child).size() == 0) {
                    removals.add(child);
                }
            }
        }

        return new ArrayList<>(result);
    }
}
