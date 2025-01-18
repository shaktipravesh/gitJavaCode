package com.java.problems.code360.medium;

import java.util.HashMap;
import java.util.Map;

public class RootTheString {
    private static int gcd(int a, int b) {
        if (b == 0) {
            return a;
        }
        return gcd(b, a % b);
    }
    public static int root(String s)
    {
        Map<Character, Integer> frequencyMap = new HashMap<>();

        // Count the frequency of each character
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            frequencyMap.put(ch, frequencyMap.getOrDefault(ch, 0) + 1);
        }

        int gcdValue = 0;

        // Calculate the GCD of all frequencies
        for (int freq : frequencyMap.values()) {
            gcdValue = gcd(gcdValue, freq);
        }

        return gcdValue;

    }
}
