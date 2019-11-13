package com.jyami.baekjoon;

import java.util.Scanner;
import java.util.Stack;

public class Main_1874_2 {
    static Scanner sc;

    public static void main(String[] args) {
        sc = new Scanner(System.in);
        int n = sc.nextInt();
        int index = 1;
        StringBuilder sb = new StringBuilder();
        Stack<Integer> stack = new Stack();

        for (int i = 1; i <= n; i++) {
            int num = sc.nextInt();
            if (index <= num) {
                while (index <= num) {
                    stack.push(index++);
                    sb.append("+\n");
                }
                stack.pop();
                sb.append("-\n");
            } else {
                if (stack.peek() == num) {
                    stack.pop();
                    sb.append("-\n");
                } else {
                    System.out.println("NO");
                    return;
                }
            }
        }
        System.out.println(sb);
    }
}
