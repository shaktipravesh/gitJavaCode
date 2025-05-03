package com.java.problems.code360.medium;

import java.util.*;

public class ShortestAlternatingPath {
    public static void main(String[] args) {
        int n = 3;
        int r = 1;
        int g = 1;
        int[][] redEdges = {{0, 1}};
        int[][] greenEdges = {{1, 2}};
        System.out.println(shortestAlternatingPath(n, r, g, redEdges, greenEdges).toString());
    }

    static class Pair {
        int node;
        int color; // 0 = RED, 1 = GREEN

        Pair(int node, int color) {
            this.node = node;
            this.color = color;
        }
    }

    public static int[] shortestAlternatingPath(int n, int r, int g, int[][] redEdges, int[][] greenEdges) {
        List<Integer>[] redGraph = new ArrayList[n];
        List<Integer>[] greenGraph = new ArrayList[n];

        for (int i = 0; i < n; i++) {
            redGraph[i] = new ArrayList<>();
            greenGraph[i] = new ArrayList<>();
        }

        for (int[] edge : redEdges) {
            redGraph[edge[0]].add(edge[1]);
        }

        for (int[] edge : greenEdges) {
            greenGraph[edge[0]].add(edge[1]);
        }

        int[][] dist = new int[n][2]; // dist[i][0] = RED, dist[i][1] = GREEN
        for (int[] d : dist) Arrays.fill(d, -1);
        dist[0][0] = 0;
        dist[0][1] = 0;

        Queue<Pair> q = new LinkedList<>();
        q.add(new Pair(0, 0)); // Start with RED
        q.add(new Pair(0, 1)); // Start with GREEN

        while (!q.isEmpty()) {
            Pair curr = q.poll();
            int node = curr.node;
            int color = curr.color;
            int nextColor = 1 - color;

            List<Integer>[] graph = (nextColor == 0) ? redGraph : greenGraph;
            for (int neighbor : graph[node]) {
                if (dist[neighbor][nextColor] == -1) {
                    dist[neighbor][nextColor] = dist[node][color] + 1;
                    q.add(new Pair(neighbor, nextColor));
                }
            }
        }

        int[] result = new int[n];
        for (int i = 0; i < n; i++) {
            if (dist[i][0] == -1 && dist[i][1] == -1)
                result[i] = -1;
            else if (dist[i][0] == -1)
                result[i] = dist[i][1];
            else if (dist[i][1] == -1)
                result[i] = dist[i][0];
            else
                result[i] = Math.min(dist[i][0], dist[i][1]);
        }

        return result;
    }

    public static int[] shortestAlternatingPathOld(int n, int r, int g, int[][] redEdges, int[][] greenEdges) {
        int[] shortestPath = new int[n];
        Arrays.fill(shortestPath, -1);
        shortestPath[0] = 0;
        TreeMap<Integer, TreeSet<Integer>> map = new TreeMap<>();
        addEdgeToMap(r, redEdges, map);
        addEdgeToMap(g, greenEdges, map);
        Queue<Integer> edgeList = new LinkedList<>();
        HashMap<Integer, Integer> processedEdges = new HashMap<>();
        processedEdges.put(0, 0);
        edgeList.offer(0);
        while(!edgeList.isEmpty()) {
            int vertices = edgeList.poll();
            int distance = shortestPath[vertices];
            if(map.containsKey(vertices)) {
                TreeSet<Integer> newEdgeList = map.get(vertices);
                for (Integer edge : newEdgeList) {
                    if (processedEdges.containsKey(edge)) {
                        continue;
                    }
                    processedEdges.put(edge, distance + 1);
                    shortestPath[edge] = distance + 1;
                    edgeList.offer(edge);
                }
            }
        }
        return shortestPath;
    }

    private static void addEdgeToMap(int r, int[][] redEdges, TreeMap<Integer, TreeSet<Integer>> map) {
        for (int i = 0; i < r; i++) {
            int[] edges = redEdges[i];
            if(map.containsKey(edges[0])) {
                TreeSet<Integer> set = map.get(edges[0]);
                set.add(edges[1]);
            } else {
                TreeSet<Integer> set = new TreeSet<>();
                set.add(edges[1]);
                map.put(edges[0], set);
            }
        }
    }
}
