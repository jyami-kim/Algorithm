package com.jyami.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_1158 {

    private static class Link {
        int value;
        Link before;
        Link next;

        public Link(int value, Link next, Link before) {
            this.value = value;
            this.before = before;
            this.next = next;
        }
    }

    public static int getNumber(int number, int t) {
        int a = number % t;
        if (a == 0)
            return t;
        return a;
    }

    public static void main(String[] args) throws IOException {
        StringBuilder sb = new StringBuilder("<");

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input[] = br.readLine().split(" ");
        int t = Integer.parseInt(input[0]);
        int jump = Integer.parseInt(input[1]);
        int temp = jump;

        Link start = new Link(getNumber(temp++, t), null, null);
        Link link = start;
        for (int i = 1; i < t; i++) {
            Link newLink = new Link(getNumber(temp++, t), null, link);
            link.next = newLink;
            link = newLink;
        }
        link.next = start;
        start.before = link;
        Link now = start;
        Link before = link;
        while (before != now) {
            sb.append(now.value + ", ");
            before.next = now.next;
            now.next.before = now.before;
            for (int i = 0; i < jump; i++) {
                before = now.before;
                now = now.next;
            }
        }
        sb.append(now.value + ">");

        System.out.println(sb);
    }
}
