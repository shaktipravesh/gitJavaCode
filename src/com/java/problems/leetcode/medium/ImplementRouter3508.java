package com.java.problems.leetcode.medium;

import java.util.*;

import static com.java.problems.leetcode.hard.MaxPointsOnALine.getGCD;
import static java.lang.System.*;

public class ImplementRouter3508 {

    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);

        int iTCs = sc.nextInt();
        for (int iTC = 0; iTC < iTCs; iTC++) {
            int X = sc.nextInt();
            int Y = sc.nextInt();

            out.println(getGCD(X, Y));
        }
    }

    public static int getGCD(int x, int y) {
        if(y == 0) return x;
        return getGCD(y, x % y);
    }

//    public static void main(String[] args) {
//        Router router = new Router(3);
//        router.addPacket(1, 4, 90);
//        router.addPacket(2, 5, 90);
//        router.addPacket(1, 4, 90);
//        router.addPacket(3, 5, 95);
//        router.addPacket(4, 5, 105);
//        out.println(Arrays.toString(router.forwardPacket()));
//        router.addPacket(5, 2, 110);
//        out.println(router.getCount(5, 100, 110));

//        Router router = new Router(4);
//        router.addPacket(4,2,1);
//        router.addPacket(3,2,1);
//        out.println(router.getCount(2,1,1));

//        Router router = new Router(3);
//        router.addPacket(2,5,1);
//        out.println(Arrays.toString(router.forwardPacket()));
//        out.println(router.getCount(5,1,1));
//    }
}
class Router {

    private int memoryLimit;
    private Deque<int[]> queue; // stores [src, dest, ts] in FIFO
    private Set<String> seen;   // to detect duplicates
    private Map<Integer, List<Integer>> destMap; // dest -> timestamps (monotonic list)

    public Router(int memoryLimit) {
        this.memoryLimit = memoryLimit;
        this.queue = new ArrayDeque<>();
        this.seen = new HashSet<>();
        this.destMap = new HashMap<>();
    }

    public boolean addPacket(int source, int destination, int timestamp) {
        String key = source + "#" + destination + "#" + timestamp;
        if (seen.contains(key)) {
            return false; // duplicate
        }

        // Evict oldest if memory full
        if (queue.size() == memoryLimit) {
            int[] old = queue.pollFirst();
            String oldKey = old[0] + "#" + old[1] + "#" + old[2];
            seen.remove(oldKey);

            // Remove from destination list
            List<Integer> tsList = destMap.get(old[1]);
            if (tsList != null) {
                // timestamps are stored in increasing order, remove from front
                if (!tsList.isEmpty() && tsList.get(0) == old[2]) {
                    tsList.remove(0); // O(1) if LinkedList, O(n) if ArrayList
                }
            }
        }

        // Insert new packet
        queue.addLast(new int[]{source, destination, timestamp});
        seen.add(key);
        destMap.computeIfAbsent(destination, k -> new ArrayList<>()).add(timestamp);
        return true;
    }

    public int[] forwardPacket() {
        if (queue.isEmpty()) return new int[0];

        int[] old = queue.pollFirst();
        String oldKey = old[0] + "#" + old[1] + "#" + old[2];
        seen.remove(oldKey);

        List<Integer> tsList = destMap.get(old[1]);
        if (tsList != null && !tsList.isEmpty() && tsList.get(0) == old[2]) {
            tsList.remove(0);
        }

        return old;
    }

    public int getCount(int destination, int startTime, int endTime) {
        List<Integer> tsList = destMap.get(destination);
        if (tsList == null || tsList.isEmpty()) return 0;

        // Binary search for left and right boundaries
        int left = lowerBound(tsList, startTime);
        int right = upperBound(tsList, endTime);
        return right - left;
    }

    // First index >= target
    private int lowerBound(List<Integer> list, int target) {
        int lo = 0, hi = list.size();
        while (lo < hi) {
            int mid = (lo + hi) / 2;
            if (list.get(mid) >= target) hi = mid;
            else lo = mid + 1;
        }
        return lo;
    }

    // First index > target
    private int upperBound(List<Integer> list, int target) {
        int lo = 0, hi = list.size();
        while (lo < hi) {
            int mid = (lo + hi) / 2;
            if (list.get(mid) > target) hi = mid;
            else lo = mid + 1;
        }
        return lo;
    }
}

class RouterMy {

    int memoryLimit;
    ArrayList<Long> timePackets = new ArrayList<>();
    Long MOD = 100000L;
    HashMap<Integer, TreeSet<Long>> destinationTimeMap = new HashMap<>();
    HashMap<Integer, TreeMap<Integer, Integer>> destinationTimeCounterMap = new HashMap<>();
    public RouterMy(int memoryLimit) {
        this.memoryLimit = memoryLimit;
    }

    public boolean addPacket(int source, int destination, int timestamp) {
        Long timePacket = timestamp * MOD * MOD + destination * MOD + source;
        if (timePackets.contains(timePacket)) {
            return false;
        } else {
            if(timePackets.size() >= memoryLimit) {
                forwardPacket(); //remove first from all places
            }
            timePackets.add(timePacket);
            TreeSet<Long> timeSourceSet;
            TreeMap<Integer, Integer> timeCounterMap;
            if (destinationTimeMap.containsKey(destination)) {
                timeSourceSet = destinationTimeMap.get(destination);
                timeCounterMap = destinationTimeCounterMap.get(destination);
            }
            else {
                timeSourceSet = new TreeSet<>();
                timeCounterMap = new TreeMap<>();
            }
            Long timeSource = timestamp * MOD + source;
            timeSourceSet.add(timeSource);
            timeCounterMap.put(timestamp, timeCounterMap.getOrDefault(timestamp, 0) + 1);
            destinationTimeMap.put(destination, timeSourceSet);
            destinationTimeCounterMap.put(destination, timeCounterMap);

            return true;
        }
    }

    public int[] forwardPacket() {
        int[] result = new int[0];
        if(!timePackets.isEmpty()) {
            result = new int[3];
            Long timePacket = timePackets.getFirst();
            result = getPacketDetail(timePacket);

            //remove start
            timePackets.remove(timePacket);
            TreeSet<Long> timeSourceSet = destinationTimeMap.get(result[1]);
            Long timeSource = result[2] * MOD +result[0];
            timeSourceSet.remove(timeSource);
            if(timeSourceSet.isEmpty()) {
                destinationTimeMap.remove(result[1]);
            }
            TreeMap<Integer, Integer> timeCounterMap = destinationTimeCounterMap.get(result[1]);
            timeCounterMap.put(result[2], timeCounterMap.get(result[2]) - 1);
            if(timeCounterMap.get(result[2]) == 0) {
                timeCounterMap.remove(result[2]);
            }
            if(timeCounterMap.isEmpty()) {
                destinationTimeCounterMap.remove(result[1]);
            }
            //remove end

            return result;
        }
        return result;
    }

    public int getCount(int destination, int startTime, int endTime) {
        int count = 0;
        if(destinationTimeCounterMap.containsKey(destination)) {
            TreeMap<Integer, Integer> timeCounterMap = destinationTimeCounterMap.get(destination);
            for (Map.Entry<Integer, Integer> entry : timeCounterMap.entrySet()) {
                if(entry.getKey() >= startTime && entry.getKey() <= endTime) {
                    count += entry.getValue();
                }
                if(entry.getKey() > endTime) {
                    break;
                }
            }
        }
        return count;
    }

    public int[] getPacketDetail(Long timePacket) {
        int[] result = new int[3];
        result[0] = (int)(timePacket % (MOD));    // source
        result[1] = (int)((timePacket / MOD) % MOD);    //destination
        result[2] = (int)(timePacket / (MOD * MOD));   //time
        return result;
    }

}

/**
 * Your Router object will be instantiated and called as such:
 * Router obj = new Router(memoryLimit);
 * boolean param_1 = obj.addPacket(source,destination,timestamp);
 * int[] param_2 = obj.forwardPacket();
 * int param_3 = obj.getCount(destination,startTime,endTime);
 */
