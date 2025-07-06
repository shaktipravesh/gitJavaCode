package com.java.problems.code360.hard;

public class ReverseListInKGroups {
    static class Node {
        public int data;
        public Node next;

        Node()
        {
            this.data = 0;
            this.next = null;
        }

        Node(int data)
        {
            this.data = data;
            this.next = null;
        }

        Node(int data, Node next)
        {
            this.data = data;
            this.next = next;
        }
    }

    public static Node kReverse(Node head, int k) {
        Node prev=null;
        Node curr=head;
        Node forward=null;
        int count =0;

        while(curr!=null&&count<k)
        {
            forward=curr.next;
            curr.next=prev;
            prev=curr;
            curr=forward;

            count++;
        }
        if(count<k){
            return reverse(prev);
        }
        if(forward!=null)
        {
            head.next=kReverse(forward, k);
        }
        return prev;
    }

    private static Node reverse(Node head){
        Node prev=null;
        Node curr=head;
        Node forward=null;
        int count =0;

        while(curr!=null)
        {
            forward=curr.next;
            curr.next=prev;
            prev=curr;
            curr=forward;
        }
        return prev;
    }


}
