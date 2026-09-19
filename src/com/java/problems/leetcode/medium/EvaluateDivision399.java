package com.java.problems.leetcode.medium;

import java.util.*;

public class EvaluateDivision399 {
    public static void main(String[] args) {
        EvaluateDivision399 evaluator = new EvaluateDivision399();

        List<List<String>> equations = Arrays.asList(
                Arrays.asList("a", "b"),
                Arrays.asList("b", "c")
        );
        double[] values = {2.0, 3.0};

        List<List<String>> queries = Arrays.asList(
                Arrays.asList("a", "c"),
                Arrays.asList("b", "a"),
                Arrays.asList("a", "e"),
                Arrays.asList("a", "a"),
                Arrays.asList("x", "x")
        );

        System.out.println(Arrays.toString(evaluator.calcEquation(equations, values, queries)));
        // Output: [6.0, 0.5, -1.0, 1.0, -1.0]
        List<List<String>> equations1 = Arrays.asList(
        Arrays.asList("a", "b"),
        Arrays.asList("b", "c"),
        Arrays.asList("bc", "cd"));

        values = new double[]{1.5, 2.5, 5.0};
        List<List<String>> queries1 = Arrays.asList(
                Arrays.asList("a","c"),
                Arrays.asList("c","b"),
                Arrays.asList("bc","cd"),
                Arrays.asList("cd","bc"));
        System.out.println(Arrays.toString(evaluator.calcEquation(equations1, values, queries1)));

    }

    // Build graph
    Map<String, Map<String, Double>> graph = new HashMap<>();
    public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
        // Construct the graph
        for (int i = 0; i < equations.size(); i++) {
            String a = equations.get(i).get(0);
            String b = equations.get(i).get(1);
            double val = values[i];

            graph.putIfAbsent(a, new HashMap<>());
            graph.putIfAbsent(b, new HashMap<>());
            graph.get(a).put(b, val);
            graph.get(b).put(a, 1.0 / val);
        }

        // Process queries
        double[] res = new double[queries.size()];
        for (int i = 0; i < queries.size(); i++) {
            String start = queries.get(i).get(0);
            String end = queries.get(i).get(1);
            Set<String> visited = new HashSet<>();
            res[i] = dfs(start, end, visited);
        }
        return res;
    }

    private double dfs(String start, String end, Set<String> visited) {
        if (!graph.containsKey(start) || !graph.containsKey(end))
            return -1.0;

        if (start.equals(end))
            return 1.0;

        visited.add(start);
        for (Map.Entry<String, Double> neighbor : graph.get(start).entrySet()) {
            String next = neighbor.getKey();
            if (visited.contains(next)) continue;
            double result = dfs(next, end, visited);
            if (result != -1.0) {
                return neighbor.getValue() * result;
            }
        }
        return -1.0;
    }
}
