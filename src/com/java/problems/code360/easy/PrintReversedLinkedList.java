package com.java.problems.code360.easy;

public class PrintReversedLinkedList {


    public static void printReverse(Node<Integer> root) {
        if(root != null ) {
            printReverse(root.next);
            System.out.println(root.data + " ");
        }
    }

    class Node<T> {
        T data;
        Node<T> next;

        public Node(T data) {
            this.data = data;
        }
    }
}
