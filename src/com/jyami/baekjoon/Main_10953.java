package com.jyami.baekjoon;

import java.util.Scanner;

public class Main_10953 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        for (int i = 0; i < t; i++) {
            String[] st = sc.next().split(",");
            System.out.println(Integer.valueOf(st[0]) + Integer.valueOf(st[1]));
        }
    }
}
