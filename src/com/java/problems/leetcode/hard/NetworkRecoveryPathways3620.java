package com.java.problems.leetcode.hard;

import java.util.*;

public class NetworkRecoveryPathways3620 {
    public int findMaxPathScore(int[][] edges, boolean[] online, long k) {
        int size = edges.length;
        record Edge(int to, int weight){}
        record Path(int min, long total){}

        Map<Integer, List<Edge>> graph = new HashMap<>();
        TreeMap<Integer, Path> pathsWeight = new TreeMap<>();
        for (int[] edge : edges) {
            graph.computeIfAbsent(edge[0], a -> new ArrayList<>())
                    .add(new Edge(edge[1], edge[2]));
        }
        if(online[0]) {
            List<Edge> edgeList = graph.get(0);
            for(Edge edge : edgeList) {
                if(edge.weight <= k) {
                    Path path;
                    if(pathsWeight.containsKey(edge.to)) {
                        path = pathsWeight.get(edge.to);
                    } else {
                        path = new Path(edge.to, edge.weight);
                        pathsWeight.put(edge.to, path);
                    }
                }
            }
            edgeList.add(edgeList.get(edgeList.size() - 1));
            edgeList.add(edgeList.get(edgeList.size() - 1));
        }
        return 0;
    }
}

