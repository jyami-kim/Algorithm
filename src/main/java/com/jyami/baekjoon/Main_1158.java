package com.jyami.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;

public class Main_1158 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        StringBuffer sb = new StringBuffer("<");

        LinkedList<Integer> queue = new LinkedList<>();
        int t = Integer.parseInt(input[0]);
        int jump = Integer.parseInt(input[1]);

        for (int i = 0; i < t; i++) {
            queue.addLast(jump++);
            jump = getNumber(jump, t);
        }
        for (int i = 0; i < t - 1; i++) {
            Integer num = queue.removeFirst();
            sb.append(num + ", ");
            for (int j = 0; j < jump - 1; j++) {
                Integer pop = queue.removeFirst();
                queue.addLast(pop);
            }
        }
        sb.append(queue.removeFirst() + ">");
        System.out.println(sb);
    }

    public static int getNumber(int num, int divider) {
        return num % divider == 0 ? divider : num % divider;
    }
}