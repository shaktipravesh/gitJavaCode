package com.java.problems.code360.easy;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class SearchInTheArray {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int iTCs = sc.nextInt();
        for(int i = 0; i < iTCs; i++) {
            int n = sc.nextInt();
            int q = sc.nextInt();
            ArrayList<Integer> arr = new ArrayList<>();
            for(int j = 0; j < n; j++) {
                arr.add(sc.nextInt());
            }
            ArrayList<Integer> queries = new ArrayList<>();
            for(int j = 0; j < q; j++) {
                queries.add(sc.nextInt());
            }
            System.out.println(searchInTheArray(arr, queries, n, q));
        }

        ArrayList<Integer> arr = new ArrayList<>(List.of( 2, 3, 3, 4, 6, 7));
        ArrayList<Integer> queries = new ArrayList<>(List.of(3, 6, 7));
        System.out.println(searchInTheArray(arr, queries, 6, 3));


    }

    public static ArrayList<Integer> searchInTheArray(ArrayList<Integer> arr, ArrayList<Integer> queries, int n, int q) {
        ArrayList<Integer> result = new ArrayList<>();
        ArrayList<Integer> arrSum = new ArrayList<>();
        arrSum.add(arr.getFirst());
        for(int i = 1; i < arr.size(); i++) {
            arrSum.add(arr.get(i) + arrSum.get(i-1));
        }
        for(int iQuery = 0; iQuery < queries.size() ; iQuery++) {
            int iArr = 0;
            while(iArr < arr.size() && arr.get(iArr) <= queries.get(iQuery)) {
                iArr++;
            }
            if(iArr > 0) {
                result.add(arrSum.get(iArr - 1));
            }
        }
        return result;
    }
}
