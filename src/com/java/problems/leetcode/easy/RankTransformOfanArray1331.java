package problems.leetcode.easy;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;

public class RankTransformOfanArray1331 {
    public static void main(String[] args) {
        RankTransformOfanArray1331 array1331 = new RankTransformOfanArray1331();
        int[] arr = {40,10,20,30};
        System.out.println(array1331.arrayRankTransform(arr));
    }
    public int[] arrayRankTransform(int[] arr) {
        ArrayList<Integer> uniqueArr = new ArrayList<>();
        HashMap<Integer, Integer> numRankMap = new HashMap<>();
        for(int i = 0; i < arr.length; i++) {
            if(!numRankMap.containsKey(arr[i])) {
                uniqueArr.add(arr[i]);
                numRankMap.put(arr[i], 0);
            }
        }
        Collections.sort(uniqueArr);
        for(int i = 0; i < uniqueArr.size(); i++) {
            numRankMap.put(uniqueArr.get(i), i+1);
        }
        for(int i = 0; i < arr.length; i++) {
            arr[i] = numRankMap.get(arr[i]);
        }
        return arr;
    }
}
