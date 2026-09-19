package com.java.problems.leetcode.medium;

import java.util.Arrays;

public class DestroyingAsteroids2126 {
    public static void main(String[] args) {
        DestroyingAsteroids2126 obj = new DestroyingAsteroids2126();
        int mass = 81583;
        int[] asteroids = {72478,59012,66499,90344,58277,41486,84287,70977,1129,33023,26908,89355,46395,91515,53392,47233,42981,54383,46299,32869,32276,17663,92520,76548,38646,81596,76809,63051,63640,53960,40674,61351,73937,67025,85034,31003,41705,70421,71408,23744,2213,34840,79697,43646,12652,10556,45459,54454,70632,21798,62071,98264,58491,59972,54153,74882,7611,42350,43064,40788,11219,3266,23484,30830,92999,27114,15240,46781,63855,74454,74979,60544,30450,90982,39235,68700,32479,16279,10885,63696,40429,35022,8722,25565,73733,12901,45226,59342,63,22736,34497,7475,79553,14244,40119,43259,58039,24329,34247,34634,64276,59676,72937,32623,99330,78211,89652,1595,96703,23523,56267,44675,15639,11944,64601,96978,83330};
        System.out.println(obj.asteroidsDestroyed(mass, asteroids));
    }
    public boolean asteroidsDestroyed(int mass, int[] asteroids) {
        Arrays.sort(asteroids);
        long currMass = mass;
        for (int asteroid : asteroids) {
            if (asteroid > currMass) {
                return false;
            }
            currMass += asteroid;
        }
        return true;
    }
}

