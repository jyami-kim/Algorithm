package com.jyami.baekjoon;

import java.util.Scanner;

public class Main_10828_2 {

    public static Scanner sc;

    public static void main(String[] args) {
        sc = new Scanner(System.in);
        int t = sc.nextInt();
        Stack stack = new Stack();
        for (int i = 0; i < t; i++) {
            String command = sc.next();
            switch (command) {
                case "push":
                    stack.push(sc.nextInt());
                    break;
                case "pop":
                    System.out.println(stack.pop());
                    break;
                case "size":
                    System.out.println(stack.size());
                    break;
                case "empty":
                    System.out.println(stack.empty());
                    break;
                case "top":
                    System.out.println(stack.top());
                    break;
            }

        }

    }

    private static class Stack {
        private int data[] = new int[10000];
        private int size;

        public void push(int item) {
            this.data[size] = item;
            size++;
        }

        public int pop() {
            if (size == 0) {
                return -1;
            }
            int item = data[size - 1];
            data[size - 1] = 0;
            size--;
            return item;
        }

        public int top() {
            if (size == 0) {
                return -1;
            }
            return data[size - 1];
        }

        public int size() {
            return size;
        }

        public int empty() {
            if (size == 0) {
                return 1;
            }
            return 0;
        }
    }


}

