package com.java.problems.code360;

import java.util.ArrayList;
import java.util.HashSet;

public class PRETTYJSON {
    public static void main(String[] args) {
        //String str = "\"{A:\"B\",C:{D:\"E\",F:{G:\"H\",I:\"J\"}}}\"";
        //ArrayList<String> prettyJSON = prettyJSON(str);
        String str = "[\"foo\",{\"bar\":[\"baz\",null,1.0,2]}]";
        ArrayList<String> prettyJSON = prettyJSON(str);
        for (String s : prettyJSON) {
            System.out.println(s);
        }
    }
    public static ArrayList<String> prettyJSON(String str) {
        ArrayList<String> prettyJsonStr = new ArrayList<>();
        HashSet<Character> newLineBeforeIdentifier = new HashSet<>();
        HashSet<Character> setTabAdd = new HashSet<>();
        HashSet<Character> setTabReduce = new HashSet<>();
        setTabAdd.add('[');
        setTabAdd.add('{');
        setTabReduce.add(']'); setTabReduce.add('}');
        newLineBeforeIdentifier.addAll(setTabAdd);
        newLineBeforeIdentifier.addAll(setTabReduce);
        HashSet<Character> newLineAfterIdentifier = new HashSet<>(newLineBeforeIdentifier);
        newLineAfterIdentifier.add(',');

        int tabCounter = 0;
        String lineStr = "";
        for(int i = 0; i < str.length(); i++) {
            if(newLineBeforeIdentifier.contains(str.charAt(i))) {
                if(!lineStr.isEmpty() && !lineStr.trim().isEmpty()) {
                    prettyJsonStr.add(lineStr);
                }
                if(setTabReduce.contains(str.charAt(i))) {
                    tabCounter--;
                }
                lineStr = getSubString(tabCounter);
            }
            if(newLineAfterIdentifier.contains(str.charAt(i))) {
                lineStr += str.charAt(i);
                if(!lineStr.trim().isEmpty()) {
                    prettyJsonStr.add(lineStr);
                }
                if(setTabAdd.contains(str.charAt(i))) {
                    tabCounter++;
                }
                lineStr = getSubString(tabCounter);
            } else {
                lineStr += str.charAt(i);
            }
        }

        if(!lineStr.isEmpty() && !lineStr.trim().isEmpty()) {
            prettyJsonStr.add(lineStr);
        }
        return prettyJsonStr;
    }

    private static String getSubString(int tabCounter) {
        String resultStr = "";
        for(int i = 0; i < tabCounter; i++) {
            resultStr +="	";
        }
        resultStr += "";
        return resultStr;
    }

    private static String getSubStringJava8(int tabCounter, String str) {
        return "\t".repeat(Math.max(0, tabCounter)) + str;
    }
}
