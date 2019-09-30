package com.jyami.baekjoon;

import java.util.Scanner;
import java.util.Stack;

public class Main_1874 {

    public static void main(String args[]) {
        Scanner in = new Scanner(System.in);
        StringBuilder stringBuilder = new StringBuilder();
        Stack<Integer> stack = new Stack<Integer>();

        int arrsize = in.nextInt();
        int[] arr = new int[arrsize];

        for (int i = 0; i < arrsize; i++) {
            arr[i] = in.nextInt();
        }
        int index = 0;
        for (int i = 0; i < arrsize; i++) {
            stack.push(i + 1);
            stringBuilder.append("+\n");
            while (!(stack.isEmpty()) && stack.peek() == arr[index]) {
                stack.pop();
                stringBuilder.append("-\n");
                index++;
            }
        }
        if (!stack.isEmpty())
            System.out.println("NO");
        else
            System.out.print(stringBuilder);
    }
}
