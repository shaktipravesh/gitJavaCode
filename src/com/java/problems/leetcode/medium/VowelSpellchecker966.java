package com.java.problems.leetcode.medium;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

public class VowelSpellchecker966 {
    public static void main(String[] args) {
        VowelSpellchecker966 v = new VowelSpellchecker966();
        String[]  wordlist = {"KiTe","kite","hare","Hare"};
        String[] queries = {"kite","Kite","KiTe","Hare","HARE","Hear","hear","keti","keet","keto"};
        System.out.println(v.spellchecker(wordlist, queries).toString());
    }
    public String[] spellchecker(String[] wordlist, String[] queries) {
        String[] queryResult = new String[queries.length];
        HashSet<String> directWords = new HashSet<>();
        HashMap<String, ArrayList<String>> capsWords = new HashMap<>();
        HashMap<String, ArrayList<String>> vowelCorrectedWords = new HashMap<>();
        for(int i = 0; i < wordlist.length; i++){
            String word = wordlist[i];
            String capsWord = word.toUpperCase();
            String vowelCorrectedWord = getVowelInsensitiveWord(word);
            directWords.add(word);
            if(capsWords.containsKey(capsWord)){
                capsWords.get(capsWord).add(word);
            } else {
                ArrayList<String> words = new ArrayList<>();
                words.add(word);
                capsWords.put(capsWord, words);
            }
            if(vowelCorrectedWords.containsKey(vowelCorrectedWord)){
                vowelCorrectedWords.get(vowelCorrectedWord).add(word);
            } else {
                ArrayList<String> words = new ArrayList<>();
                words.add(word);
                vowelCorrectedWords.put(vowelCorrectedWord, words);
            }
        }
        for(int i = 0; i < queries.length; i++){
            String query = queries[i];
            if(directWords.contains(query)){
                queryResult[i] = query;
            } else if(capsWords.containsKey(query.toUpperCase())){
                ArrayList<String> words = capsWords.get(query.toUpperCase());
                queryResult[i] = words.get(0);
            } else if(vowelCorrectedWords.containsKey(getVowelInsensitiveWord(query))){
                ArrayList<String> words = vowelCorrectedWords.get(getVowelInsensitiveWord(query));
                queryResult[i] = words.get(0);
            } else {
                queryResult[i] = "";
            }
        }
        return queryResult;
    }

    private String getVowelInsensitiveWord(String word) {
        char[] chars = word.toUpperCase().toCharArray();
        Set<Character> vowels = Set.of('a', 'e', 'i', 'o', 'u', 'A', 'E', 'I', 'O', 'U');
        for(int i = 0; i < chars.length; i++){
            if(vowels.contains(chars[i])){
                chars[i] = '*';
            }
        }
        return new String(chars);
    }
}
