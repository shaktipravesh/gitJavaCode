package com.java;

import java.util.ArrayList;

/*
* Task is a String is given as an input, which contains only 'A', 'B', 'C', 'D' only.
* 'A' can be removed together with 'B' and 'C' can be removed together with 'D'
* "CCD" when "CD" will be removed then result will be "C".
* "CAABBCDDD" -> "CABCDDD" -> "CCDDD" ->  -> "CDD" ->  -> "D" So result will be "D"
* "CBCACBDA" here no 'AB' or "BA" or "CD" or "DC" are together so output will be "CBCACBDA"
* write an efficient code considering the sting length can be 2500000
* */
public class SyneChronCodilityTask1 {
    public static void main(String[] args) {
        String S = "CBABABDDC";
        System.out.println(solution(S));
    }
    static public String solution(String S) {
        if(S.length() < 2) {
            return S;
        }
        String result = "";
        StringBuilder res = new StringBuilder();
        ArrayList<Character> arrayList = new ArrayList<>();
        for (int i = 0; i < S.length(); i++) {
            if(arrayList.isEmpty()) {
                arrayList.add(S.charAt(i));
            } else {
                Character c = arrayList.get(arrayList.size() - 1);
                Character d = S.charAt(i);
                if((c == 'A' && d == 'B') || (c == 'B' && d == 'A') || (c == 'C' && d == 'D') || (c == 'D' && d == 'C')) {
                    arrayList.remove(arrayList.size() - 1);
                } else {
                    arrayList.add(d);
                }
            }
        }
        for(Character c : arrayList) {
            res.append(c);
        }
        return res.toString();
        /*
        int first = 0;
        int second = 1;
        char[] arr = S.toCharArray();
        while(second < arr.length) {
            if((arr[first] == 'A' && arr[second] == 'B')
                || (arr[first] == 'B' && arr[second] == 'A')
                || (arr[first] == 'C' && arr[second] == 'D')
                || (arr[first] == 'D' && arr[second] == 'C')) {
                arr[first] = 'E';
                arr[second] = 'E';
                first--;
                second++;
                if(first < 0) {
                    first = second;
                    second++;
                }
            } else {
                first = second;
                second++;
            }
        }
        for(int i = 0; i < arr.length; i++ ) {
            if(arr[i] != 'E') {
                result += arr[i];
            }
        }

        return result; */
    }
}
