package com.java;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.concurrent.atomic.AtomicBoolean;

public class NABQuestion2 {
    public static void main(String[] args) {
        String input = "bdaaadadb";
        int result = solution3(input);
        System.out.println(result);

    }
    public int solution(String S) {
        char[] input = S.toCharArray();
        char[] direction = {'>', '<', '^', 'v'};
        int result = 0;
        for(int i = 0; i < input.length; i++) {
            if(i == 0) {
                if(input[i] == '<' || input[i] == '^' || input[i] == 'v') {
                    result++;
                    input[i] = 0;
                }
            } else if(i < input.length-1){
                if(input[i] == '>' || input[i] == '^' || input[i] == 'v') {
                    result++;
                    input[i] = 0;
                }
            } else {
                if(input[i] == '^' || input[i] == 'v') {
                    result++;
                    input[i] = 0;
                } else if(input[i] == '<' && input[i-1] ==0) {
                    result++;
                    input[i] = 0;
                }
            }

        }
        return result;

    }

    public static int solution3(String S) {
        int longestEven = 0;
        String subString = "";

        ArrayList<Integer> input = new ArrayList();
        for(int i = 0; i < S.length(); i++) {
            int[] frequencyMap = new int[26];
            HashMap<Character, Integer> frequency = new HashMap();

            for(int j = i; j < S.length(); j++) {
                char currChar = S.charAt(j);
                frequencyMap[currChar-'a']++;
                frequency.put(currChar, frequency.getOrDefault(currChar, 1) + 1);
                AtomicBoolean isEven = new AtomicBoolean(true);
//                for(int a = 0; a < 26; a++) {
//                    if(frequencyMap[a] %2 != 0) {
//                        isEven.set(false);
//                        break;
//                    }
//                }
                frequency.entrySet().forEach(characterIntegerEntry -> {
                    if(characterIntegerEntry.getValue()%2 != 0) {
                        isEven.set(false);
                    }
                });
                if(isEven.get()) {
                    longestEven = Math.max(longestEven, j-i+1);
                }
            }
        }

        return longestEven;
    }

    public int[] solution(String[] S) {
        int first = 0; int second = 0;
        int index = 0;
        for(int i = 0; i < S.length; i++) {
            for(int j = 1; j < S.length; j++) {
                for(int k = 0; k < S[i].length(); k++) {
                    if(S[j].charAt(k) == S[i].charAt(k)) {
                        first = i;
                        second = j;
                        index = k;
                        break;
                    }
                }

            }
        }
        int[] result = {first, second, index};
        return result;
    }

}
