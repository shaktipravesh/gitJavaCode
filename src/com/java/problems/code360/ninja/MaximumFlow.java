package com.java.problems.code360.ninja;

import java.util.*;

public class MaximumFlow {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int iTCs = in.nextInt();
        for (int iTC = 0; iTC < iTCs; iTC++) {
            int nodes = in.nextInt();
            int pipeCount = in.nextInt();
            ArrayList<ArrayList<Integer>> pipes = new ArrayList<>();
            for (int i = 0; i < pipeCount; i++) {
                int from = in.nextInt();
                int to = in.nextInt();
                int thickness = in.nextInt();
                ArrayList<Integer> pipe = new ArrayList();
                pipe.add(from);
                pipe.add(to);
                pipe.add(thickness);
                pipes.add(pipe);
            }
            findMaxFlow(nodes, pipeCount, pipes);

        }

    }
    public static int findMaxFlow(int n, int m, ArrayList<ArrayList<Integer>> pipes) {
        int[][] matrix = new int[n+1][n+1];
        TreeMap<Integer, TreeMap<Integer, Integer>> flowTree = new TreeMap<>();
        ArrayList<TreeSet<Integer>> flow = new ArrayList<>();
        for(ArrayList<Integer> pipe : pipes) {
            int from = pipe.get(0);
            int to = pipe.get(1);
            int thickness = pipe.get(2);
            matrix[from][to] = Math.max(matrix[from][to], thickness);
            if(flowTree.containsKey(from)) {
                TreeMap<Integer, Integer> toTree = flowTree.get(from);
                if(toTree.containsKey(to)) {
                    toTree.put(to, Math.max(toTree.get(to), thickness));
                } else {
                    toTree.put(to, thickness);
                }
            } else {
                TreeMap<Integer, Integer> toTree = new TreeMap<>();
                toTree.put(to, thickness);
                flowTree.put(from, toTree);
            }
        }
        int[] visited = new int[n+1];
        int[] maxFlowRecord = new int[n+1];
        visited[1] = 1;
        int pipeNumber = 1;
        int maxFlow = Integer.MAX_VALUE;
        getMaxFlow(flowTree, visited, maxFlowRecord, pipeNumber, maxFlow);
        return maxFlowRecord[n];
    }

    private static void getMaxFlow(TreeMap<Integer, TreeMap<Integer, Integer>> flowTree, int[] visited, int[] maxFlowRecord, int pipeNumber, int maxFlow) {
        if(flowTree.containsKey(pipeNumber)) {
            TreeMap<Integer, Integer> fromPipes = flowTree.get(pipeNumber);
            for(Map.Entry<Integer, Integer> entry : fromPipes.entrySet()) {
                int from = entry.getKey();
                visited[from] = 1;
                int flow = Math.min(entry.getValue(), maxFlow);
                if(maxFlowRecord[from] < flow) {
                    maxFlowRecord[from] = Math.max(maxFlowRecord[from], flow);
                    getMaxFlow(flowTree, visited, maxFlowRecord, from, flow);
                }
            }
        }
    }
}
