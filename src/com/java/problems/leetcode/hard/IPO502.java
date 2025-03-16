package com.java.problems.leetcode.hard;

import java.util.*;

import static java.lang.System.*;

public class IPO502 {
    public static void main(String[] args) {
        int k = 2;
        int w = 0;
        int[] profits = {1,2,3};
        int[] capital = {0,1,1};
        IPO502 ipo502 = new IPO502();
        out.println(ipo502.findMaximizedCapital(k, w, profits, capital));
        out.println(ipo502.findMaximizedCapitalBruteForce(k, w, profits, capital));
    }

    public int findMaximizedCapital(int k, int w, int[] profits, int[] capital) {
        int n = profits.length;

        // Step 1: Store (capital[i], profit[i]) and sort by capital
        int[][] projects = new int[n][2];
        for (int i = 0; i < n; i++) {
            projects[i] = new int[]{capital[i], profits[i]};
        }
        Arrays.sort(projects, Comparator.comparingInt(a -> a[0])); // Sort by capital

        // Step 2: Max heap for profits
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>((a, b) -> Integer.compare(b, a));

        int i = 0;
        while (k-- > 0) {
            // Step 3: Push all projects that can be started into maxHeap
            while (i < n && projects[i][0] <= w) {
                maxHeap.add(projects[i][1]);
                i++;
            }

            // Step 4: Pick most profitable project
            if (!maxHeap.isEmpty()) {
                w += maxHeap.poll();
            } else {
                break; // No more affordable projects
            }
        }
        return w;
    }
    public int findMaximizedCapitalBruteForce(int k, int w, int[] profits, int[] capital) {
        int maxProfit = w;
        List<IPO> ipoList = new ArrayList<>();
        for (int i = 0; i < profits.length; i++) {
            ipoList.add(new IPO(profits[i], capital[i]));
        }

        ipoList.sort((a, b) ->{
            if(a.profit == b.profit) {
                return a.capital - b.capital;
            }
            return b.profit - a.profit;
        });
        while(k > 0) {
            for(int i = 0; i < ipoList.size(); i++) {
                IPO ipo = ipoList.get(i);
                if(ipo.capital <= w) {
                    maxProfit += ipo.profit;
                    w += ipo.profit;
                    ipoList.remove(ipo);
                    break;
                }
            }
            k--;
        }

        return maxProfit;
    }

    static class IPO {
        int profit;
        int capital;

        public IPO(int profit, int capital) {
            this.profit = profit;
            this.capital = capital;
        }
    }

}

