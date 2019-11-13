package com.jyami.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_10845_2 {
    public static BufferedReader br;
    public static StringBuilder sb;

    public static void main(String[] args) throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        sb = new StringBuilder();
        int t = Integer.parseInt(br.readLine());
        Queue queue = new Queue();
        for (int i = 0; i < t; i++) {
            command(br.readLine(), queue);
        }
    }

    public static void command(String text, Queue queue) {
        switch (text) {
            case "pop":
                System.out.println(queue.pop());
                break;
            case "size":
                System.out.println(queue.size());
                break;
            case "empty":
                System.out.println(queue.empty());
                break;
            case "front":
                System.out.println(queue.front());
                break;
            case "back":
                System.out.println(queue.back());
                break;
            default:
                int temp = Integer.parseInt(text.split(" ")[1]);
                queue.push(temp);
                break;
        }
    }

    private static class Queue {
        private int data[] = new int[10000];
        private int front = 0;
        private int back = 0;

        public void push(int x) {
            data[back++] = x;
        }

        public int empty() {
            if (front == back)
                return 1;
            return 0;
        }

        public int pop() {
            if (front != back) {
                int temp = data[front];
                data[front] = 0;
                front++;
                return temp;
            }
            return -1;
        }

        public int front() {
            if (front != back)
                return data[front];
            return -1;
        }

        public int size() {
            return back - front;
        }

        public int back() {
            if (front != back)
                return data[back - 1];
            return -1;
        }
    }

}
