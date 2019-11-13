package com.jyami.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;

public class Main_1406_2 {

    static LinkedList<Character> list = new LinkedList<>();

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int headIndex = 0;

    public static void main(String[] args) throws IOException {
        String input = br.readLine();

        for (char ch : input.toCharArray()) {
            list.add(ch);
            headIndex++;
        }

        int t = Integer.parseInt(br.readLine());

        for (int i = 0; i < t; i++) {
            command(br.readLine());
        }
        for (char c : list) {
            System.out.print(c);
        }
    }

    public static void command(String str) throws IOException {
        switch (str) {
            case "L":
                if (headIndex != 0) {
                    headIndex--;
                }
                break;
            case "D":
                if (headIndex != list.size()) {
                    headIndex++;
                }
                break;
            case "B":
                if (headIndex != 0) {
                    list.remove(headIndex - 1);
                    headIndex--;
                }
                break;
            default:
                char text = str.split(" ")[1].charAt(0);
                list.add(headIndex, text);
                headIndex++;
                break;
        }
    }
}