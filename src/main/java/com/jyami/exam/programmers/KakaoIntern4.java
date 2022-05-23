package com.jyami.exam.programmers;

import java.util.List;

public class KakaoIntern4 {
    public static void main(String args[]) {
        long k = 10;
        long[] room_number = {1, 3, 4, 1, 3, 1};
        Solution solution = new Solution();
        long[] solution1 = solution.solution(k, room_number);
        for (long s : solution1) {
            System.out.println(s);
        }
    }

    static class Solution {
        public long[] solution(long k, long[] room_number) {
            long[] result = new long[room_number.length];
            boolean[] arr = new boolean[(int) k + 1];

            for (int i = 1; i <= k; i++) {
                arr[i] = false;
            }
            for (int i = 0; i < room_number.length; i++) {
                int number = (int) room_number[i];
                boolean b = arr[number];
                if (b) {
                    for (int j = number; j < k; j++) {
                        if (!arr[j]) {
                            arr[j] = true;
                            result[i] = j;
                            break;
                        }
                    }
                } else {
                    arr[number] = true;
                    result[i] = number;
                }
            }
            return result;
        }
//        static class Node {
//            int key;
//            Node left, right;
//
//            public Node(int item) {
//                key = item;
//                left = right = null;
//            }
//        }
//
//        public static void deleteBST(Node node, long key) {
//            Node p = node;
//            Node deleteNode = null;
//            Node parent = null;
//            while (p != null) {
//                if (p.key == key) {
//                    deleteNode = p;
//                    break;
//                }
//                parent = p;
//                if (p.key < key) {
//                    p = p.right;
//                } else {
//                    p = p.left;
//                }
//            }
//            if (deleteNode == null) {
//                return;
//            }
//            if (deleteNode.left == null && deleteNode.right == null) {
//                if (parent.left == deleteNode) {
//                    parent.left = null;
//                } else {
//                    parent.right = null;
//                }
//            } else if (deleteNode.left == null || deleteNode.right == null) {
//                if (deleteNode.left != null) {
//                    if (parent.left == deleteNode) {
//                        parent.left = deleteNode.left;
//                    } else {
//                        parent.right = deleteNode.left;
//                    }
//                } else {
//                    if (parent.left == deleteNode) {
//                        parent.left = deleteNode.right;
//                    } else {
//                        parent.right = deleteNode.right;
//                    }
//                }
//            } else {
//                Node q = deleteNode.left;
//                deleteNode.key = q.key;
//                deleteBST(deleteNode.left, deleteNode.key);
//            }
//        }
//
//
//        public static void insertBST(Node node, int key) {
//            Node p = node;
//            Node q = null;
//            while (p != null) {
//                q = p;
//                if (p.key < key) {
//                    p = p.right;
//                } else {
//                    p = p.left;
//                }
//            }
//            Node newNode = new Node(key);
//            if (node == null) {
//                node = newNode;
//            } else if (key < q.key) {
//                q.left = newNode;
//            } else {
//                q.right = newNode;
//            }
//        }
//
//
//        public static long searchBST(Node node, long key) {
//            if (node.key == key) {
//                deleteBST(node, key);
//                return key;
//            } else if (node.key < key) {
//                if (node.right != null) {
//                    return searchBST(node.right, key);
//                } else {
//                    deleteBST(node, key);
//                    return key;
//                }
//            } else {
//                if (node.left != null) {
//                    return searchBST(node.left, key);
//                } else {
//                    deleteBST(node, key);
//                    return key;
//                }
//            }
//        }

//        private void init(long k){
//            PriorityQueue<Room> pq = new PriorityQueue<>();
//            for(int i =1; i<=k; i++){
//                pq.offer(new Room(i, false));
//
//            }
//        }
//
//
////        class Room implements Comparable<Room>{
////            private int roomNum;
////            private boolean exist;
////
////            public Room(int roomNum, boolean exist) {
////                this.roomNum = roomNum;
////                this.exist = exist;
////            }
////
////
////        }


    }


}
