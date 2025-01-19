package com.java.problems.code360.medium;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Map;

public class LastAppearance {

    public static Node lastAppearance(Node head) {
        if(head == null) {
            return head;
        }
        Node result = null;
        Node current = null;
        LinkedHashMap<Integer, Node> map = new LinkedHashMap<>();
        Node input = head;
        while(input != null) {
            Node node = input;
            if(map.containsKey(input.data)) {
                map.remove(input.data);
            }
            map.put(input.data, node);
            input = input.next;
        }
        for(Map.Entry<Integer, Node> mapElement : map.entrySet()) {
            if(result == null) {
                result = mapElement.getValue();
                current = result;
            } else {
                current.next = mapElement.getValue();
                current = current.next;
            }
        }
        current.next = null;
        return result;
    }

    class Node {
        int data;
        Node next;
        Node(int data) {
            this.data = data;
            this.next = null;
        }
    }
}
