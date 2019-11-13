package com.jyami.baekjoon;

import java.io.IOException;
import java.util.Scanner;
import java.util.Stack;

public class Main_9093 {
    public static Stack<Character> stack = new Stack();
    public static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {

        Scanner sc = new Scanner(System.in);
        int t = Integer.valueOf(sc.nextLine());

        for (int i = 0; i < t; i++) {
            String[] texts = sc.nextLine().split(" ");
            for (int j = 0; j < texts.length; j++) {
                printReverse(texts[j]);
                if (j != texts.length - 1) {
                    sb.append(" ");
                }
            }
            sb.append("\n");
        }
        System.out.println(sb);
    }

    public static void printReverse(String text) {
        char[] chars = text.toCharArray();
        for (char c : chars) {
            stack.push(c);
        }
        while (!stack.empty()) {
            sb.append(stack.pop());
        }
    }


}
