package com.jyami.leetCode.problem;

/**
 * Created by jyami on 2020/07/11
 */
public class Solution430 {

    static class Node {
        public int val;
        public Node prev;
        public Node next;
        public Node child;

        public Node(int val, Node prev, Node next, Node child) {
            this.val = val;
            this.prev = prev;
            this.next = next;
            this.child = child;
        }
    }

    public Node flatten(Node head) {
        if (head == null)
            return null;
        Node prev = null;
        while (head != null) {
            if (head.child != null) {
                Node childLeftNode = flatten(head.child);
                Node childRightNode = rightMostNext(childLeftNode);
                childLeftNode.prev = head;
                childRightNode.next = head.next;
                head.child = null;
                if(head.next != null){
                    head.next.prev = childRightNode;
                }
                head.next = childLeftNode;
            }
            prev = head;
            head = head.next;
        }
        return leftMostPrev(prev);
    }

    public Node leftMostPrev(Node head) {
        while (head.prev != null) {
            head = head.prev;
        }
        return head;
    }

    public Node rightMostNext(Node head) {
        while (head.next != null) {
            head = head.next;
        }
        return head;
    }

    public static void main(String[] args) {
        //        Node node1 = new Node(1, null, null, null);
//        Node node2 = new Node(2, node1, null, null);
//        node1.next = node2;
//        Node node3 = new Node(3, node2, null, null);
//        node2.next = node3;
//        Node node4 = new Node(4, node3, null, null);
//        node3.next = node4;
//        Node node5 = new Node(5, node4, null, null);
//        node4.next = node5;
//        Node node6 = new Node(6, node5, null, null);
//        node5.next = node6;
//
//        Node node7 = new Node(7, null, null, null);
//        node3.child = node7;
//        Node node8 = new Node(8, node7, null, null);
//        node7.next = node8;
//        Node node9 = new Node(9, node8, null, null);
//        node8.next = node9;
//        Node node10 = new Node(10, node9, null, null);
//        node9.next = node10;
//
//        Node node11 = new Node(11, null, null, null);
//        node8.child = node11;
//        Node node12 = new Node(12, node11, null, null);
//        node11.next = node12;

        Node node4 = new Node(4, null, null, null);
        Node node3 = new Node(3, null, null, node4);
        Node node2 = new Node(2, null, null, node3);
        Node node1 = new Node(1, null, null, node2);

        Node flatten = new Solution430().flatten(node1);
    }

}
