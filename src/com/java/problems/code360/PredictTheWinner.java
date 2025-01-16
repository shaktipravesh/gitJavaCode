package com.java.problems.code360;

import java.util.ArrayList;

public class PredictTheWinner {
    public static void main(String[] args) {
//        System.out.println(predictTheWinner(4,3));
//        System.out.println(predictTheWinner(5,2));
//        System.out.println(predictTheWinner(6,1));

        for(int i = 1; i< 100; i++) {
            System.out.print(i + ": " +predictTheWinner(i,5) + ", ");
        }
//        System.out.println(predictTheWinner(5,1));
//        System.out.println(predictTheWinner(5,2));
//        System.out.println(predictTheWinner(5,3));
//        System.out.println(predictTheWinner(5,4));
//        System.out.println(predictTheWinner(5,5));
//        System.out.println(predictTheWinner(5,6));

    }

    public static int predictTheWinner(int n, int k) {
        ArrayList<Integer> numSet = new ArrayList<>();
        for(int i= 1; i <=n; i++) {
            numSet.add(i);
        }
        int currentPlayerPosition = 0;

        while(numSet.size() > 1) {
            int removeIndex = (currentPlayerPosition + k -1)%numSet.size();
            currentPlayerPosition = removeIndex;
            numSet.remove(removeIndex);
        }
        return numSet.get(0);

    }
}
