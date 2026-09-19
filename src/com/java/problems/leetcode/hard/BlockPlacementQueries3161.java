package com.java.problems.leetcode.hard;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.TreeSet;

public class BlockPlacementQueries3161 {
    public static void main(String[] args) {
        BlockPlacementQueries3161 test = new BlockPlacementQueries3161();
        int[][] queries = {{1,2},{2,3,3},{2,3,1},{2,2,2}};
//        int[][] queries = {{1,1},{2,4,3}};
        List<Boolean> result = test.getResults(queries);
        System.out.println(result);
    }
    public List<Boolean> getResults(int[][] queries) {
        List<Boolean> result = new ArrayList<>();
//        TreeSet<Integer> blocks = new TreeSet<>()
//        blocks.add(0);
//        blocks.add(Integer.MAX_VALUE);
//        for (int[] query : queries) {
//            if(query[0] == 1) {
//                blocks.add(query[1]);
//            } else {
//                boolean isBlockPossible = false;
//                for(int i = 0; i < blocks.size(); i++) {
//                    if(i == 0) {
//                        if((blocks.getFirst() >= query[2]) && (blocks.getFirst() <= query[1])) {
//                            isBlockPossible = true;
//                            break;
//                        }
//                    } else {
//                        int gapSize = blocks.get(i) - blocks.get(i-1);
//                        if((gapSize >= query[2]) && (blocks.get(i-1) + query[2] <= query[1])) {
//                            isBlockPossible = true;
//                            break;
//                        }
//                    }
//                }
//                result.add(isBlockPossible);
//            }
//        }
        return result;
    }
}
