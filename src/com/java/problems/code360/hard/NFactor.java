package com.java.problems.code360.hard;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class NFactor {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        ArrayList<ArrayList<Integer>> queries = new ArrayList<>();
        for (int i = 1; i <= n; i++) {
            ArrayList<Integer> query = new ArrayList<>(List.of(scanner.nextInt(), scanner.nextInt(), scanner.nextInt()));
            queries.add(query);
        }
        getNfactor(queries);
    }

    public static ArrayList<Integer> getNfactor(ArrayList<ArrayList<Integer>> queries) {
        int[] primeNumbers = {2, 3, 5, 7, 11, 13, 17, 19, 23, 29, 31, 37, 41, 43, 47, 53, 59, 61, 67, 71, 73, 79, 83, 89, 97};
        ArrayList<Integer> numberList = new ArrayList<>();
        int[] uniquePrimeFactor = new int[100000];
        for(int i=2; i <= 10000; i++) {
            if(uniquePrimeFactor[i] == 0) {
                for(int j = i; j <= 10000; j= j+i) {
                    uniquePrimeFactor[j]++;
                }
            }
        }

        for(ArrayList<Integer>query: queries) {
            int from = query.get(0);
            int to = query.get(1);
            int uniquePrime = query.get(2);
            int count = 0;
            while(from <= to) {
                if(uniquePrimeFactor[from] == uniquePrime){
                    count++;
                }
                from++;
            }
            numberList.add(count);
        }
        System.out.println(numberList);
        return numberList;

    }

}
