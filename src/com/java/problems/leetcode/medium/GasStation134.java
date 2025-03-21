package com.java.problems.leetcode.medium;

import static java.lang.System.*;

public class GasStation134 {
    public static void main(String[] args) {
        int[] gas = {5,1,2,3,4};
        int[] cost = {4,4,1,5,1};
        GasStation134 gasStation134 = new GasStation134();
        out.println(gasStation134.canCompleteCircuit(gas, cost));
    }
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int totalGas = 0;
        int totalCost = 0;
        int tank = 0;
        int start = 0;

        for (int i = 0; i < gas.length; i++) {
            totalGas += gas[i];
            totalCost += cost[i];
            tank += gas[i] - cost[i];

            // If tank is negative, reset start position
            if (tank < 0) {
                start = i + 1;
                tank = 0;
            }
        }

        return totalGas < totalCost ? -1 : start;
    }
}
