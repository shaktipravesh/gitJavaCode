package com.java.problems.leetcode.medium;

import java.util.*;

public class DesignTaskManager3408 {
    public static void main(String[] args) {
//        List<List<Integer>> tasks = new ArrayList<>();
//
//        tasks.add(List.of(1, 101, 10));
//        tasks.add(List.of(2, 102, 20));
//        tasks.add(List.of(3, 103, 15));
//
//        TaskManager taskManager = new TaskManager(tasks); // Initializes with three tasks for Users 1, 2, and 3.
//        taskManager.add(4, 104, 5); // Adds task 104 with priority 5 for User 4.
//        taskManager.edit(102, 8); // Updates priority of task 102 to 8.
//        taskManager.execTop(); // return 3. Executes task 103 for User 3.
//        taskManager.rmv(101); // Removes task 101 from the system.
//        taskManager.add(5, 105, 15); // Adds task 105 with priority 15 for User 5.
//        taskManager.execTop(); // return 5. Executes task 105 for User 5.



//        List<List<Integer>> tasks = new ArrayList<>();
//
//        tasks.add(List.of(1,101,8));
//        tasks.add(List.of(2,102,20));
//        tasks.add(List.of(3,103,5));
//        TaskManager taskManager = new TaskManager(tasks);
//        taskManager.add(4,104,5);
//        taskManager.edit(102, 9);
//        System.out.println(taskManager.execTop());
//        taskManager.rmv(101);
//        taskManager.add(50,101,8);
//        System.out.println(taskManager.execTop());

//        ["TaskManager","edit","add","add","add","rmv","execTop","execTop","edit","execTop","edit","execTop","execTop","execTop","add","execTop","execTop"]
//[[[[3,26,44],[8,4,7],[3,21,7]]],[4,13],[6,10,2],[4,9,39],[2,0,40],[10],[],[],[9,41],[],[4,46],[],[],[],[8,3,24],[],[]]
//
        List<List<Integer>> tasks = new ArrayList<>();

        tasks.add(List.of(3,26,44));
        tasks.add(List.of(8,4,7));
        tasks.add(List.of(3,21,7));
        TaskManager taskManager = new TaskManager(tasks);
        taskManager.edit(4,13);

        taskManager.add(4,104,5);
        taskManager.edit(102, 9);
        System.out.println(taskManager.execTop());
        taskManager.rmv(101);
        taskManager.add(50,101,8);
        System.out.println(taskManager.execTop());
    }
}

class TaskManager {
    HashMap<Integer, Integer> taskIdUserIdMap = new HashMap<>();
    HashMap<Integer, Integer> tasksPriority = new HashMap<>();
    TreeMap<Integer, TreeSet<Integer>> priorityMap = new TreeMap<>();
    public TaskManager(List<List<Integer>> tasks) {
        for (List<Integer> task : tasks) {
            int userId = task.get(0);
            int taskId = task.get(1);
            int priority = task.get(2);
            add(userId, taskId, priority);
        }
    }

    public void add(int userId, int taskId, int priority) {
        taskIdUserIdMap.put(taskId, userId);
        tasksPriority.put(taskId, priority);
        TreeSet<Integer> taskIdSet;
        if (priorityMap.containsKey(priority)) {
            taskIdSet = priorityMap.get(priority);
        } else {
            taskIdSet = new TreeSet<>();
        }
        taskIdSet.add(taskId);
        priorityMap.put(priority, taskIdSet);
    }

    public void edit(int taskId, int newPriority) {
        int prevPriority = tasksPriority.get(taskId);
        tasksPriority.put(taskId, newPriority);
        TreeSet<Integer> prevTaskIdSet = priorityMap.get(prevPriority);
        prevTaskIdSet.remove(taskId);
        if (prevTaskIdSet.isEmpty()) {
            priorityMap.remove(prevPriority);
        }
        TreeSet<Integer> newTaskIdSet;
        if (priorityMap.containsKey(newPriority)) {
            newTaskIdSet = priorityMap.get(newPriority);
        } else {
            newTaskIdSet = new TreeSet<>();
        }
        newTaskIdSet.add(taskId);
        priorityMap.put(newPriority, newTaskIdSet);
    }

    public void rmv(int taskId) {
        int priority = tasksPriority.get(taskId);
        TreeSet<Integer> taskIdSet = priorityMap.get(priority);
        taskIdSet.remove(taskId);
        if (taskIdSet.isEmpty()) {
            priorityMap.remove(priority);
        } else {
            priorityMap.put(priority, taskIdSet);
        }
        tasksPriority.remove(taskId);
        taskIdUserIdMap.remove(taskId);
    }

    public int execTop() {
        if(priorityMap.isEmpty()) {
            return -1;
        }
        TreeSet<Integer> taskIdSet = priorityMap.lastEntry().getValue();
        int taskId = taskIdSet.last();
        int userId = taskIdUserIdMap.get(taskId);
        rmv(taskId);

        return userId;
    }
}