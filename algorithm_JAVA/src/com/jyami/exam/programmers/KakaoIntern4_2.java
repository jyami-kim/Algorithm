package com.jyami.exam.programmers;

public class KakaoIntern4_2 {
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

            BinarySearchTree binarySearchTree = new BinarySearchTree();

            long[] result = new long[room_number.length];
            for (int i = 0; i < room_number.length; i++) {
                long num = room_number[i];

                Node alloc = binarySearchTree.findNode(num);

                if (alloc == null) { //탐색이 안된경우 == 그대로 넣어도 되는 경우!
                    result[i] = num;
                    binarySearchTree.addNode(new Node(num));
                } else { //탐색 된경우 == 큰거를 하나씩 탐색!
                    binarySearchTree.inOrderTraverse(alloc);
                    result[i] = num;
                }
            }

            return result;
        }


    }

    private static class Node {
        long key;

        Node leftChild;
        Node rightChild;

        Node(long key) {
            this.key = key;
        }
    }

    static class BinarySearchTree {
        private Node root;

        public Node getRoot() {
            return this.root;
        }

        public void inOrderTraverse(Node focusNode) {
            if (focusNode != null) {
                inOrderTraverse(focusNode.leftChild);
                System.out.print(focusNode.key + " ");
                inOrderTraverse(focusNode.rightChild);
            }
        }

        public void addNode(Node newNode) {
            long key = newNode.key;
            if (root == null) {
                root = newNode; // 트리가 비어있으면 root 에 삽입
            } else {
                Node focusNode = root;  //  탐색용 노드
                Node parent;            //  탐색용 노드의 부모 노드

                while (true) {
                    parent = focusNode; //  이동

                    if (key < parent.key) {             //  삽입하려는 키가 현재 노드보다 작으면
                        focusNode = parent.leftChild;   //  왼쪽으로 이동

                        if (focusNode == null) {        //  왼쪽 노드가 비어있으면
                            parent.leftChild = newNode; //  왼쪽 노드에 삽입
                            return;
                        }
                    } else {                            //  삽입하려는 키가 현재 노드보다 크다면
                        focusNode = parent.rightChild;  //  오른쪽으로 이동

                        if (focusNode == null) {        //  오른쪽 노드가 비어있으면
                            parent.rightChild = newNode;//  오른쪽 노드에 삽입
                            return;
                        }
                    }
                }
            }
        }


        public Node findNode(long key) {

            if (root == null) return null;

            Node focusNode = root;

            while (focusNode.key != key) {
                if (key < focusNode.key) {
                    focusNode = focusNode.leftChild;
                } else {
                    focusNode = focusNode.rightChild;
                }

                // 찾으려는 노드가 없을 때
                if (focusNode == null)
                    return null;
            }

            return focusNode;
        }

    }

}
