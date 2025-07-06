package com.java.problems.code360.hard;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class PhoneCode {
    public static void main(String[] args) {
        ArrayList<String> Words = new ArrayList<>(List.of("used", "code", "ride", "tree", "boed"));
        String Sequence = "2633";
        int W = 5;
        ArrayList<String> validWords = phoneCode(Words, Sequence, W);
        System.out.println(validWords);

    }
    public static ArrayList<String> phoneCode(ArrayList<String> Words, String Sequence, int W)
    {
        ArrayList<String> validWords = new ArrayList<>();
        HashMap<Character, Character> map = getCharacterCharacterHashMap();
        for(int i = 0; i < W; i++) {
            String word = Words.get(i);
            if( word.length() != Sequence.length() ) {
                continue;
            }
            boolean valid = true;
            for(int j = 0; j < word.length(); j++) {
                char ch = map.get(word.charAt(j));
                char seq = Sequence.charAt(j);
                if( ch != seq ) {
                    valid = false;
                    break;
                }
            }
            if( valid ) {
                validWords.add(word);
            }
        }
        return validWords;
    }

    private static HashMap<Character, Character> getCharacterCharacterHashMap() {
        HashMap<Character, Character> map = new HashMap<>();
        map.put('a', '2');
        map.put('b', '2');
        map.put('c', '2');
        map.put('d', '3');
        map.put('e', '3');
        map.put('f', '3');
        map.put('g', '4');
        map.put('h', '4');
        map.put('i', '4');
        map.put('j', '5');
        map.put('k', '5');
        map.put('l', '5');
        map.put('m', '6');
        map.put('n', '6');
        map.put('o', '6');
        map.put('p', '7');
        map.put('q', '7');
        map.put('r', '7');
        map.put('s', '7');
        map.put('t', '8');
        map.put('u', '8');
        map.put('v', '8');
        map.put('w', '9');
        map.put('x', '9');
        map.put('y', '9');
        map.put('z', '9');
        return map;
    }
}
