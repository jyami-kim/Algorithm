package com.jyami.baekjoon;

import java.util.ArrayList;
import java.util.Scanner;

public class Main_10828 {
    static StringBuilder stringBuilder = new StringBuilder();
    static ArrayList<Integer> stack = new ArrayList<Integer>();
    static int top;

    public static void push(int num) {
        stack.add(num);
        top++;
    }

    public static int pop() {
        if (top != -1) {
            return stack.remove(top--);
        }
        return -1;

    }

    public static int isEmpty() {
        if (stack.size() == 0) {
            return 1;
        }
        return 0;
    }

    public static int top() {
        if (top != -1)
            return stack.get(top);
        return -1;
    }

    public static void main(String args[]) {
        int input, number;
        String command;
        Scanner in = new Scanner(System.in);
        input = in.nextInt();
        top = -1;
        for (int i = 0; i < input; i++) {
            command = in.next();
            switch (command) {
                case "push":
                    number = in.nextInt();
                    push(number);
                    break;
                case "size":
                    stringBuilder.append(stack.size()).append("\n");
                    break;
                case "empty":
                    stringBuilder.append(isEmpty()).append("\n");
                    break;
                case "pop":
                    stringBuilder.append(pop()).append("\n");
                    break;
                case "top":
                    stringBuilder.append(top()).append("\n");
                    break;
            }
        }
        System.out.print(stringBuilder.toString());
    }
}
