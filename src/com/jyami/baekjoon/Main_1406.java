package com.jyami.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main_1406 {

    static Stack<Character> left = new Stack<>();
    static Stack<Character> right = new Stack<>();

    static BufferedReader bp = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
        String input = bp.readLine();

        for (int i = 0; i < input.length(); i++) {
            left.push(input.charAt(i));
        }

        int t = Integer.parseInt(bp.readLine());

        for (int i = 0; i < t; i++) {
            command(bp.readLine());
        }
        while (!left.empty()) {
            Character pop = left.pop();
            right.push(pop);
        }
        while (!right.empty()) {
            System.out.print(right.pop());
        }
    }

    public static void command(String str) {
        switch (str) {
            case "L":
                if (!left.empty()) {
                    Character text = left.pop();
                    right.push(text);
                }
                break;
            case "D":
                if (!right.empty()) {
                    Character text = right.pop();
                    left.push(text);
                }
                break;
            case "B":
                if (!left.empty()) {
                    left.pop();
                }
                break;
            default:
                char text = str.split(" ")[1].charAt(0);
                left.push(text);
                break;
        }
    }
}