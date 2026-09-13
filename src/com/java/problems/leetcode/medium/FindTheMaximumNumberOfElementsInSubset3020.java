package problems.leetcode.medium;

import java.util.HashMap;
import java.util.TreeSet;

public class FindTheMaximumNumberOfElementsInSubset3020 {
    public static void main(String[] args) {
        FindTheMaximumNumberOfElementsInSubset3020 maxLengthSUbSet = new FindTheMaximumNumberOfElementsInSubset3020();
//        int[] nums = {1,1,1,1,1,1,1,1,1,1,2,4,8,16,32,64,128,256,512,1024};
        int[] nums = {1,1};
        System.out.println(maxLengthSUbSet.maximumLength(nums));
    }
    public int maximumLength(int[] nums) {
        int maxLength = 1;
        TreeSet<Integer> numSet = new TreeSet<>();
        HashMap<Integer, Integer> numCount = new HashMap<>();
        HashMap<Integer, Integer> numSubSetDepth = new HashMap<>();
        for(int num : nums) {
            numCount.put(num, numCount.getOrDefault(num, 0) + 1);
            numSubSetDepth.put(num, 1);
            numSet.add(num);
        }
        var iterator = numSet.iterator();
        while(iterator.hasNext()) {
            int num = iterator.next();
            if(num == 1) {
                maxLength = Math.max(maxLength, numCount.get(num)%2 == 0? numCount.get(num) - 1 : numCount.get(num));
            } else if((numCount.get(num) >= 2) && numCount.containsKey(num*num)) {
                numSubSetDepth.put(num*num, numSubSetDepth.get(num) + 2);
                maxLength = Math.max(maxLength, numSubSetDepth.get(num) + 2);
            }
        }
        return maxLength;
    }
}
