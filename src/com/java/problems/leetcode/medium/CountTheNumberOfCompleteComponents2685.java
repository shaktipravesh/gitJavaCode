package problems.leetcode.medium;

import java.util.HashMap;
import java.util.HashSet;

public class CountTheNumberOfCompleteComponents2685 {
    public static void main(String[] args) {
        CountTheNumberOfCompleteComponents2685 completeComponents2685 = new CountTheNumberOfCompleteComponents2685();
//        int n = 6;
//        int[][] edges = {{0,1}, {0,2}, {1,2}, {3,4}};
        int n = 5;
        int[][] edges = {{2,0}, {3,0}, {4,1}, {4,2}, {4,3}};
        System.out.println(completeComponents2685.countCompleteComponents(n, edges));
    }
    public int countCompleteComponents(int n, int[][] edges) {
        // Maps each node to the connected component (network) it belongs to
        HashMap<Integer, HashSet<Integer>> networkMap = new HashMap<>();
        HashSet<Integer> visited = new HashSet<>();
        HashSet<HashSet<Integer>> distictNetwork = new HashSet<>();
        HashMap<Integer, HashSet<Integer>> nodeToNode = new HashMap<>();

        for (int i = 0; i < edges.length; i++) {
            int u = edges[i][0];
            int v = edges[i][1];
            visited.add(u);
            visited.add(v);
            nodeToNode.computeIfAbsent(u, k -> new HashSet<>()).add(v);
            nodeToNode.computeIfAbsent(v, k -> new HashSet<>()).add(u);

            HashSet<Integer> networkU = networkMap.get(u);
            HashSet<Integer> networkV = networkMap.get(v);

            if (networkU == null && networkV == null) {
                // Neither node belongs to a network
                HashSet<Integer> network = new HashSet<>();
                network.add(u);
                network.add(v);

                networkMap.put(u, network);
                networkMap.put(v, network);
                distictNetwork.add(network);
            } else if (networkU != null && networkV == null) {
                // Add v to u's network
                networkU.add(v);
                networkMap.put(v, networkU);
            } else if (networkU == null && networkV != null) {
                // Add u to v's network
                networkV.add(u);
                networkMap.put(u, networkV);
            } else if (networkU != networkV) {
                // Merge the two networks
                networkU.addAll(networkV);
                for (int node : networkV) {
                    networkMap.put(node, networkU);
                }
                distictNetwork.remove(networkV);
            }
        }
        int openNetwork = 0;
        for(HashSet<Integer> set: distictNetwork) {
            for(Integer num : set) {
                if(nodeToNode.get(num).size() != set.size() - 1){
                    openNetwork++;
                    break;
                }
            }
        }
        return distictNetwork.size() - openNetwork + n - visited.size();
    }
}
