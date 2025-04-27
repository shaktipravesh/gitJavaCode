package com.java.problems.code360.hard;

import java.util.*;

public class NinjaAndStops {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int iTCs = sc.nextInt();
        for (int j = 0; j < iTCs; j++) {
            int target = sc.nextInt();
            ArrayList<ArrayList<Integer>> stations = new ArrayList<>();
            int stops = sc.nextInt();
            int startFuel = sc.nextInt();
            for (int i = 0; i < stops; i++) {
                stations.add(new ArrayList<>(List.of(sc.nextInt(), sc.nextInt())));
            }
            System.out.println(minRefuelStops(target, startFuel, stations));
        }

    }

    public static int minRefuelStops(int target, int startFuel, ArrayList<ArrayList<Integer>> stations) {
        if(startFuel == 0) return -1;
        if(startFuel >= target) return 0;
        int stopTaken = 0;

        int currIndex = -1;
        int maxFuel = startFuel;
        HashMap<Integer, Integer> nthStoppageMap = new HashMap<>();
        HashMap<Integer, Integer> newStoppageMap = new HashMap<>();
        newStoppageMap.put(currIndex, startFuel);
        while(maxFuel < target) {
            stopTaken++;
            nthStoppageMap.clear();
            nthStoppageMap.putAll(newStoppageMap);
            newStoppageMap.clear();
            for (Map.Entry<Integer, Integer> entry : nthStoppageMap.entrySet()) {
                int index = entry.getKey();
                int fuel = entry.getValue();
                for (int i = index + 1; i < stations.size() && fuel >= stations.get(i).get(0); i++) {
                    ArrayList<Integer> station = stations.get(i);
                    int currFuel = station.get(1);
                    maxFuel = Math.max(maxFuel, currFuel+fuel);
                    if (maxFuel >= target) {
                        return stopTaken;
                    }
                    if (newStoppageMap.containsKey(i)) {
                        newStoppageMap.put(i, Math.max(newStoppageMap.get(i), maxFuel));
                    } else {
                        newStoppageMap.put(i, maxFuel);
                    }
                }
            }
            if(newStoppageMap.isEmpty()) {
                return -1;
            }
        }
        return stopTaken;
    }
}
