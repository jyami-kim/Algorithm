package com.jyami.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;

public class Main_10866 {
    public static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int t = Integer.parseInt(br.readLine());
        Deque deque = new Deque();
        for (int i = 0; i < t; i++) {
            String[] input = br.readLine().split(" ");
            switch (input[0]) {
                case "push_front":
                    deque.push_front(Integer.parseInt(input[1]));
                    break;
                case "push_back":
                    deque.push_back(Integer.parseInt(input[1]));
                    break;
                case "pop_front":
                    deque.pop_front();
                    break;
                case "pop_back":
                    deque.pop_back();
                    break;
                case "size":
                    deque.size();
                    break;
                case "empty":
                    deque.empty();
                    break;
                case "front":
                    deque.front();
                    break;
                case "back":
                    deque.back();
                    break;

            }
        }
        System.out.println(sb);
    }


    private static class Deque {

        public LinkedList<Integer> linkedList = new LinkedList<>();

        public void push_front(int x) {
            linkedList.addFirst(x);
        }

        public void push_back(int x) {
            linkedList.addLast(x);
        }

        public void pop_front() {
            if (linkedList.isEmpty()) {
                sb.append("-1\n");
                return;
            }
            sb.append(linkedList.removeFirst() + "\n");
        }

        public void pop_back() {
            if (linkedList.isEmpty()) {
                sb.append("-1\n");
                return;
            }
            sb.append(linkedList.removeLast() + "\n");
        }

        public void size() {
            sb.append(linkedList.size() + "\n");
        }

        public void empty() {
            int result = linkedList.isEmpty() ? 1 : 0;
            sb.append(result + "\n");
        }

        public void front() {
            if (linkedList.isEmpty()) {
                sb.append("-1\n");
                return;
            }
            sb.append(linkedList.getFirst() + "\n");
        }


        public void back() {
            if (linkedList.isEmpty()) {
                sb.append("-1\n");
                return;
            }
            sb.append(linkedList.getLast() + "\n");
        }
    }

}
