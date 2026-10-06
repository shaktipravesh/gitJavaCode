package com.java.problems.leetcode.medium;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

public class GenerateParentheses22 {

    public List<String> generateParenthesis(int n) {
        HashMap<Integer, List<String>> map = new HashMap<>();
        List<String> list = new ArrayList<>();
        list.add("");
        map.put(0, list);
        for (int i = 1; i <= n; i++) {
            List<String> preList = map.get(i - 1);
            HashSet<String> curList = new HashSet<>();
            for (int j = 0; j < preList.size(); j++) {
                String s = preList.get(j);
                curList.add("()" + s);
                curList.add(s + "()");
                curList.add("(" + s + ")" );
            }
            map.put(i, curList.stream().toList());
        }
        return map.get(n);
    }
    public int minAddToMakeValid(String s) {
        int minAdd = 0;
        int valid = 0;
        for(int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if(c == '(') {
                valid++;
            } else if(c == ')') {
                if(valid == 0) {
                    minAdd++;
                } else {
                    valid--;
                }
            }
        }
        minAdd += valid;
        return minAdd;

    }

}
