package com.java.problems.code360.hard;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;
import java.util.Stack;

public class CountStronglyConnectedComponentsKosarajusAlgorithm {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int iTCs = sc.nextInt();
        for (int i = 0; i < iTCs; i++) {
            int v = sc.nextInt();
            int e = sc.nextInt();
            ArrayList<ArrayList<Integer>> edges = new ArrayList<>();
            for (int j = 0; j < e; j++) {
                edges.add(new ArrayList<>(Arrays.asList(sc.nextInt(), sc.nextInt())));
            }
            int sccCount = stronglyConnectedComponents(v, edges);
            System.out.println(i + ": Total Strongly Connected Components: " + sccCount);
        }
    }
    public static int stronglyConnectedComponents(int v, ArrayList<ArrayList<Integer>> edges) {
        int stronglyConnectedComponents = 0;
        ArrayList<ArrayList<Integer>> vEdgeList = new ArrayList<>();
        ArrayList<ArrayList<Integer>> vTransposeEdgeList = new ArrayList<>();
        for(int i = 0; i < v; i++) {
            vEdgeList.add(new ArrayList<>());
            vTransposeEdgeList.add(new ArrayList<>());
        }
        for (ArrayList<Integer> edge : edges) {
            vEdgeList.get(edge.get(0)).add(edge.get(1));
            vTransposeEdgeList.get(edge.get(1)).add(edge.get(0));
        }

        Stack<Integer> stack = new Stack<>();
        int[] visited = new int[v];
        int currentNode = 0;
        for(int i = 0; i < v; i++) {
            if(visited[i] == 0) {
                getDFS(vEdgeList, stack, visited, i);
            }
        }

        visited = new int[v];
        while(!stack.isEmpty()) {
            if(visited[stack.peek()] == 0) {
                stronglyConnectedComponents++;
                getConnectedCountDFS(vTransposeEdgeList, stack, visited, stack.pop());
            } else {
                stack.pop();
            }
        }
        //stronglyConnectedComponents = getConnectedCountDFS(vTransposeEdgeList, stack, visited, currentNode, stronglyConnectedComponents);
        return stronglyConnectedComponents;
    }

    private static void getConnectedCountDFS(ArrayList<ArrayList<Integer>> vEdgeList, Stack<Integer> stack, int[] visited, int currentNode) {
        ArrayList<Integer> edge = vEdgeList.get(currentNode);
        visited[currentNode] = 1;
        for (Integer integer : edge) {
            if (visited[integer] == 0) {
                getConnectedCountDFS(vEdgeList, stack, visited, integer);
            }
        }
    }

    private static int getConnectedCountDFS(ArrayList<ArrayList<Integer>> vEdgeList, Stack<Integer> stack, int[] visited, int currentNode, int stronglyConnectedComponents) {
        ArrayList<Integer> edge = vEdgeList.get(currentNode);
        visited[currentNode] = 1;
        for (Integer integer : edge) {
            if (visited[integer] == 0) {
                stronglyConnectedComponents = getConnectedCountDFS(vEdgeList, stack, visited, integer, stronglyConnectedComponents);
            }
        }
        while(!stack.isEmpty()) {
            if(visited[stack.peek()] == 0) {
                stronglyConnectedComponents++;
                stronglyConnectedComponents = getConnectedCountDFS(vEdgeList, stack, visited, stack.pop(), stronglyConnectedComponents);
                break;
            } else {
                stack.pop();
            }
        }
        return stronglyConnectedComponents;
    }

    private static void getDFS(ArrayList<ArrayList<Integer>> vEdgeList, Stack<Integer> stack, int[] visited, int currentNode) {
        ArrayList<Integer> edge = vEdgeList.get(currentNode);
        visited[currentNode] = 1;
        for (Integer integer : edge) {
            if (visited[integer] == 0) {
                getDFS(vEdgeList, stack, visited, integer);
            }
        }
        stack.push(currentNode);
    }

}

